package ninja.stavola.perkapply.fragment;

import android.app.Fragment;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import icepick.Icepick;
import icepick.Icicle;
import ninja.stavola.perkapply.R;
import ninja.stavola.perkapply.util.PerkaFields;

public abstract class BaseFragment extends Fragment {
    @Icicle PerkaFields perkaFields;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.removeAllViews();
        View view = inflater.inflate(getLayoutId(), container, false);
        changeColors();

        Icepick.restoreInstanceState(this, savedInstanceState);

        if (perkaFields == null) {
            perkaFields = PerkaFields.getInstance();
        }

        ButterKnife.inject(this, view);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Optional
    @OnClick(R.id.button_next)
    protected void next() {
        if (!validate()) {
            return;
        }
        saveToPerkaFields();
        getFragmentManager().beginTransaction().replace(R.id.root, getNextFragment())
                .addToBackStack(getNextFragmentName()).commit();
    }

    @Optional
    @OnClick(R.id.button_back)
    protected void back() {
        getActivity().onBackPressed();
    }

    protected boolean checkNotEmpty(EditText... editTexts) {
        boolean result = true;
        for (EditText editText : editTexts) {
            final boolean isEditTextEmpty = editText.getText().toString().trim().isEmpty();
            if (isEditTextEmpty) {
                editText.setHintTextColor(getResources().getColor(android.R.color.holo_red_dark));
                result = false;
            }
        }
        return result;
    }

    private void changeColors() {
        int backgroundColor = getActivity().getResources().getColor(getBackgroundColor());
        int actionBarColor = getActivity().getResources().getColor(getActionBarColor());

        LinearLayout root = (LinearLayout) getActivity().findViewById(R.id.root);
        root.setBackgroundColor(backgroundColor);

        android.support.v7.app.ActionBar actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
    }

    protected abstract void saveToPerkaFields();
    protected abstract boolean validate();

    protected abstract @ColorRes int getBackgroundColor();
    protected abstract @ColorRes int getActionBarColor();
    protected abstract @LayoutRes int getLayoutId();

    protected abstract Fragment getNextFragment();
    protected abstract String getNextFragmentName();
}
