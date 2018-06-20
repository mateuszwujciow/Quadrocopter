package uz.zgora.pl.raspberry.ui.configuration.manage.edit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.model.Sensor;
import uz.zgora.pl.raspberry.model.SensorDetails;
import uz.zgora.pl.raspberry.ui.base.TabPage;
import uz.zgora.pl.raspberry.util.UiUtils;

import static uz.zgora.pl.raspberry.util.Objects.isNull;
import static uz.zgora.pl.raspberry.util.UiUtils.setText;

public class ConfigurationPage extends TabPage<SensorDetails> {
    public static final String KEY_SINGLE_CONFIGURATION = "key-single-configuration";

    @BindView(R.id.txtKp)
    EditText txtKp;
    @BindView(R.id.txtKi)
    EditText txtKi;
    @BindView(R.id.txtKd)
    EditText txtKd;
    @BindView(R.id.txtTf)
    EditText txtTf;

    public static TabPage<SensorDetails> newInstance(final SensorDetails configuration) {
        final Bundle args = new Bundle();
        args.putSerializable(KEY_SINGLE_CONFIGURATION, configuration);
        final ConfigurationPage fragment = new ConfigurationPage();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public String getTitle() {
        return getSensorDetails().getName();
    }

    @Override
    public SensorDetails build() {
        final Sensor sensor = new Sensor(getFloat(txtKp), getFloat(txtKi), getFloat(txtKd), getFloat(txtTf));
        return new SensorDetails(getSensorDetails().getId(), getSensorDetails().getName(), sensor);
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

    private SensorDetails getSensorDetails() {
        final Bundle args = getArguments();
        return (SensorDetails) args.getSerializable(KEY_SINGLE_CONFIGURATION);
    }

    private void setupView() {
        final Sensor sensor = getSensorDetails().getSensor();
        setText(txtKd, sensor.getKd());
        setText(txtKi, sensor.getKi());
        setText(txtKp, sensor.getKp());
        setText(txtTf, sensor.getTf());
    }

    private float getFloat(final TextView textView) {
        return isNull(textView) ? 0 : UiUtils.getFloat(textView);
    }
}
