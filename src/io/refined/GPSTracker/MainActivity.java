package io.refined.GPSTracker; 

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends FragmentActivity {
	
	protected static final String TAG = "MainActivity";
	private Context self = this;	    
	private LatLngStorage latLngStorage;
		
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                     
        setContentView(R.layout.activity_main);        
        latLngStorage = new LatLngStorage(this);        
        registerListeners();
    }

	private void registerListeners() {

		final ToggleButton trackTB = (ToggleButton) findViewById(R.id.trackTB);
		
		trackTB.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				if (trackTB.isChecked()) {
					startService(new Intent(self, LocationService.class));				
				} else {
					stopService(new Intent(self, LocationService.class));
					latLngStorage.dump();
				}
			}
		});
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }    
}
