package advance.android.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import advance.android.R;
import advance.android.utils.Gen;

public class TestCustomViewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_custom_views);

        Gen.log("test_release", "Hi From Release Mode");



    }
}
