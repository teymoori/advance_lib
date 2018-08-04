package advance.android.oop.interfaceSample;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import advance.android.R;

public class Main2Activity extends AppCompatActivity
    implements DatabaseFace
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DatabaseWork dbwork = new DatabaseWork(this) ;


    }

    @Override
    public void connect(String username, String ip) {

    }

    @Override
    public void insert(String query) {

    }
}
