package mg.apiqa.library.backgroundbeacons;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import mg.apiqa.library.backgroundbeacons.SharedPreferencesUtility;

public class StartupBroadcastReceiver extends BroadcastReceiver {

  private SharedPreferencesUtility settings;

  @Override
  public void onReceive(Context context, Intent intent) {

    this.settings = new SharedPreferencesUtility(context);

    if (this.settings.exist()) {
      Log.d("mg.apiqa.library.backgroundbeacons", "Startup Broadcast receiver start");
      Intent startServiceIntent = new Intent(context.getApplicationContext(), BackgroundBeaconService.class);
      context.getApplicationContext().startService(startServiceIntent);
    }

  }

}
