package io.refined.GPSTracker;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class LocationService extends Service {

	private final String TAG = "LocationService";
	
	private LocationManager locationManager;
	private LocationListener locationListener;	
	
	private LatLongStorage latLongStorage; 

	@Override
	public void onCreate() {
		latLongStorage = new LatLongStorage(this);
		initLocator();
		super.onCreate();
	}
		
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {		
		Log.d(TAG, "Started!");		
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		return START_STICKY;
	}
			
	private void initLocator() {
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

		locationListener = new LocationListener() {			
			@Override
			public void onLocationChanged(Location loc) {
				Log.d(TAG, "Location changed");
				latLongStorage.save(loc.getLatitude(), loc.getLongitude());
			}

			@Override
			public void onProviderDisabled(String provider) { }

			@Override
			public void onProviderEnabled(String provider) { }

			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) { }
		};			
	}
	
	@Override
	public IBinder onBind(Intent intent) { 
		return null; 
	}

	@Override
	public void onDestroy() {
		Log.d(TAG, "Destroyed!");
		super.onDestroy();
	}
}
