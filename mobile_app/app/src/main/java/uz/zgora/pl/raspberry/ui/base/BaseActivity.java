package uz.zgora.pl.raspberry.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutResId();

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
    }
}
