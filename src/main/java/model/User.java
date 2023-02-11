package model;

import com.google.gson.annotations.SerializedName;

public class User extends Item {
    @SerializedName("display_name")
    private String userName;
    @SerializedName("location")

    private String location;
    @SerializedName("reputation")
    private Long reputation;
    @SerializedName("answer_count")
    private Long answerCount;
    @SerializedName("question_count")
    private Long questionCount;
    @SerializedName("link")

    private String linkToProfile;
    @SerializedName("profile_image")

    private String linkToAvatar;

    public String getUserName() {
        return userName;
    }

    public String getLocation() {
        return location;
    }

    public Long getReputation() {
        return reputation;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public Long getQuestionCount() {
        return questionCount;
    }

    public String getLinkToProfile() {
        return linkToProfile;
    }

    public String getLinkToAvatar() {
        return linkToAvatar;
    }

    @Override
    public String toString() {
        return "User{"
                + "userName='" + userName + '\''
                + ", location='" + location + '\''
                + ", reputation=" + reputation
                + ", answerCount=" + answerCount
                + ", questionCount=" + questionCount
                + ", linkToProfile='" + linkToProfile + '\''
                + ", linkToAvatar='" + linkToAvatar + '\''
                + '}';
    }
}
