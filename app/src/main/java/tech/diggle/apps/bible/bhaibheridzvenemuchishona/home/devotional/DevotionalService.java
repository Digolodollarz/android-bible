package tech.diggle.apps.bible.bhaibheridzvenemuchishona.home.devotional;

import javax.inject.Inject;

import io.reactivex.Single;
import timber.log.Timber;

/**
 * Created by Diggle E. Gonese on 12/3/2018.
 */

public class DevotionalService {
    private final DevotionalRepository repository;

    @Inject
    public DevotionalService(DevotionalRepository repository) {
        this.repository = repository;
    }

    public Single<Devotional> execute() {
        Timber.d("We are here executing");
        return this.repository.getDevotional();
    }

    public Devotional getDevotional() {
        Devotional devotional = new Devotional();
        devotional.title = "The final word";
        devotional.body = "Go ye therefore, and teach all nations, " +
                "baptizing them in the name of the " +
                "Father, and of the Son, and of the Holy Ghost";
        return devotional;
    }
}
