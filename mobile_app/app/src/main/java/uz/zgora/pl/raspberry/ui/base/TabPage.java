package uz.zgora.pl.raspberry.ui.base;

public abstract class TabPage<T> extends BaseFragment {

    public abstract String getTitle();

    public abstract T build();

    @Override
    protected abstract int getLayoutResId();

}
