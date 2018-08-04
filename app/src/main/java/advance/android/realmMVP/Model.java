package advance.android.realmMVP;

import advance.android.realm.CarModel;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class Model implements Contract.Model {
    private Contract.Presenter presenter;
    Realm realm = Realm.getDefaultInstance();
    @Override
    public void attachPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void saveCar(CarModel car) {

        realm.beginTransaction();
        realm.copyToRealm(car);
        realm.commitTransaction();

    }

    @Override
    public void getCars() {
        RealmResults<CarModel> cars = realm.where(CarModel.class)
                .findAll();
        presenter.onCarsReceived(cars);
    }
}
