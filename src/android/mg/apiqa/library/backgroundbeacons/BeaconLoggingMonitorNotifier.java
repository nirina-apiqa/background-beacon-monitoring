package mg.apiqa.library.backgroundbeacons;

import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.Region;

import android.util.Log;

import mg.apiqa.library.backgroundbeacons.SharedPreferencesUtility;
import mg.apiqa.library.backgroundbeacons.BeaconTrackingService;
import mg.apiqa.library.backgroundbeacons.RegionTrackingEvent;
import mg.apiqa.library.backgroundbeacons.BeaconInfo;
import mg.apiqa.library.backgroundbeacons.BeaconEvent;
import mg.apiqa.library.backgroundbeacons.BeaconRegion;

import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

public class BeaconLoggingMonitorNotifier implements MonitorNotifier {

  private BeaconTrackingService beaconTrackingService;
  private SharedPreferencesUtility settings;

  public BeaconLoggingMonitorNotifier(SharedPreferencesUtility settings) {
    this.settings = settings;
    this.beaconTrackingService = new BeaconTrackingService(this.settings);
  }

  public void didEnterRegion(Region region) {

    Log.d("mg.apiqa.library.backgroundbeacons", "BACKGROUND: Entered region.");

    String regionIdentifier = null;
    String regionUUID = null;
    String regionMajor = null;
    String regionMinor = null;

    if (region.getUniqueId() != null) {
      regionIdentifier = region.getUniqueId().toString();
    }

    if (region.getId1() != null) {
      regionUUID = region.getId1().toString();
    }

    if (region.getId2() != null) {
      regionMajor = region.getId2().toString();
    }

    if (region.getId3() != null) {
      regionMinor = region.getId3().toString();
    }

    BeaconRegion beaconRegion = new BeaconRegion(regionIdentifier, regionUUID, regionMajor, regionMinor);

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    String timestamp = dateFormat.format(new Date());

    RegionTrackingEvent regionTrackingEvent = new RegionTrackingEvent(this.settings.getDeviceId(), "entered_region", beaconRegion, timestamp);

    this.beaconTrackingService.EnterRegionEvent(regionTrackingEvent);

    Log.d("mg.apiqa.library.backgroundbeacons", regionTrackingEvent.toJsonObject().toString());

  }

  public void didExitRegion(Region region) {

    Log.d("mg.apiqa.library.backgroundbeacons", "BACKGROUND: Exited region.");

    String regionIdentifier = null;
    String regionUUID = null;
    String regionMajor = null;
    String regionMinor = null;

    if (region.getUniqueId() != null) {
      regionIdentifier = region.getUniqueId().toString();
    }

    if (region.getId1() != null) {
      regionUUID = region.getId1().toString();
    }

    if (region.getId2() != null) {
      regionMajor = region.getId2().toString();
    }

    if (region.getId3() != null) {
      regionMinor = region.getId3().toString();
    }

    BeaconRegion beaconRegion = new BeaconRegion(regionIdentifier, regionUUID, regionMajor, regionMinor);

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    String timestamp = dateFormat.format(new Date());

    RegionTrackingEvent regionTrackingEvent = new RegionTrackingEvent(this.settings.getDeviceId(), "exited_region", beaconRegion, timestamp);

    this.beaconTrackingService.ExitRegionEvent(regionTrackingEvent);

    Log.d("mg.apiqa.library.backgroundbeacons", regionTrackingEvent.toJsonObject().toString());

  }

  public void didDetermineStateForRegion(int state, Region region) {
    Log.d("mg.apiqa.library.backgroundbeacons", "BACKGROUND: Region changed state.");
  }

}
