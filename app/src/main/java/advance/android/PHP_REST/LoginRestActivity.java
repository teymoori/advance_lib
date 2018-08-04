package advance.android.PHP_REST;

import android.content.Intent;

import com.orhanobut.hawk.Hawk;

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


@EActivity(R.layout.activity_login_rest)
public class LoginRestActivity extends BaseActivity {

    @ViewById
    MyEditText username, password;


    @Click
    void login() {
        dialog.show();
        Gen.phpEndPoints.login(username.text(),
                password.text()).enqueue(new Callback<RestUserModel>() {
            @Override
            public void onResponse(Call<RestUserModel> call, Response<RestUserModel> response) {
                int statusCode = response.code();



                Gen.toast(statusCode+"");
                if (statusCode == 404)
                    Gen.toast("user pass wrong");
                else{
                    Gen.toast(response.body().getToken());
                    Hawk.put("token" , response.body().getToken()) ;
                    startActivity(new Intent(mContext , RestOrdersListActivity_.class));
                }

                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<RestUserModel> call, Throwable t) {
                Gen.toast("Failed");
                dialog.dismiss();
            }
        });
    }

}
