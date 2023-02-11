package model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TagItem {
    @SerializedName("items")
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "TagItem{"
                + "tags=" + tags
                + '}';
    }
}
