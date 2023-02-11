package controller;

import configuration.RetrofitConfiguration;
import exception.DataProcessingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Tag;
import model.TagItem;
import model.User;
import model.UserItem;
import retrofit2.Call;
import retrofit2.Response;
import service.StackOverflowService;

public class StackOverflowController {
    private static final Integer PAGE = 1;
    private static final Integer PAGE_SIZE = 30;
    private static final String ORDER = "desc";
    private static final String USERS_SORT = "reputation";
    private static final String TAGS_SORT = "popular";
    private static final String SITE = "stackoverflow";
    private static final String USERS_FILTER = "!UtVGYfZ4zl)r4C.wpJP9l7yE0i16";
    private static final String TAGS_FILTER = "!.2uXKJzxnp7R_2eM";
    private static final Integer NUMBER_OF_PAGES = Integer.MAX_VALUE;
    private final StackOverflowService stackOverflowService;

    public StackOverflowController() {
        this.stackOverflowService = RetrofitConfiguration.getRetrofit()
                .create(StackOverflowService.class);
    }

    public List<User> getUsersFromApi() {
        List<User> users = new ArrayList<>();
        for (int i = PAGE; i < NUMBER_OF_PAGES; i++) {
            Call<UserItem> usersItemList = stackOverflowService.getUsersList(i, PAGE_SIZE,
                                                            ORDER, USERS_SORT, SITE, USERS_FILTER);
            try {
                Response<UserItem> response = usersItemList.execute();
                List<User> usersFromApi = response.body().getUsers();
                users.addAll(usersFromApi);
            } catch (IOException e) {
                throw new DataProcessingException("Can`t get users from api ", e);
            }
        }
        return users;
    }

    public List<Tag> getTagsFromApi(Long userId) {
        List<Tag> tags = new ArrayList<>();
        for (int i = PAGE; i < NUMBER_OF_PAGES; i++) {
            Call<TagItem> tagsItemList = stackOverflowService.getTagsList(userId, i, PAGE_SIZE,
                    ORDER, TAGS_SORT, SITE, TAGS_FILTER);
            try {
                Response<TagItem> response = tagsItemList.execute();
                List<Tag> tagsFromApi = response.body().getTags();
                if (!tagsFromApi.isEmpty()) {
                    tags.addAll(tagsFromApi);
                }
            } catch (IOException e) {
                throw new DataProcessingException(
                        "Can`t get tags from api by user id " + userId, e);
            }
        }
        return tags;
    }
}



