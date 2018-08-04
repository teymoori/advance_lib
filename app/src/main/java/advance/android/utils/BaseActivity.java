package advance.android.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public Context mContext = this;
    public Activity mActivity = this;

    public String TAG = getClass().getSimpleName()+"_debug";

    public ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(this);
        dialog.setTitle("loading");
        dialog.setMessage("please wait to load");
    }


}
