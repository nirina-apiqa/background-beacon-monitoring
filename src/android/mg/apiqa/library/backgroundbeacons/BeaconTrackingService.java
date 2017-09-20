package mg.apiqa.library.backgroundbeacons;

import mg.apiqa.library.backgroundbeacons.SharedPreferencesUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import android.util.Log;
import java.net.URL;
import java.net.HttpURLConnection;

import mg.apiqa.library.backgroundbeacons.BeaconTrackingEvent;
import mg.apiqa.library.backgroundbeacons.RegionTrackingEvent;

public class BeaconTrackingService {

  private SharedPreferencesUtility settings;
  private final String monitoringApiUrl;
  private final String rangingApiUrl;

  public BeaconTrackingService(SharedPreferencesUtility settings) {
    this.settings = settings;
    this.monitoringApiUrl = this.settings.getMonitoringApiUrl();
    this.rangingApiUrl = this.settings.getRangingApiUrl();
  }

  public void EnterRegionEvent(RegionTrackingEvent event) {

    if (this.settings.getSendMovementData()) {
      try {

        URL url = new URL(this.monitoringApiUrl);

        String json = event.toJsonObject().toString();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setFixedLengthStreamingMode(json.getBytes().length);

        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        conn.setRequestProperty("Accept", "application/json");

        conn.connect();

        OutputStream os = new BufferedOutputStream(conn.getOutputStream());
        os.write(json.getBytes());
        os.flush();

        os.close();
        conn.disconnect();

      } catch (Exception e) {

          Log.d("mg.apiqa.library.backgroundbeacons region tracking errors", e.getMessage());
      }
    }

  }

  public void ExitRegionEvent(RegionTrackingEvent event) {

    if (this.settings.getSendMovementData()) {
      try {

        URL url = new URL(this.monitoringApiUrl);

        String json = event.toJsonObject().toString();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setFixedLengthStreamingMode(json.getBytes().length);

        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        conn.setRequestProperty("Accept", "application/json");

        conn.connect();

        OutputStream os = new BufferedOutputStream(conn.getOutputStream());
        os.write(json.getBytes());
        os.flush();

        os.close();
        conn.disconnect();

      } catch (Exception e) {
          Log.d("mg.apiqa.library.backgroundbeacons region tracking errors", e.getMessage());
      }
    }

  }

  public void RangeBeaconEvent(BeaconTrackingEvent event) {

    if (this.settings.getSendMovementData()) {
      try {

        URL url = new URL(this.rangingApiUrl);

        String json = event.toJsonObject().toString();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setFixedLengthStreamingMode(json.getBytes().length);

        conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        conn.setRequestProperty("Accept", "application/json");

        conn.connect();

        OutputStream os = new BufferedOutputStream(conn.getOutputStream());
        os.write(json.getBytes());
        os.flush();

        os.close();
        conn.disconnect();

      } catch (Exception e) {

        Log.d("mg.apiqa.library.backgroundbeacons beacon tracking errors", e.getMessage());

      }
    }

  }

}
