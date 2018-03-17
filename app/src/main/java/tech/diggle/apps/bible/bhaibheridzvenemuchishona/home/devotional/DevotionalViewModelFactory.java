package tech.diggle.apps.bible.bhaibheridzvenemuchishona.home.devotional;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;

import tech.diggle.apps.bible.bhaibheridzvenemuchishona.rx.SchedulersFacade;

/**
 * Created by Diggle E. Gonese on 14/3/2018.
 */

public class DevotionalViewModelFactory implements ViewModelProvider.Factory {
    private final DevotionalService service;

    private final SchedulersFacade schedulersFacade;

    @Inject
    DevotionalViewModelFactory(DevotionalService service,
                          SchedulersFacade schedulersFacade) {
        this.service = service;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DevotionalViewModel.class)) {
            return (T) new DevotionalViewModel(service, schedulersFacade);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
