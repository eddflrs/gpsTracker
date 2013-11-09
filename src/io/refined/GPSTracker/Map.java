package io.refined.GPSTracker;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Map extends Fragment {
		
	private final String TAG = "Map";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
	}
				
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {		
		Log.d(TAG, "onCreateView");				
		View fragmentView = inflater.inflate(R.layout.map, container, false);
		
		FragmentManager fragMan = getActivity().getSupportFragmentManager();
		final SupportMapFragment supportMapFrag = (SupportMapFragment) fragMan.findFragmentById(R.id.googleMap);
		
		GoogleMap map = supportMapFrag.getMap();
		UiSettings settings = map.getUiSettings();
		
		settings.setCompassEnabled(true);
		settings.setZoomControlsEnabled(false);
		
		map.setMyLocationEnabled(true);
				
		return fragmentView;
	}

}
