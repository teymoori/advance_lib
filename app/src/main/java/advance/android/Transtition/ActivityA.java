package advance.android.Transtition;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.easyandroidanimations.library.BounceAnimation;

import advance.android.R;
import advance.android.customViews.MyImageView;
import advance.android.utils.BaseActivity;

public class ActivityA extends BaseActivity {
    MyImageView image ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        image = findViewById(R.id.image) ;
        image.load("http://media.irib.ir/assets//radio_slider/20180122150158_2203.png");

        new BounceAnimation(image)
                .setBounceDistance(50)
                .setDuration(500)
                .animate();


        image.setOnClickListener(V->{
            Intent transitionIntent  = new Intent(mContext
                    ,ActivityB.class) ;

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, image, "img");

            startActivity(transitionIntent , options.toBundle());

        });


    }
}
