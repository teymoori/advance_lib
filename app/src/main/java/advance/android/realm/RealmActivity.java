package advance.android.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import advance.android.R;
import advance.android.customViews.MyEditText;
import advance.android.utils.BaseActivity;
import advance.android.utils.Gen;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmActivity extends BaseActivity {
    MyEditText carName, carPrice, carModel;
    Realm realm = Realm.getDefaultInstance();
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        bind();
    }

    void bind() {
        list = findViewById(R.id.list);
        carName = findViewById(R.id.carName);
        carPrice = findViewById(R.id.carPrice);
        carModel = findViewById(R.id.carModel);
        findViewById(R.id.save).setOnClickListener(V -> {
            save();
        });
        getCars();
    }

    void save() {
        String name = carName.text();
        int price = Integer.parseInt(carPrice.text());
        String model = carModel.text();

        CarModel car = new CarModel(name, model, price);

        realm.beginTransaction();
        realm.copyToRealm(car);
        realm.commitTransaction();
        clean();
        Gen.toast("new Car has been saved");
        getCars();
    }

    void clean() {
        carName.setText("");
        carPrice.setText("");
        carModel.setText("");
    }


    void getCars() {
        RealmResults<CarModel> cars = realm.where(CarModel.class)
                .findAll();
        CarsAdapter adapter = new CarsAdapter(
                mContext, cars
        );
        list.setAdapter(adapter);

    }
}
