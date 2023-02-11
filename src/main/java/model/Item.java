package model;

import com.google.gson.annotations.SerializedName;

public abstract class Item {
    @SerializedName("user_id")
    private Long id;

    public Long getId() {
        return id;
    }
}
