package advance.android.PHP_REST;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PHPEndPoints {

    @FormUrlEncoded
    @POST("advance/rest.php")
    Call<Void> register(
            @Field("username") String username,
            @Field("password") String password,
            @Field("mobile") String mobile
    );

    @FormUrlEncoded
    @POST("advance/login.php")
    Call<RestUserModel> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("advance/orders.php")
    Call<List<OrdersModel>> getOrders(
            @Field("token") String token
    );


}
