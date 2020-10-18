package NetworkClientServer.clientserver.commands;

import java.io.Serializable;
import java.util.List;

public class UpdateUsersListCommandData implements Serializable {
    private final List<String> users;

    public UpdateUsersListCommandData(List<String> users) {
        this.users = users;
    }

    public UpdateUsersListCommandData(Object users, List<String> users1) {

        this.users = users1;
    }

    public List<String> getUsers() {
        return users;
    }
}
