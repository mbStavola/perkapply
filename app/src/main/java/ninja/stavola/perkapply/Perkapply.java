package ninja.stavola.perkapply;

import android.app.Application;
import android.content.Context;

public class Perkapply extends Application {

  private static Context context;

  public void onCreate(){
    super.onCreate();
    Perkapply.context = getApplicationContext();
  }

  public static Context getAppContext() {
    return Perkapply.context;
  }
}
