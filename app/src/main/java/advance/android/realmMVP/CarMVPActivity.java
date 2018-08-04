package advance.android.realmMVP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import advance.android.R;
import advance.android.customViews.MyEditText;
import advance.android.realm.CarModel;
import advance.android.realm.CarsAdapter;
import advance.android.utils.BaseActivity;
import io.realm.Realm;

public class CarMVPActivity extends BaseActivity
        implements Contract.View {

    MyEditText carName, carPrice, carModel;
    Realm realm = Realm.getDefaultInstance();
    ListView list;

    Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_mvp);
        bind();
        presenter.attachView(this);

    }

    void bind() {
        list = findViewById(R.id.list);
        carName = findViewById(R.id.carName);
        carPrice = findViewById(R.id.carPrice);
        carModel = findViewById(R.id.carModel);
        findViewById(R.id.save).setOnClickListener(V -> {
            save();
        });
    }

    void save() {
        CarModel car = new CarModel(
                carName.text(),
                carModel.text(),
                Integer.parseInt(carPrice.text())
        );
        presenter.saveCar(car);
    }

    @Override
    public void showCars(List<CarModel> cars) {
        CarsAdapter adapter = new CarsAdapter(
                mContext, cars
        );
        list.setAdapter(adapter);
    }
}
