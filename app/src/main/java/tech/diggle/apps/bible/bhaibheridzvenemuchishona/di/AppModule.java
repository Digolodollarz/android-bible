package tech.diggle.apps.bible.bhaibheridzvenemuchishona.di;

/**
 * Created by Diggle E. Gonese on 12/3/2018.
 */

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import tech.diggle.apps.bible.bhaibheridzvenemuchishona.App;

/**
 * This is where you will inject application-wide dependencies.
 */
@Module
public class AppModule {
    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }
//
//    @Singleton
//    @Provides
//    DevotionalService provideDevotionalService() {
//        return new DevotionalService();
//    }
}
