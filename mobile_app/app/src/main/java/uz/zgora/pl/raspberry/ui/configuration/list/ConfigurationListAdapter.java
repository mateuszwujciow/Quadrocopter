package uz.zgora.pl.raspberry.ui.configuration.list;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.model.Configuration;


class ConfigurationListAdapter extends RecyclerView.Adapter<ConfigurationListAdapter.ViewHolder> {
    private final List<Configuration> configurations;
    private final OnClick onClick;

    ConfigurationListAdapter(@NonNull List<Configuration> configurations, @Nullable OnClick onItemClicked) {
        this.configurations = configurations;
        this.onClick = onItemClicked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.bind(configurations.get(position));
    }

    @Override
    public int getItemCount() {
        return configurations.size();
    }

    final class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtConfigurationName)
        TextView txtConfigurationName;

        ViewHolder(final ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_configuration_list, parent, false));
            ButterKnife.bind(this, itemView);
        }

        void bind(final Configuration configuration) {
            txtConfigurationName.setText(configuration.getName());
            if (onClick != null) itemView.setOnClickListener(v -> onClick.invoke(configuration));
        }
    }

    interface OnClick {

        void invoke(final Configuration configuration);
    }
}
