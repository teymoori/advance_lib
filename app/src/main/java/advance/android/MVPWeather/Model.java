package advance.android.MVPWeather;

import advance.android.Retrofit.DTO.YahooModel;
import advance.android.utils.Gen;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model implements Contract.Model {
    private Contract.Presenter presenter;

    @Override
    public void attachPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getWeather(String city) {
        String query = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"" + city + "\")";
        Gen.endPoints.getWeather(query, "json")
                .enqueue(new Callback<YahooModel>() {
                    @Override
                    public void onResponse(Call<YahooModel> call, Response<YahooModel> response) {
                        if (response.body().getQuery().getCount() == 1)
                            presenter.onWeatherReceived(response.body());
                        else
                            presenter.failed("city not found");
                    }

                    @Override
                    public void onFailure(Call<YahooModel> call, Throwable t) {
                        presenter.failed(t.toString());
                    }
                });
    }


}
