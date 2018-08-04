package advance.android.MVPWeather;

import advance.android.Retrofit.DTO.YahooModel;

public class Presenter implements Contract.Presenter {
    private Contract.View view;
    Model model = new Model();

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
        model.attachPresenter(this);
    }

    @Override
    public void getWeather(String city) {
        model.getWeather(city);
        view.showLoading(true);
    }


    @Override
    public void onWeatherReceived(YahooModel model) {
        view.onWeatherReceived(model);
        view.showLoading(false);
    }

    @Override
    public void failed(String msg) {
        view.failed(msg);
        view.showLoading(false);
    }
}
