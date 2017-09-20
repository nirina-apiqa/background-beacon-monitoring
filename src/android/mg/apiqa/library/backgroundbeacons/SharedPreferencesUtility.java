package mg.apiqa.library.backgroundbeacons;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

public class SharedPreferencesUtility {

  public static final String PREFERENCES_NAME = "BACKGROUND_BEACONS_PREFS";

  public static final String DEVICE_ID = "DEVICE_ID";
  public static final String MONITORING_API_URL = "MONITORING_API_URL";
  public static final String RANGING_API_URL = "RANGING_API_URL";
  public static final String SEND_MOVEMENT_DATA = "SEND_MOVEMENT_DATA";

  private Context context;
  private SharedPreferences settings;
  private Editor editor;

  public SharedPreferencesUtility(Context c) {
    super();
    this.context = c;
    this.settings = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    this.editor = this.settings.edit();
  }

  public void setDeviceId(String deviceId) {
    this.editor.putString(DEVICE_ID, deviceId);
    this.editor.commit();
  }

  public void setMonitoringApiUrl(String text) {
    this.editor.putString(MONITORING_API_URL, text);
    this.editor.commit();
  }

  public void setRangingApiUrl(String text) {
    this.editor.putString(RANGING_API_URL, text);
    this.editor.commit();
  }

  public void setSendMovementData(Boolean sendMovementData) {
    Log.d("mg.apiqa.library", "Movement Data: " + sendMovementData);
    this.editor.putBoolean(SEND_MOVEMENT_DATA, sendMovementData);
    this.editor.commit();
  }

  public String getDeviceId() {
    return this.settings.getString(DEVICE_ID, null);
  }

  public String getMonitoringApiUrl() {
    return this.settings.getString(MONITORING_API_URL, null);
  }

  public String getRangingApiUrl(){
    return this.settings.getString(RANGING_API_URL, null);
  }

  public boolean getSendMovementData() {
    return this.settings.getBoolean(SEND_MOVEMENT_DATA, false);
  }


  public boolean exist() {

    if (!this.settings.contains(DEVICE_ID)) {
      return false;
    }

    if (!this.settings.contains(MONITORING_API_URL)) {
      return false;
    }

    if (!this.settings.contains(RANGING_API_URL)) {
      return false;
    }

    if(!this.settings.contains(SEND_MOVEMENT_DATA)) {
      return false;
    }

    return true;
  }

}
