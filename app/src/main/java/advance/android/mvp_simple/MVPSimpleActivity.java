package advance.android.mvp_simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import advance.android.R;
import advance.android.customViews.MyButton;
import advance.android.customViews.MyTextView;
import advance.android.utils.BaseActivity;
import advance.android.utils.Gen;

public class MVPSimpleActivity extends BaseActivity

implements Contract.View{
    TextView result ;

    Contract.Presenter presenter = new Presenter() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpsimple);
        presenter.attachView(this);
        result = findViewById(R.id.result) ;
        findViewById(R.id.show).setOnClickListener(V->{
            presenter.onClick();
        });
    }

    @Override
    public void showResult(String response) {
        Gen.toast(response);
        result.setText(response);
    }
}
