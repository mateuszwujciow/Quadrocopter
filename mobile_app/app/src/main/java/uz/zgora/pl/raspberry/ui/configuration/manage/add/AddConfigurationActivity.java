package uz.zgora.pl.raspberry.ui.configuration.manage.add;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.ui.base.BaseActivity;
import uz.zgora.pl.raspberry.ui.configuration.manage.edit.EditConfigurationActivity;
import uz.zgora.pl.raspberry.util.UiUtils;

public class AddConfigurationActivity extends BaseActivity {
    @BindView(R.id.txtConfigurationName)
    TextView txtConfiguratioName;

    private AddConfigurationPresenter presenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AddConfigurationPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_add_configuration;
    }

    @OnClick(R.id.btnAddConfiguration)
    void addConfiguration(final View view) {
        final String configurationName = UiUtils.getText(txtConfiguratioName);
        if (!configurationName.isEmpty()) presenter.add(configurationName);
    }

    public void showConfigurationDetails(final int configurationId) {
        final Intent intent = EditConfigurationActivity.createExtras(this, configurationId);
        startActivity(intent);
    }

}
