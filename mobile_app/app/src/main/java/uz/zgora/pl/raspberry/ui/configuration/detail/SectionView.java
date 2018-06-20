package uz.zgora.pl.raspberry.ui.configuration.detail;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import uz.zgora.pl.raspberry.R;

import static android.content.Context.INPUT_METHOD_SERVICE;
import static uz.zgora.pl.raspberry.util.Objects.isNotNull;

public class SectionView extends LinearLayout {
    @BindView(R.id.txtHeader)
    TextView txtHeader;

    @BindView(R.id.txtKd)
    TextView txtKd;
    @BindView(R.id.txtKi)
    TextView txtKi;
    @BindView(R.id.txtKp)
    TextView txtKp;
    @BindView(R.id.txtTf)
    TextView txtTf;

    public SectionView(final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_section, this, true);
        setOrientation(LinearLayout.VERTICAL);
        ButterKnife.bind(this);
        initHeaderTitle(attrs);
        txtKd.setEnabled(false);
        txtKi.setEnabled(false);
        txtKp.setEnabled(false);
        txtTf.setEnabled(false);
    }

    private void initHeaderTitle(@Nullable final AttributeSet attrs) {
        final TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.SectionView, 0, 0);
        final String headerTitle = array.getString(R.styleable.SectionView_headerTitle);
        txtHeader.setText(headerTitle);
        array.recycle();
    }

    public void setKd(final float value) {
        txtKd.setText(String.valueOf(value));
    }

    public void setKi(final float value) {
        txtKi.setText(String.valueOf(value));
    }

    public void setKp(final float value) {
        txtKp.setText(String.valueOf(value));
    }

    public void setTf(final float value) {
        txtTf.setText(String.valueOf(value));
    }
}
