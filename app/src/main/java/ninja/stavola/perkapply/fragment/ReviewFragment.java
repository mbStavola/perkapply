package ninja.stavola.perkapply.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.InjectView;
import ninja.stavola.perkapply.Perkapply;
import ninja.stavola.perkapply.R;
import ninja.stavola.perkapply.util.PostTask;

public class ReviewFragment extends BaseFragment {
    @InjectView(R.id.first_name)
    protected EditText firstName;

    @InjectView(R.id.last_name)
    protected EditText lastName;

    @InjectView(R.id.email)
    protected EditText email;

    @InjectView(R.id.position)
    protected EditText position;

    @InjectView(R.id.textfield_github)
    protected EditText github;

    @InjectView(R.id.textfield_personal_site)
    protected EditText personalSite;

    @InjectView(R.id.textfield_resume)
    protected EditText resume;

    @InjectView(R.id.textfield_referral)
    protected EditText referrer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View superView = super.onCreateView(inflater, container, savedInstanceState);

        firstName.setText(perkaFields.getFirstName());
        lastName.setText(perkaFields.getLastName());
        email.setText(perkaFields.getEmail());

        position.setText(perkaFields.getPositionId().getName());

        github.setText(perkaFields.getProjects()[0]);
        personalSite.setText(perkaFields.getProjects()[1]);
        resume.setText(perkaFields.getResumeFilePath());

        referrer.setText(perkaFields.getReferrer());

        return superView;
    }

    @Override
    protected void saveToPerkaFields() {
        new PostTask().execute(Perkapply.getAppContext().getString(R.string.perka_api_url));
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int getBackgroundColor() {
        return R.color.bg_indigo;
    }

    @Override
    protected int getActionBarColor() {
        return R.color.ab_indigo;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_review;
    }

    @Override
    protected Fragment getNextFragment() {
        getActivity().getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        return new WelcomeFragment();
    }

    @Override
    protected String getNextFragmentName() {
        return "fragment_welcome";
    }
}
