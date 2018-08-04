package advance.android.recyclerPro;

import android.util.Log;

import advance.android.recyclerPro.entities.FoodModel;
import io.realm.Realm;
import io.realm.RealmResults;

public class Model implements Contract.Model {
    private Contract.Presenter presenter;
    Realm realm = Realm.getDefaultInstance();


    @Override
    public void attachPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void saveFood(FoodModel foodModel) {
        realm.beginTransaction();
        realm.copyToRealm(foodModel);
        realm.commitTransaction();
        presenter.afterSaved();
    }

    @Override
    public void showFoods() {
        RealmResults<FoodModel> foods = realm
                .where(FoodModel.class).findAll();
        presenter.getFoods(foods);
    }

    @Override
    public void onSearchByWord(String word) {
        RealmResults<FoodModel> foods = realm
                .where(FoodModel.class ).
        contains("foodName" , word).findAll();
        presenter.getFoods(foods);
    }

}
