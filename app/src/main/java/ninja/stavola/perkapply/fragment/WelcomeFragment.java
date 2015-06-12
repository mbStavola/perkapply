package ninja.stavola.perkapply.fragment;

import android.app.Fragment;

import ninja.stavola.perkapply.R;

public class WelcomeFragment extends BaseFragment {
    @Override
    protected void saveToPerkaFields() {}

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int getBackgroundColor() {
        return R.color.bg_red;
    }

    @Override
    protected int getActionBarColor() {
        return R.color.ab_red;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_welcome;
    }

    @Override
    protected Fragment getNextFragment() {
        return new PersonalDetailsFragment();
    }

    @Override
    protected String getNextFragmentName() {
        return "fragment_personal_details";
    }
}
