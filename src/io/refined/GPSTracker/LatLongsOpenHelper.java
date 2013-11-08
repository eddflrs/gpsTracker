package io.refined.GPSTracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LatLongsOpenHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "gpstracker";
	private static final int DATABASE_VERSION = 2;
	private static final String DICTIONARY_TABLE_CREATE = 
			"CREATE TABLE latlongs (lat TEXT, long TEXT)";


	LatLongsOpenHelper (Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {	
		db.execSQL(DICTIONARY_TABLE_CREATE);
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// crickets
	}
}
