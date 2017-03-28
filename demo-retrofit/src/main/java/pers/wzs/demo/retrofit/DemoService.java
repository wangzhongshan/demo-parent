package pers.wzs.demo.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by wangzhongshan on 2017/3/17.
 */
public interface DemoService {

    @GET("users/{user}/repos")
    Call<Repo> listRepos(@Path("user") String user);

    @GET("user")
    Call<UserUrl> currentUserUrl();
}
