package advance.android.PHP_REST;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.orhanobut.hawk.Hawk;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import advance.android.R;
import advance.android.utils.BaseActivity;
import advance.android.utils.Gen;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EActivity(R.layout.activity_rest_orders_list)
public class RestOrdersListActivity extends BaseActivity {

    @ViewById
    ListView ordersList;

    @Click
    void logout(){
        Hawk.delete("token") ;
        startActivity(new Intent(mContext , LoginRestActivity_.class));
        finish();
    }
    @AfterViews
    void init() {
        String token = Hawk.get("token");
        Gen.phpEndPoints.getOrders(token)
                .enqueue(new Callback<List<OrdersModel>>() {
                    @Override
                    public void onResponse(Call<List<OrdersModel>> call, Response<List<OrdersModel>> response) {
                        List<OrdersModel> orders = response.body();
                        if (orders.size() > 0) {
                            OrdersListAdapter adapter =
                                    new OrdersListAdapter(mContext
                                            , orders);
                            ordersList.setAdapter(adapter);
                        } else
                            Gen.toast("no item found");
                    }

                    @Override
                    public void onFailure(Call<List<OrdersModel>> call, Throwable t) {
                        Gen.toast("Error in connecting");
                    }
                });
    }

}
