package advance.android.PHP_REST;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import advance.android.R;
import advance.android.customViews.MyTextView;

public class OrdersListAdapter extends BaseAdapter {
    Context mContext ;
    List<OrdersModel> orders ;

    public OrdersListAdapter(Context mContext, List<OrdersModel> orders) {
        this.mContext = mContext;
        this.orders = orders;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int i) {
        return orders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = LayoutInflater.from(mContext)
                .inflate(R.layout.orders_list_item , viewGroup , false) ;

        MyTextView title  = row.findViewById(R.id.title) ;
        MyTextView price  = row.findViewById(R.id.price) ;

        title.setText(orders.get(i).getTitle());
        price.setText(orders.get(i).getPrice());

        return row;
    }
}
