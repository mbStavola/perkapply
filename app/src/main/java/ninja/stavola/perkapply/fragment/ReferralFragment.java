package ninja.stavola.perkapply.fragment;

import android.app.Fragment;
import android.widget.EditText;

import butterknife.InjectView;
import ninja.stavola.perkapply.R;

public class ReferralFragment extends BaseFragment {
    @InjectView(R.id.textfield_referral)
    protected EditText referrer;

    @Override
    protected void saveToPerkaFields() {
        perkaFields.setReferrer(referrer.getText().toString());
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int getBackgroundColor() {
        return R.color.bg_blue;
    }

    @Override
    protected int getActionBarColor() {
        return R.color.ab_blue;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_referral;
    }

    @Override
    protected Fragment getNextFragment() {
        return new ReviewFragment();
    }

    @Override
    protected String getNextFragmentName() {
        return "fragment_review";
    }
}
