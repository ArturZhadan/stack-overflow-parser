package model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserItem {
    @SerializedName("items")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Item{"
                + "users=" + users
                + '}';
    }
}
