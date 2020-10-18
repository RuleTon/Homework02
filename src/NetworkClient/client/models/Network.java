package NetworkClient.client.models;

import NetworkClient.client.controllers.ViewController;
import NetworkClientServer.clientserver.Command;
import NetworkClientServer.clientserver.commands.*;
import javafx.application.Platform;

import java.io.*;
import java.net.Socket;

public class Network {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8189;

    private final String host;
    private final int port;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Socket socket;
    private String username;

    public Network() {
        this(SERVER_ADDRESS, SERVER_PORT);
    }

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public boolean connect() {
        try {
            socket = new Socket(host, port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            return true;
        } catch (IOException e) {
            System.err.println("Соединение не было установлено!");
            e.printStackTrace();
            return false;
        }
    }

    public String sendAuthCommand(String login, String password) {
        try {
            Command authCommand = Command.authCommand(login, password);
            getOutputStream().writeObject(authCommand);
            Command command = readCommand();
            if (command == null) {
                return "Failed to read command server";

            }
            switch (command.getType()){
                case AUTH_OK:{
                    AuthOkCommandData data = (AuthOkCommandData) command.getData();

                    this.username = data.getUsername();
                    return null;

                }
                case AUTH_ERROR: {
                    AuthErrorCommandData data = (AuthErrorCommandData) command.getData();
                    return data.getErrorMessage();

                }
                default:
                    return "Unknown type command: " + command.getType();

            }

        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public void sendMessage (Command message) throws IOException {
        Command command = Command.publicMessageCommand(username, message);
        sendCommand(command);
    }

    private void sendCommand(Command command) throws IOException{
        outputStream.writeObject(command);
    }

    public void sendPrivateMessage(String message, String recipient) throws IOException {
        Command command = Command.privateMessageCommand(recipient, message);
        sendCommand(command);
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public void waitMessages(ViewController viewController) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Command command = readCommand();
                        if (command == null) {
                            viewController.showError("Server error", "Invalid command");
                            continue;

                        }
                        switch (command.getType()) {
                            case INFO_MESSAGE: {
                                MessageInfoCommandData data = (MessageInfoCommandData) command.getData();
                                String message = data.getMessage();
                                String sender = data.getSender();
                                String formattedMsg = sender != null ? String.format("%s: %s", sender, message) : message;
                                Platform.runLater(() -> {
                                    viewController.appendMessage(formattedMsg);
                                });
                                break;
                            }
                            case UPDATE_USERS_LIST: {
                                UpdateUsersListCommandData data = (UpdateUsersListCommandData) command.getData();
                                Platform.runLater(() -> {
                                    viewController.updateUsers(data.getUsers());
                                });
                                break;
                            }

                            case ERROR: {
                                ErrorCommandData data = (ErrorCommandData) command.getData();
                                String errorMessage = data.getErrorMessage();
                                Platform.runLater(() -> {
                                    viewController.appendMessage("Server error " + errorMessage);
                                });
                                break;

                            }
                            default:{
                                Platform.runLater(() -> {
                                    viewController.appendMessage("Unknown command " + command.getType().toString());
                                });
                            }

                        }
                       }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Соединение было потеряно!");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setChatMode() {
        waitMessages(null);
    }

    public String getUsername() {
        return username;
    }

    private Command readCommand() throws IOException {
        try {
            return (Command) inputStream.readObject();

        }
        catch (ClassNotFoundException e) {
            String errorMessage = "Unknown type object!";
            System.err.println(errorMessage);
            e.printStackTrace();
            sendMessage(Command.errorCommand(errorMessage));
            return null;
        }
    }
}
