package advance.android.IPAPI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import advance.android.R;
import advance.android.customViews.MyTextView;
import advance.android.utils.BaseActivity;

@EActivity(R.layout.activity_ipapi)
public class IPAPIActivity extends BaseActivity
        implements Contract.View {

    @ViewById
    MyTextView result;

    Contract.Presenter presenter = new Presenetr();

    @AfterViews
    void init() {
        presenter.attachView(this);
    }


    @Override
    public void onReceiveDetail(IPAPIModel model) {
        result.setText(
                model.getCountry() +  " " + model.getCity()
        );
    }
}
