package advance.android.DAGGER2;


import javax.inject.Singleton;

import advance.android.DAGGER.MyModule;
import dagger.Component;

@Singleton
@Component(modules = {SecondModule.class  })
public interface MySecondComponent  {
        void inject(SecondDaggerActivity activity) ;
}
