package service;

import model.TagItem;
import model.UserItem;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StackOverflowService {
    @GET("users?")
    Call<UserItem> getUsersList(@Query("page") Integer page,
                                @Query("pagesize") Integer size,
                                @Query("order") String order,
                                @Query("sort") String sort,
                                @Query("site") String site,
                                @Query("filter") String filter);

    @GET("users/{ids}/tags?")
    Call<TagItem> getTagsList(@Path("ids") Long ids,
                              @Query("page") Integer page,
                              @Query("pagesize") Integer size,
                              @Query("order") String order,
                              @Query("sort") String sort,
                              @Query("site") String site,
                              @Query("filter") String filter);
}
