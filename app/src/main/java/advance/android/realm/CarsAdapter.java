package advance.android.realm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import advance.android.R;
import advance.android.customViews.MyTextView;

public class CarsAdapter extends BaseAdapter {
    Context mContext;
    List<CarModel> cars;

    public CarsAdapter(Context mContext, List<CarModel> cars) {
        this.mContext = mContext;
        this.cars = cars;
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = LayoutInflater.from(mContext)
                .inflate(R.layout.car_item, viewGroup, false);

        MyTextView name = row.findViewById(R.id.name);
        MyTextView model = row.findViewById(R.id.model);
        MyTextView price = row.findViewById(R.id.price);


        name.setText(cars.get(position).getName());
        model.setText(cars.get(position).getModel());
        price.setText(cars.get(position).getPrice() + "");
        return row;
    }
}
