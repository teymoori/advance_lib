package advance.android.DAGGER;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import advance.android.utils.BaseApplication;
import dagger.Module;
import dagger.Provides;
import io.realm.annotations.PrimaryKey;

@Module
public class MyModule {

    BaseApplication application ;

    public MyModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context getCTX(){
        return application.getApplicationContext() ;
    }


    @Provides
    @Singleton
    public SharedPreferences getShared(Context ctx){
        return PreferenceManager.
                getDefaultSharedPreferences(ctx);
    }

}
