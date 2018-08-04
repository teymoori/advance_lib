package advance.android.recyclerPro;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import advance.android.R;
import advance.android.customViews.MyEditText;
import advance.android.customViews.MyImageView;
import advance.android.customViews.MyTextView;
import advance.android.recyclerPro.entities.FoodModel;
import advance.android.utils.Gen;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.Holder> {

    Context mContext;
    List<FoodModel> foods;

    public FoodsAdapter(Context mContext, List<FoodModel> foods) {
        this.mContext = mContext;
        this.foods = foods;
    }

    public void removeItemByID(int index){
        foods.remove(index) ;
        notifyDataSetChanged();
    }

    @Override
    public FoodsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.food_item, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodsAdapter.Holder holder, int position) {
        holder.image.load(foods.get(position).getFoodImage());
        holder.foodName.setText(foods.get(position).getFoodName());
        holder.foodPrice.setText(foods.get(position).getFoodPrice());
        holder.foodType.setText(foods.get(position).getFoodType());


    }


    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        MyImageView image;
        MyTextView foodName, foodPrice, foodType;

        public Holder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            foodName = itemView.findViewById(R.id.foodName);
            foodPrice = itemView.findViewById(R.id.foodPrice);
            foodType = itemView.findViewById(R.id.foodType);


            itemView.setOnClickListener(v->{
                Gen.toast("from container");
            });

            image.setOnClickListener(V -> {
                FoodModel food = foods.get(getAdapterPosition()) ;
                clickHandle.onClickItem(food);
            });

        }
    }

    ClickHandle clickHandle ;
    public void setClickHandle(ClickHandle clickHandle) {
        this.clickHandle = clickHandle;
    }
    interface  ClickHandle{
        void onClickItem(FoodModel food) ;
    }
}
