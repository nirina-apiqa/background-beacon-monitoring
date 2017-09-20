var exec = require('cordova/exec');

function BackgroundBeaconMonitoring() {

}

BackgroundBeaconMonitoring.prototype.startService = function (device_id, monitoring_api_url, ranging_apî_url, sendMovementData, successCallback, errorCallback) {
  exec(successCallback, errorCallback, "BackgroundBeaconManager", "createService", [device_id, monitoring_api_url, ranging_apî_url, sendMovementData]);
};

BackgroundBeaconMonitoring.prototype.startMonitoringRegion = function (identifier, uuid, major, minor, successCallback, errorCallback) {
  console.log("start monitoring region called");
  exec(successCallback, errorCallback, "BackgroundBeaconManager", "startMonitoringRegion", [identifier, uuid, major, minor]);
};

BackgroundBeaconMonitoring.prototype.stopMonitoringRegion = function (identifier, successCallback, errorCallback) {
  console.log("stop monitroing region called");
  exec(successCallback, errorCallback, "BackgroundBeaconManager", "stopMonitoringRegion", [identifier]);

};

BackgroundBeaconMonitoring.prototype.startRangingRegion = function (identifier, uuid, major, minor, successCallback, errorCallback) {
  console.log("start ranging region called");
  exec(successCallback, errorCallback, "BackgroundBeaconManager", "startRangingRegion", [identifier, uuid, major, minor]);
};

BackgroundBeaconMonitoring.prototype.stopRangingRegion = function (identifier, successCallback, errorCallback) {
  console.log("stop ranging region called");
  exec(successCallback, errorCallback, "BackgroundBeaconManager", "stopRangingRegion", [identifier]);

};

BackgroundBeaconMonitoring.prototype.setMovementPreference = function (preference, successCallback, errorCallback) {
  exec(successCallback, errorCallback, "BackgroundBeaconManager", "setMovementPreference", [preference]);
};

BackgroundBeaconMonitoring.prototype.requestPermissions = function (successCallback, errorCallback) {
  exec(successCallback, errorCallback, "BackgroundBeaconManager", "requestPermissions", []);
};

var backgroundBeaconMonitoring = new BackgroundBeaconMonitoring();

module.exports = backgroundBeaconMonitoring;
