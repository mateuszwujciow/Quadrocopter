package uz.zgora.pl.raspberry.ui.configuration;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.model.SingleConfiguration;
import uz.zgora.pl.raspberry.ui.base.TabPage;

import static uz.zgora.pl.raspberry.util.UiUtils.setText;

public class ConfigurationPage extends TabPage {
    public static final String KEY_SINGLE_CONFIGURATION = "key-single-configuration";

    private static final String UNDEFINED_TITLE = "Undefined";

    @BindView(R.id.txtKp)
    EditText txtKp;
    @BindView(R.id.txtKi)
    EditText txtKi;
    @BindView(R.id.txtKd)
    EditText txtKd;
    @BindView(R.id.txtTf)
    EditText txtTf;

    private SingleConfiguration configuration;

    @Override
    public String getTitle() {
        configuration = getConfiguration();
        return configuration == null ? UNDEFINED_TITLE : configuration.getType().name();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.view_configuration;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupView();
    }

    private SingleConfiguration getConfiguration() {
        final Bundle args = getArguments();
        if (args == null) return SingleConfiguration.EMPTY(SingleConfiguration.Type.UNKNOWN);
        final SingleConfiguration configuration = (SingleConfiguration) args.getSerializable(KEY_SINGLE_CONFIGURATION);
        return configuration == null ? SingleConfiguration.EMPTY(SingleConfiguration.Type.UNKNOWN) : configuration;
    }

    private void setupView() {
        if (configuration != null) {
            setText(txtKp, configuration.getKp());
            setText(txtKi, configuration.getKi());
            setText(txtKd, configuration.getKd());
            setText(txtTf, configuration.getTf());
        }
    }

    public static TabPage newInstance(final SingleConfiguration configuration) {
        final Bundle args = new Bundle();
        args.putSerializable(KEY_SINGLE_CONFIGURATION, configuration);
        final ConfigurationPage fragment = new ConfigurationPage();
        fragment.setArguments(args);
        return fragment;
    }
}
