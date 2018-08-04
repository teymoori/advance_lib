package advance.android.DAGGER;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import advance.android.R;
import advance.android.utils.BaseApplication;

public class MyDaggerActivity extends AppCompatActivity {


    @Inject
    SharedPreferences shared ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dagger);

        BaseApplication.getMyComponent().inject(this);


    }
}
