package uz.zgora.pl.raspberry.ui.configuration.manage;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.util.UiUtils;

import static uz.zgora.pl.raspberry.util.Objects.isNotNull;

public class ConfigurationNameDialog extends DialogFragment {
    @BindView(R.id.editConfigurationName)
    EditText txtConfigurationName;

    private OnPositiveAction positiveAction;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.dialog_configuration_name, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    void setPossitiveAction(final OnPositiveAction possitiveAction) {
        this.positiveAction = possitiveAction;
    }

    @OnClick(R.id.btnAccept)
    void onPositiveButton() {
        if (isNotNull(positiveAction)) positiveAction.invoke(getName());
        dismiss();
    }

    @OnClick(R.id.btnCancel)
    void dispose() {
        dismiss();
    }

    private String getName() {
        return UiUtils.getText(txtConfigurationName);
    }

    interface OnPositiveAction {

        void invoke(String configurationName);
    }
}
