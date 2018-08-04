package advance.android.MVPWeather;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import advance.android.R;
import advance.android.Retrofit.DTO.YahooModel;
import advance.android.customViews.MyEditText;
import advance.android.customViews.MyTextView;
import advance.android.utils.BaseActivity;
import advance.android.utils.Gen;


@EActivity(R.layout.activity_weather_mvp)
public class WeatherMVPActivity extends BaseActivity
        implements Contract.View {

    Presenter presenter = new Presenter();

    @ViewById
    MyTextView result;

    @ViewById
    MyEditText city;

    @AfterViews
    void init() {
        presenter.attachView(this);
    }

    @Click
    void show() {
        presenter.getWeather(city.text());
    }


    @Override
    public void onWeatherReceived(YahooModel model) {
        result.setText(
                model.getQuery().getResults().getChannel()
                        .getItem().getCondition().getTemp()
        );
    }

    @Override
    public void failed(String msg) {
        Gen.toast(msg);
    }

    @Override
    public void showLoading(boolean show) {
        if(show)
            dialog.show();
        else
            dialog.dismiss();
    }

}
