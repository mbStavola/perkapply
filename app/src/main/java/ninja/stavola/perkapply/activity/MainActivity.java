package ninja.stavola.perkapply.activity;

import android.os.Bundle;

import icepick.Icicle;
import ninja.stavola.perkapply.R;
import ninja.stavola.perkapply.fragment.WelcomeFragment;
import ninja.stavola.perkapply.util.PerkaFields;


public class MainActivity extends BaseActivity {
    @Icicle PerkaFields perkaFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        perkaFields = PerkaFields.getInstance();
        setContentView(R.layout.activity_main);
        createWelcomeView();
    }

    @Override
    public void onBackPressed() {
        String currentFragment = getFragmentManager()
                .getBackStackEntryAt(getFragmentManager().getBackStackEntryCount() - 1).getName();

        if (!currentFragment.equals("fragment_welcome")) {
            getFragmentManager().popBackStack();
        }
    }

    public void createWelcomeView() {
        getFragmentManager().beginTransaction().replace(R.id.root, new WelcomeFragment())
                .addToBackStack("fragment_welcome").commit();
    }
}