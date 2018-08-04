package advance.android.MVPWeather;

import advance.android.Retrofit.DTO.YahooModel;

public interface Contract {

    interface View {
        void onWeatherReceived(YahooModel model);
        void failed(String msg) ;
        void showLoading(boolean show) ;

    }

    interface Presenter {
        void attachView(View view);
        void getWeather(String query) ;
        void onWeatherReceived(YahooModel model);
        void failed(String msg) ;
    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void getWeather(String query) ;
    }
}
