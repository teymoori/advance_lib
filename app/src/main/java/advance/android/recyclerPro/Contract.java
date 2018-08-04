package advance.android.recyclerPro;

import java.util.List;

import advance.android.recyclerPro.entities.FoodModel;

public interface Contract {


    interface View {
        void afterSaved();
        void onSaveFailed() ;
        void getFoods(List<FoodModel> foods) ;

        void showSelectedFood(FoodModel food) ;
    }

    interface Presenter {
        void attachViewP(View view);
        void saveFood(FoodModel foodModel) ;
        void afterSaved();
        void onSaveFailed() ;
        void getFoods(List<FoodModel> foods) ;

        void onSelectFood(FoodModel food) ;
        void onSearchByWord(String word) ;

    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void saveFood(FoodModel foodModel) ;
        void showFoods() ;
        void onSearchByWord(String word) ;
    }


}
