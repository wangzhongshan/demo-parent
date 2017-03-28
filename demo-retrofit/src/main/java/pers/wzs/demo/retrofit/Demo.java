package pers.wzs.demo.retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by wangzhongshan on 2017/3/17.
 */
public class Demo {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

//        DemoService service = retrofit.create(DemoService.class);
//        Call<Repo> repos = service.listRepos("octocat");
        DemoService demoService = retrofit.create(DemoService.class);
        Call<UserUrl> currentUserUrl = demoService.currentUserUrl();

        System.out.println(currentUserUrl);
    }
}
