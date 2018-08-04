package advance.android.DAGGER;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MyModule.class})
public interface MyComponent {

    void inject(MyDaggerActivity activity) ;
}
