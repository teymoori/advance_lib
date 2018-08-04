package advance.android.AndroidAnnotations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import advance.android.R;
import advance.android.customViews.MyEditText;
import advance.android.utils.BaseActivity;
import advance.android.utils.Gen;


@EActivity(R.layout.activity_annotations)
public class AnnotationsActivity extends BaseActivity {


    @ViewById
    MyEditText username,password ;

    @Click
    @UiThread(delay = 3000)
    void save(){
        Gen.toast(username.text() + " " + password.text());
    }

}
