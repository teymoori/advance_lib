package advance.android.DAGGER2;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import advance.android.utils.BaseApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class SecondModule {

    BaseApplication app ;
    public SecondModule(BaseApplication app) {
        this.app = app;
    }


    @Provides
    @Singleton
    public Context context(){
        return app.getApplicationContext() ;
    }

    @Provides
    @Singleton
    public SharedPreferences getShared(Context ctx){
        return PreferenceManager.
                getDefaultSharedPreferences(ctx);
    }

    @Provides
    @Singleton
    public LocationModel getLocation( ){
        return new LocationModel() ;
    }

    @Provides
    @Singleton
    public StudentModel getModel(LocationModel location , Context context){
        return new StudentModel(location , context ) ;
    }

    @Provides
    @Singleton
    public StudentHandler getSTDH(StudentModel stdModel , SharedPreferences shared){
        return new StudentHandler(stdModel , shared) ;
    }


}
