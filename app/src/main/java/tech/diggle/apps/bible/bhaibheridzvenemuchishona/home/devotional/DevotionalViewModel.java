package tech.diggle.apps.bible.bhaibheridzvenemuchishona.home.devotional;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import tech.diggle.apps.bible.bhaibheridzvenemuchishona.common.Response;
import tech.diggle.apps.bible.bhaibheridzvenemuchishona.rx.SchedulersFacade;

/**
 * Created by Diggle E. Gonese on 14/3/2018.
 */

public class DevotionalViewModel extends ViewModel {
    private final DevotionalService service;

    private final SchedulersFacade schedulersFacade;

    private final CompositeDisposable disposables = new CompositeDisposable();

    private final MutableLiveData<Response> response = new MutableLiveData<>();

    DevotionalViewModel(DevotionalService service,
                   SchedulersFacade schedulersFacade) {
        this.service = service;
        this.schedulersFacade = schedulersFacade;
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }

    void loadDevotional(){
        this._loadDevotional();
    }

    MutableLiveData<Response> response() {
        return response;
    }

    private void _loadDevotional() {
        disposables.add(service.execute()
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe(__ -> response.setValue(Response.loading()))
                .subscribe(
                        greeting -> response.setValue(Response.success(greeting)),
                        throwable -> response.setValue(Response.error(throwable))
                )
        );
    }
}
