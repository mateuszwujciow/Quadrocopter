package uz.zgora.pl.raspberry.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import uz.zgora.pl.raspberry.R;

public abstract class TabActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    protected abstract List<TabPage> getPages();

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        setupViewPager();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_tab;
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setupViewPager() {
        viewPager.setAdapter(createAdapter());
        tabLayout.setupWithViewPager(viewPager);
    }

    private ViewPagerAdapter createAdapter() {
        return new ViewPagerAdapter(getSupportFragmentManager(), getPages());
    }

    private static final class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<TabPage> pages;

        ViewPagerAdapter(final FragmentManager fragmentManager, final List<TabPage> pages) {
            super(fragmentManager);
            this.pages = pages == null ? Collections.emptyList() : pages;
        }

        @Override
        public Fragment getItem(final int position) {
            return getPage(position);
        }

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public String getPageTitle(final int position) {
            return getPage(position).getTitle();
        }

        private TabPage getPage(final int position) {
            return pages.get(position);
        }
    }
}