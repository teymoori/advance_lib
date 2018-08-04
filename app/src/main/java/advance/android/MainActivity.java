package advance.android;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import advance.android.utils.BaseActivity;
import advance.android.utils.Gen;

public class MainActivity extends BaseActivity {
    int maxCount = 5;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intervalFunction();


        Gen.toast("Salamammmmm");


        findViewById(R.id.getPermission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        findViewById(R.id.getPermission)
                .setOnClickListener(V -> {
                    getPermission();
                });

    }

    private void getPermission() {
        if (ContextCompat.checkSelfPermission(mContext,
                Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED) {
        } else {
            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.READ_SMS},
                    1000);
        }

//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(mContext, "edscs", Toast.LENGTH_SHORT).show();
//            }
//        }, 3000);


    }

    public void intervalFunction() {
        count++;
        if (maxCount != count)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(mContext, "Hi", Toast.LENGTH_SHORT).show();
                    intervalFunction();
                }
            }, 1000);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            //from read sms permission
        }
    }
}
