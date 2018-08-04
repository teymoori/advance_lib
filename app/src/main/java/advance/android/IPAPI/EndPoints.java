package advance.android.IPAPI;

import advance.android.Retrofit.DTO.YahooModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EndPoints {

    @GET("json")
    Call<IPAPIModel> getDetails( ) ;




}
