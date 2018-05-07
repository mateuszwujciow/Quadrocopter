package uz.zgora.pl.raspberry.ui.configuration.manage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.model.SingleConfiguration;
import uz.zgora.pl.raspberry.ui.base.TabPage;
import uz.zgora.pl.raspberry.util.UiUtils;

import static uz.zgora.pl.raspberry.util.Objects.isNotNull;
import static uz.zgora.pl.raspberry.util.Objects.isNull;
import static uz.zgora.pl.raspberry.util.UiUtils.setText;

public class ConfigurationPage extends TabPage<SingleConfiguration> {
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

    public static TabPage<SingleConfiguration> newInstance(final SingleConfiguration configuration) {
        final Bundle args = new Bundle();
        args.putSerializable(KEY_SINGLE_CONFIGURATION, configuration);
        final ConfigurationPage fragment = new ConfigurationPage();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String getTitle() {
        configuration = getConfiguration();
        return isNull(configuration) ? UNDEFINED_TITLE : configuration.getType().name();
    }

    @Override
    public SingleConfiguration build() {
        return new SingleConfiguration.Builder()
                .kd(getFloat(txtKd))
                .ki(getFloat(txtKi))
                .kp(getFloat(txtKp))
                .tf(getFloat(txtTf))
                .type(getConfiguration().getType())
                .build();
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
        if (isNull(args)) return SingleConfiguration.EMPTY(SingleConfiguration.Type.UNKNOWN);
        final SingleConfiguration configuration = (SingleConfiguration) args.getSerializable(KEY_SINGLE_CONFIGURATION);
        return isNull(configuration) ? SingleConfiguration.EMPTY(SingleConfiguration.Type.UNKNOWN) : configuration;
    }

    private void setupView() {
        if (isNotNull(configuration)) {
            setText(txtKp, configuration.getKp());
            setText(txtKi, configuration.getKi());
            setText(txtKd, configuration.getKd());
            setText(txtTf, configuration.getTf());
        }
    }

    private float getFloat(final TextView textView) {
        return isNull(textView) ? 0 : UiUtils.getFloat(textView);
    }
}
