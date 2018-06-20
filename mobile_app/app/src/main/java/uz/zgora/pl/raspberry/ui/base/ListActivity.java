package uz.zgora.pl.raspberry.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import uz.zgora.pl.raspberry.R;

public abstract class ListActivity extends BaseActivity {

    @BindView(R.id.layoutContent)
    RecyclerView layoutContent;

    private RecyclerView.Adapter listAdapter;

    protected abstract RecyclerView.Adapter createAdapter();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_list;
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listAdapter = createAdapter();
        layoutContent.setLayoutManager(new LinearLayoutManager(this));
        layoutContent.setAdapter(listAdapter);
    }

    protected void refreshData() {
        listAdapter.notifyDataSetChanged();
    }
}
