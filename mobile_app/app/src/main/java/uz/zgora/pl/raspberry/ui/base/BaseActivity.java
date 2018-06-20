package uz.zgora.pl.raspberry.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutResId();

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
    }

    public void logError(final Throwable throwable) {
        Log.e("ApiResponseHandler", throwable.toString());
        for (final StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            Log.e("ApiResponseHandler", stackTraceElement.toString());
        }
        Toast.makeText(this, "Error occured!", Toast.LENGTH_LONG).show();
    }
}
