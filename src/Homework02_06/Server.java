package Homework02_06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) throws IOException {
        int port = SERVER_PORT;
        if (args.length != 0) {
            port = Integer.parseInt(args[0]);
        }
        new Server().startServer(port);
    }

    public void startServer(int port) throws IOException {
        ServerSocket socket = null;
        Socket clientSocket = null;
        Thread inputThread = null;

        try {
            socket = new ServerSocket(port);
            socket.setSoTimeout(1000000);

            System.out.println("Server online.");
            clientSocket = socket.accept();
            System.out.println("Client connected to server.");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            inputThread = runInputThread(in);
            runOutputLoop(out);

            System.out.println("Server has been closed");


        } catch (IOException e) {
            System.err.println("Already exits");
            e.printStackTrace();
        } finally {
            if (inputThread != null) inputThread.interrupt();
            if (clientSocket != null) clientSocket.close();
            if (socket != null) socket.close();
        }
    }

    private void runOutputLoop(DataOutputStream out) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.next();
            out.writeUTF(message);
            if (message.equals("/end")) {
                break;
            }
        }
    }

    private Thread runInputThread(DataInputStream in) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = in.readUTF();
                    System.out.println("From client: " + message);
                    if (message.equals("/end")) {
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println("Connection was closed");
                    break;
                }
            }
        });
        thread.start();
        return thread;
    }
}