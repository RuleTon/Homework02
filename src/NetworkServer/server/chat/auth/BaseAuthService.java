package NetworkServer.server.chat.auth;

import NetworkServer.server.chat.User;
import javafx.collections.FXCollections;

import java.util.List;

public class BaseAuthService implements AuthService {

    private static final List<User> USERS = FXCollections.observableArrayList(
            new User("login1", "pass1", "Oleg"),
            new User("login2", "pass2", "Alexey"),
            new User("login3", "pass3", "Peter")
    );

    @Override
    public void start() {
        System.out.println("Auth service has been started");
    }

    @Override
    public void stop() {
        System.out.println("Auth service has been finished");
    }

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        for (User user : USERS) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user.getUsername();
            }
        }

        return null;
    }
}
