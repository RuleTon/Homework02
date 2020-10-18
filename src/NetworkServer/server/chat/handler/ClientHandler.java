package NetworkServer.server.chat.handler;

import NetworkClientServer.clientserver.Command;
import NetworkClientServer.clientserver.CommandType;
import NetworkClientServer.clientserver.commands.AuthCommandData;
import NetworkClientServer.clientserver.commands.PrivateMessageCommandData;
import NetworkClientServer.clientserver.commands.PublicMessageCommandData;
import NetworkServer.server.chat.MyServer;
import sun.plugin2.liveconnect.ArgumentHelper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.Socket;

public class ClientHandler {

    private final MyServer myServer;
    private final Socket clientSocket;

    

    private String username;
    private DataOutputStream out;
    private Object in;

    public ClientHandler(MyServer myServer, Socket clientSocket) {
        this.myServer = myServer;
        this.clientSocket = clientSocket;
    }

    public void handle() throws IOException {
        in  = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());

        new Thread(() -> {
            try {
                authentication();
                readMessages();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    closeConnection();
                } catch (IOException e) {
                    System.err.println("Failed to close connection!");
                }
            }
        }).start();
    }

    public String getUsername() {
        return username;
    }

    private void readMessages() throws IOException {
        while (true) {
            Command command = readCommand();
            if (command == null) {
                continue;
            }
            switch (command.getType()) {
                case END:
                    return;
                case PRIVATE_MESSAGE: {
                   PrivateMessageCommandData data = (PrivateMessageCommandData) command.getData();
                   String recipient = data.getReceiver();
                   String privateMessage = data.getMessage();
                   myServer.sendPrivateMessage(recipient, Command.messageInfoCommand(privateMessage, username));
                   break;
                }
                case PUBLIC_MESSAGE:{
                    PublicMessageCommandData data = (PublicMessageCommandData) command.getData();
                    String message = data.getMessage();
                    String sender = data.getSender();
                    myServer.broadcastMessage(this, Command.messageInfoCommand(message, sender ));
                    break;

                }
                default:
                    System.err.println("Unknown command: " + command.getType());

            }

        }
    }

    private Command readCommand() throws IOException {
        try {
            return (Command) in.readObject();

        }
        catch (ClassNotFoundException e) {
            String errorMessage = "Unknown type object!";
            System.err.println(errorMessage);
            e.printStackTrace();
            sendMessage(Command.errorCommand(errorMessage));
            return null;
        }
    }

    private void authentication() throws IOException {
        while (true) {
            Command command = readCommand();
            if (command == null) {
                continue;
            }

            if (command.getType() == CommandType.AUTH) {
             boolean isSuccessAuth = processAuthCommand(command);
             if (isSuccessAuth) {
                 break;
             }

            }
            else
                {
                sendMessage(Command.authErrorCommand(" Auth is required!"));
            }

        }
    }


    private void closeConnection() throws IOException {
        myServer.unsubscribe(this);
        clientSocket.close();
    }

    private boolean   processAuthCommand(Command command) throws IOException {
        AuthCommandData cmdData;
        cmdData = (AuthCommandData) command.getData();
        String login = cmdData.getLogin();
        String password = cmdData.getPassword();
        this.username = myServer.getAuthService().getUsernameByLoginAndPassword(login, password);
        if (username != null) {
            if (myServer.isNicknameAlreadyBusy(username)) {
                sendMessage(Command.authErrorCommand("Login and password are already used!"));
                return false;
            }
            sendMessage(Command.authOkCommand(username));
            String message = username + "joined to chat!";
            myServer.broadcastMessage(this, Command.messageInfoCommand(message, null));
            myServer.subscribe(this);
            return true;
        } else {
            sendMessage(Command.authErrorCommand(" Login and/or password are invalid! Please, try again"));
            return false;
        }

    }

    public void sendMessage(Command command) throws IOException {
        out.writeObject();
    }
}

