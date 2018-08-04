package advance.android.Transtition;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;

import com.easyandroidanimations.library.ExplodeAnimation;

import advance.android.R;
import advance.android.customViews.MyImageView;

public class ActivityB extends AppCompatActivity {
    MyImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        image = findViewById(R.id.image);

        image.load("http://media.irib.ir/assets//radio_slider/20180122150158_2203.png");



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bomb() ;
            }
        },700) ;

    }

    void bomb(){
        new ExplodeAnimation(image)
                .setExplodeMatrix(ExplodeAnimation.MATRIX_2X2)
                .setInterpolator(new DecelerateInterpolator())
                .setDuration(500)

                .animate();
    }
}
