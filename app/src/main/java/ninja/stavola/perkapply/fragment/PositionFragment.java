package ninja.stavola.perkapply.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import butterknife.InjectView;
import ninja.stavola.perkapply.R;
import ninja.stavola.perkapply.util.PositionId;

public class PositionFragment extends BaseFragment {
    @InjectView(R.id.position_select)
    protected Spinner position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View superView = super.onCreateView(inflater, container, savedInstanceState);

        List<String> positionNamesList = PositionId.getIdsToNames();
        String[] positionNames = positionNamesList.toArray(new String[positionNamesList.size()]);

        ArrayAdapter<String> positionAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, positionNames);
        position.setAdapter(positionAdapter);

        return superView;
    }

  @Override
    protected void saveToPerkaFields() {
        String positionText = (String) position.getSelectedItem();
        PositionId positionId = PositionId.getFromName(positionText);
        perkaFields.setPositionId(positionId);
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int getBackgroundColor() {
        return R.color.bg_yellow;
    }

    @Override
    protected int getActionBarColor() {
        return R.color.ab_yellow;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_position;
    }

    @Override
    protected Fragment getNextFragment() {
        return new ProjectsFragment();
    }

    @Override
    protected String getNextFragmentName() {
        return "fragment_projects_resume";
    }
}
