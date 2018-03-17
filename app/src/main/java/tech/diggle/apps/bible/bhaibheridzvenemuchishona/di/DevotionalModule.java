package tech.diggle.apps.bible.bhaibheridzvenemuchishona.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import tech.diggle.apps.bible.bhaibheridzvenemuchishona.MainActivity;
import tech.diggle.apps.bible.bhaibheridzvenemuchishona.home.devotional.DevotionalFragment;

/**
 * Created by Diggle E. Gonese on 12/3/2018.
 */

@Module
public abstract class DevotionalModule {
    @ContributesAndroidInjector
    abstract DevotionalFragment devotionalFragment();

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}
