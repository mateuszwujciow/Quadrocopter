package uz.zgora.pl.raspberry.ui.base;

public abstract class TabPage extends BaseFragment {

    public abstract String getTitle();

    @Override
    protected abstract int getLayoutResId();
}
