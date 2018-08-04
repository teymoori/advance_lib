package advance.android.realmMVP;

import java.util.List;

import advance.android.realm.CarModel;

public class Presenter implements Contract.Presenter {
    private Contract.View view;
    Contract.Model model = new Model();

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
        model.attachPresenter(this);
        model.getCars();
    }

    @Override
    public void saveCar(CarModel car) {
        model.saveCar(car);
        model.getCars();
    }

    @Override
    public void onCarsReceived(List<CarModel> cars) {
        view.showCars(cars);
    }
}
