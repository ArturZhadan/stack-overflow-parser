package service;

import controller.StackOverflowController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Tag;
import model.User;

public class Parser {
    private static final String LOCATION_ROMANIA = "Romania";
    private static final String LOCATION_MOLDOVA = "Moldova";
    private static final Integer REPUTATION = 223;
    private static final Integer ANSWER = 1;
    private static final List<String> TAGS = Arrays.asList("java", ".net", "docker", "C#");
    private static final String DELIMITER = ", ";
    private final StackOverflowController stackOverflowController;

    public Parser(StackOverflowController stackOverflowController) {
        this.stackOverflowController = stackOverflowController;
    }

    public void parseUsersData() {
        List<User> usersFromApi = stackOverflowController.getUsersFromApi();
        if (usersFromApi != null) {
            for (User user: usersFromApi) {
                StringBuilder stringBuilder = new StringBuilder();
                if (!parseTagsData(user.getId()).isEmpty() && (user.getLocation() != null
                        && (user.getLocation().contains(LOCATION_ROMANIA)
                        || user.getLocation().contains(LOCATION_MOLDOVA)))
                        && (user.getReputation() != null && user.getReputation() >= REPUTATION)
                        && (user.getAnswerCount() != null && user.getAnswerCount() >= ANSWER)) {
                    stringBuilder.append("User ID -> ").append(user.getId())
                       .append(System.lineSeparator());
                    stringBuilder.append("User name -> ").append(user.getUserName())
                       .append(System.lineSeparator());
                    stringBuilder.append("Location -> ").append(user.getLocation())
                       .append(System.lineSeparator());
                    stringBuilder.append("Answer count -> ").append(user.getAnswerCount())
                       .append(System.lineSeparator());
                    stringBuilder.append("Question count -> ").append(user.getQuestionCount())
                       .append(System.lineSeparator());
                    stringBuilder.append("Tags -> ").append(parseTagsData(user.getId()))
                       .append(System.lineSeparator());
                    stringBuilder.append("Link to profile -> ").append(user.getLinkToProfile())
                       .append(System.lineSeparator());
                    stringBuilder.append("Link to avatar -> ").append(user.getLinkToAvatar())
                       .append(System.lineSeparator());
                    stringBuilder.append("-------------------------------------------------");
                }
                if (!stringBuilder.toString().isEmpty()) {
                    System.out.println(stringBuilder);
                }
            }
        }
    }

    private String parseTagsData(Long userId) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Tag> tagsFromApi = stackOverflowController.getTagsFromApi(userId);
        List<String> tagsNames = new ArrayList<>();
        for (Tag tag : tagsFromApi) {
            tagsNames.add(tag.getTagName());
        }
        for (int i = 0; i < tagsNames.size(); i++) {
            if (TAGS.stream().anyMatch(tagsNames::contains)) {
                stringBuilder.append(tagsFromApi.get(i).getTagName());
            } else {
                break;
            }
            if (i < tagsFromApi.size() - 1) {
                stringBuilder.append(DELIMITER);
            }
        }
        return stringBuilder.toString();
    }
}
