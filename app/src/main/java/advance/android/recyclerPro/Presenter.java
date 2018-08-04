package advance.android.recyclerPro;

import java.util.List;

import advance.android.recyclerPro.entities.FoodModel;

public class Presenter implements Contract.Presenter {
    private Contract.View view;
    Model model = new Model() ;
    @Override
    public void attachViewP(Contract.View thatsView) {
        this.view = thatsView ;
        model.attachPresenter(this);
        model.showFoods();
    }


    @Override
    public void saveFood(FoodModel foodModel) {
        model.saveFood(foodModel);
    }

    @Override
    public void afterSaved() {
            view.afterSaved();
            model.showFoods();
    }

    @Override
    public void onSaveFailed() {
        model.showFoods();
    }

    @Override
    public void getFoods(List<FoodModel> foods) {
        view.getFoods(foods);
    }

    @Override
    public void onSelectFood(FoodModel food) {
        view.showSelectedFood(food);
    }

    @Override
    public void onSearchByWord(String word) {
        model.onSearchByWord(word);
    }
}
