package tech.diggle.apps.bible.bhaibheridzvenemuchishona.home.devotional;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Diggle E. Gonese on 14/3/2018.
 */

@Module
public class DevotionalModule {
    @Singleton
    @Provides
    DevotionalRepository provideRepository() {
        return new DevotionalRepository();
    }
}
