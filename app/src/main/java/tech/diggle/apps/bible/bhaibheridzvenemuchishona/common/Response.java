package tech.diggle.apps.bible.bhaibheridzvenemuchishona.common;

/**
 * Created by Diggle E. Gonese on 14/3/2018.
 *
 * Response holder provided to the UI
 */

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static tech.diggle.apps.bible.bhaibheridzvenemuchishona.common.Status.ERROR;
import static tech.diggle.apps.bible.bhaibheridzvenemuchishona.common.Status.LOADING;
import static tech.diggle.apps.bible.bhaibheridzvenemuchishona.common.Status.SUCCESS;


public class Response<T> {

    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final Throwable error;

    private Response(Status status, @Nullable T data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static Response loading() {
        return new Response(LOADING, null, null);
    }

    public static <E> Response success(@NonNull E data) {
        return new Response(SUCCESS, data, null);
    }

    public static Response error(@NonNull Throwable error) {
        return new Response(ERROR, null, error);
    }
}
