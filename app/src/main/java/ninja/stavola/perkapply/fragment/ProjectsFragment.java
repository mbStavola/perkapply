package ninja.stavola.perkapply.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.util.Base64;
import android.widget.EditText;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import butterknife.InjectView;
import butterknife.OnClick;
import ninja.stavola.perkapply.R;

public class ProjectsFragment extends BaseFragment {
    public static final int PICK_FILE_URI = 0;

    @InjectView(R.id.textfield_github)
    protected EditText githubField;

    @InjectView(R.id.textfield_personal_site)
    protected EditText personalSiteField;

    @InjectView(R.id.textfield_resume)
    protected EditText resumeField;

    @OnClick(R.id.button_file)
    public void getFilePath() {
        Intent intentForFileUri = new Intent(Intent.ACTION_GET_CONTENT);
        intentForFileUri.setType("file/pdf");
        startActivityForResult(intentForFileUri, PICK_FILE_URI);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FILE_URI && data != null) {
            perkaFields.setResumeFilePath(data.getData().getPath());
            resumeField.setText(perkaFields.getResumeFilePath());
        }
    }

    @Override
    protected void saveToPerkaFields() {
        String[] projects = new String[] {
                githubField.getText().toString(),
                personalSiteField.getText().toString()
        };

        perkaFields.setProjects(projects);


        File resume = new File(resumeField.getText().toString());
        String resumeB64 = "";

        try {
            byte[] resumeBytes = FileUtils.readFileToByteArray(resume);
            resumeB64 = Base64.encodeToString(resumeBytes, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        perkaFields.setResume(resumeB64);
    }

    @Override
    protected boolean validate() {
        return checkNotEmpty(resumeField);
    }

    @Override
    protected int getBackgroundColor() {
        return R.color.bg_green;
    }

    @Override
    protected int getActionBarColor() {
        return R.color.ab_green;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_projects_and_resume;
    }

    @Override
    protected Fragment getNextFragment() {
        return new ReferralFragment();
    }

    @Override
    protected String getNextFragmentName() {
        return "fragment_referral";
    }
}
