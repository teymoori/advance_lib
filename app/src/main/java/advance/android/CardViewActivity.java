package advance.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.leolin.shortcutbadger.ShortcutBadger;
import tehran.sematec.myadvancelibrary.MyFirstClass;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view);

        int badgeCount = 10;
        ShortcutBadger.applyCount(this, badgeCount); //for 1.1.4+

        MyFirstClass.toast(this,"its from app");

    }
}
