package advance.android.PHP_REST;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orhanobut.hawk.Hawk;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import advance.android.R;
import advance.android.customViews.MyEditText;
import advance.android.utils.BaseActivity;
import advance.android.utils.Gen;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@EActivity(R.layout.activity_register_rest)
public class RegisterRestActivity extends BaseActivity {

    @ViewById
    MyEditText username, password, mobile;


    @AfterViews
    void init(){
        String token = Hawk.get("token" , null) ;
        if (token != null) {
            startActivity(new Intent(mContext , RestOrdersListActivity_.class));
        }
    }

    @Click
    void register() {
        dialog.show();
        Gen.phpEndPoints.register(username.text(),
                password.text(),
                mobile.text()).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 200)
                    Gen.toast("user has been registered");
                else
                    Gen.toast("error in registering");

                dialog.dismiss();
                username.setText("");
                password.setText("");
                mobile.setText("");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Gen.toast("error in registering");
                dialog.dismiss();
            }
        });
    }

    @Click
    void login(){
        startActivity(new Intent(mContext , LoginRestActivity_.class));
    }

}
