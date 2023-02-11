package model;

import com.google.gson.annotations.SerializedName;

public class Tag extends Item {
    @SerializedName("name")
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    @Override
    public String toString() {
        return "Tag{"
                + "tagName='" + tagName + '\''
                + '}';
    }
}
