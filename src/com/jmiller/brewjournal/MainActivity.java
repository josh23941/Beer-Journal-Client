package com.jmiller.brewjournal;


import com.jmiller.brewjournal.persistance.BrewdayDAO;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;




public class MainActivity extends Activity {
	private BrewdayDAO datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		datasource = new BrewdayDAO(this);
		datasource.open();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void startBrewDay(View view){
		Intent intent = new Intent(this, NewBrewday.class);
		startActivity(intent);
	}
	
	public void editBrewDay(View view){
		populateBrewSpinner();
		
		/*
		Intent intent = new Intent(this, NewBrewday.class);
		startActivity(intent);
		*/
	}

	private void populateBrewSpinner() {
		Spinner spinner = (Spinner)findViewById(R.id.edit_brew_spinner);
		Cursor cursor = datasource.getBrewNames();
		String[] fromStrings = {"name"};
		int[] toIds = {R.id.edit_brew_spinner};
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_main, 
				cursor, fromStrings, toIds, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		spinner.setAdapter(adapter);
	}

}
