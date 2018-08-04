package advance.android.Retrofit;

import advance.android.Retrofit.DTO.YahooModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EndPoints {

    @GET("yql/")
    Call<YahooModel> getWeather(
            @Query("q") String query ,
            @Query("format") String format
    ) ;

    @FormUrlEncoded
    @POST("register/")
    Call<YahooModel> register(
            @Field("username") String username ,
            @Field("password") String password
    ) ;



}
