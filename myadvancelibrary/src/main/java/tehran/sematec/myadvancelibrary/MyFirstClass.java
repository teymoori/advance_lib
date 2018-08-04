package tehran.sematec.myadvancelibrary;

import android.content.Context;
import android.widget.Toast;

public class MyFirstClass {


    public static void toast(Context mContext
            , String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
