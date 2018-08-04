package advance.android.realmMVP;

import java.util.List;

import advance.android.realm.CarModel;

public interface Contract {

    interface View {
        void showCars(List<CarModel> cars) ;
    }

    interface Presenter {
        void attachView(View view);

        void saveCar(CarModel car);

        void onCarsReceived(List<CarModel> cars);
    }

    interface Model {
        void attachPresenter(Presenter presenter);

        void saveCar(CarModel car);

        void getCars();
    }

}
