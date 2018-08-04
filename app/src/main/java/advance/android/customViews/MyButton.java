package advance.android.customViews;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import advance.android.utils.BaseApplication;

public class MyButton extends AppCompatButton {

    public MyButton(Context context) {
        super(context);
        setTypeface(BaseApplication.appFace);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(BaseApplication.appFace);
    }
}
