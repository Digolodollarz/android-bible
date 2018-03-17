package tech.diggle.apps.bible.bhaibheridzvenemuchishona.di;

/**
 * Created by Diggle E. Gonese on 12/3/2018.
 */

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import tech.diggle.apps.bible.bhaibheridzvenemuchishona.App;

@Singleton
@Component(modules = {
        /* Use AndroidInjectionModule.class if you're not using support library */
        AndroidSupportInjectionModule.class,
        AppModule.class,
        DevotionalModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);
        AppComponent build();
    }
    void inject(App app);
}
