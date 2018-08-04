package advance.android.DAGGER2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import advance.android.R;
import advance.android.utils.BaseApplication;

public class SecondDaggerActivity extends AppCompatActivity {

    @Inject
    StudentHandler std ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_dagger);

        BaseApplication.getMySecondComponent()
                .inject(this);
    }
}
