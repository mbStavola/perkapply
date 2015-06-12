package ninja.stavola.perkapply.util;

import com.google.gson.Gson;
import java.io.Serializable;

public class PerkaFields implements Serializable {
    private PerkaFields(){}

    private static PerkaFields instance;

    private String first_name;
    private String last_name;
    private String email;

    private PositionId position_id;

    private String[] projects;

    private String resume;
    private transient String resumeFilePath;

    private String source;

    private final String explanation = "Applied using Perkapply by Matthew Freitas-Stavola. Link to apk and source code: https://www.dropbox.com/sh/8mujv6c28w2yih1/AACbV5OX7G1n97rTeAEzP_Fxa";

    public static PerkaFields getInstance() {
        if(instance == null) {
            instance = new PerkaFields();
        }
        return instance;
    }

    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String[] getProjects() {
        return projects;
    }

    public void setProjects(String[] projects) {
        this.projects = projects;
    }

    public String getReferrer() {
        return source;
    }
    public void setReferrer(String source) {
        this.source = source;
    }

    public PositionId getPositionId() {
        return position_id;
    }

    public void setPositionId(PositionId position_id) {
        this.position_id = position_id;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getResumeFilePath() {
        return resumeFilePath;
    }

    public void setResumeFilePath(String resumeFilePath) {
        this.resumeFilePath = resumeFilePath;
    }
}
