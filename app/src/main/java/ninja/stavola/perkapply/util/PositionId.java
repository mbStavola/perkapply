package ninja.stavola.perkapply.util;

import android.support.annotation.StringRes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ninja.stavola.perkapply.Perkapply;
import ninja.stavola.perkapply.R;

public enum PositionId {
    @SerializedName("android_engineer")
    ANDROID_ENGINEER(R.string.position_android_engineer),

    @SerializedName("SRE_DevOps")
    DEV_OPS(R.string.position_dev_ops),

    @SerializedName("GENERALIST")
    GENERALIST(R.string.position_generalist),

    @SerializedName("iOS_engineer")
    iOS_ENGINEER(R.string.position_ios_engineer),

    @SerializedName("Java_API")
    JAVA_API_ENGINEER( R.string.position_java_api_engineer),

    @SerializedName("Java_Platform_Engineer")
    JAVA_PLATFORM_ENGINEER(R.string.position_java_platform_engineer),

    @SerializedName("Javascript_Engineer")
    JAVASCRIPT_ENGINEER(R.string.position_javascript_engineer),

    @SerializedName("Software Test Engineer")
    SOFTWARE_TEST_ENGINEER(R.string.position_software_test_engineer);

    private String name;

    PositionId(@StringRes int name) {
        this.name = Perkapply.getAppContext().getString(name);
    }

    public String getName() {
        return  name;
    }

    public static PositionId getFromName(String name) {
        for (PositionId positionId : values()) {
            if (positionId.name.equals(name)) {
                return positionId;
            }
        }
        return null;
    }

    public static List<String> getIdsToNames() {
        List<String> idsToNames = new ArrayList<>();
        for (PositionId positionId : values()) {
            idsToNames.add(positionId.name);
        }
        return idsToNames;
    }
}
