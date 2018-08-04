package advance.android.recyclerPro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import advance.android.R;
import advance.android.customViews.MyEditText;
import advance.android.recyclerPro.entities.FoodModel;
import advance.android.utils.BaseActivity;
import advance.android.utils.Gen;

@EActivity(R.layout.activity_recycler_pro)
public class RecyclerProActivity extends BaseActivity
        implements Contract.View,FoodsAdapter.ClickHandle {


    Contract.Presenter presenter = new Presenter();

    @ViewById
    RecyclerView recycler;

    @ViewById
    MyEditText foodName, foodPrice, foodType, foodImage,search;



    @AfterViews
    void init() {
        presenter.attachViewP(this);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Gen.toast(charSequence.toString());
                presenter.onSearchByWord(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Click
    void save() {
        FoodModel food = FoodModel.newBuilder()
                .foodImage(foodImage.text()).
                        foodName(foodName.text()).
                        foodPrice(foodPrice.text())
                .foodType(foodType.text()).
                        build();
        presenter.saveFood(food);
    }

    @Override
    public void afterSaved() {
        Gen.toast("food has been saved");
    }

    @Override
    public void onSaveFailed() {

    }

    @Override
    public void getFoods(List<FoodModel> foods) {
        FoodsAdapter adapter = new FoodsAdapter(
                mContext , foods
        );
        adapter.setClickHandle(this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onClickItem(FoodModel food) {
        presenter.onSelectFood(food);
    }

    @Override
    public void showSelectedFood(FoodModel food) {
        Gen.toast("food clicked" + food.getFoodPrice());
    }
}
