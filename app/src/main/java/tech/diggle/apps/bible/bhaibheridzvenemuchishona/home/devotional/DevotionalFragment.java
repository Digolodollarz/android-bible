package tech.diggle.apps.bible.bhaibheridzvenemuchishona.home.devotional;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;
import tech.diggle.apps.bible.bhaibheridzvenemuchishona.R;
import tech.diggle.apps.bible.bhaibheridzvenemuchishona.common.Response;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class DevotionalFragment extends Fragment {
//    @Inject
//    DevotionalService devotionalService;

    @Inject
    DevotionalViewModelFactory factory;

    @BindView(R.id.tvDevotionalTitle)
    TextView devotionalTitleTv;

    @BindView(R.id.tvDevotionalBody)
    TextView devotionalBodyTv;

    private String TAG = "Devotional Fragment";
    private DevotionalViewModel viewModel;
    private Unbinder unbinder;

    public DevotionalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_devotional, container, false);
        unbinder = ButterKnife.bind(this, view);
        viewModel = ViewModelProviders.of(this, factory).get(DevotionalViewModel.class);
        viewModel.response().observe(this, response -> processResponse(response));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        setDevotional();
        viewModel.loadDevotional();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setDevotional(Devotional devotional) {
//        Devotional devotional = devotionalService.getDevotional();
        devotionalTitleTv.setText(devotional.title);
        devotionalBodyTv.setText(devotional.body);
    }

    private void processResponse(Response<Devotional> response) {
        switch (response.status) {
            case LOADING:
                Timber.tag(TAG).d("Loading");
                break;

            case SUCCESS:
                this.setDevotional(response.data);
                break;

            case ERROR:
                Timber.d(response.error);
                break;
        }
    }

}
