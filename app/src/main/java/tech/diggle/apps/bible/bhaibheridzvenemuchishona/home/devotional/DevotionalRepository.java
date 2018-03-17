package tech.diggle.apps.bible.bhaibheridzvenemuchishona.home.devotional;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Diggle E. Gonese on 14/3/2018.
 */

public class DevotionalRepository {
    @Inject
    DevotionalRepository(){
    }

    public Single<Devotional> getDevotional() {
        Devotional devotional = new Devotional();
        devotional.title = "The final word";
        devotional.body = "Go ye therefore, and teach all nations, " +
                "baptizing them in the name of the " +
                "Father, and of the Son, and of the Holy Ghost";
        return Single.just(devotional);
    }
}
