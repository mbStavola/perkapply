package ninja.stavola.perkapply.fragment;

import android.app.Fragment;
import android.widget.EditText;

import butterknife.InjectView;
import ninja.stavola.perkapply.R;

public class PersonalDetailsFragment extends BaseFragment {
    @InjectView(R.id.first_name)
    protected EditText firstName;

    @InjectView(R.id.last_name)
    protected EditText lastName;

    @InjectView(R.id.email)
    protected EditText email;

    @Override
    protected void saveToPerkaFields() {
        perkaFields.setFirstName(firstName.getText().toString());
        perkaFields.setLastName(lastName.getText().toString());
        perkaFields.setEmail(email.getText().toString());
    }

    @Override
    protected boolean validate() {
        return checkNotEmpty(firstName, lastName, email);
    }

    @Override
    protected int getBackgroundColor() {
        return R.color.bg_orange;
    }

    @Override
    protected int getActionBarColor() {
        return R.color.ab_orange;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_personal_details;
    }

    @Override
    protected Fragment getNextFragment() {
        return new PositionFragment();
    }

    @Override
    protected String getNextFragmentName() {
        return "fragment_position";
    }
}
