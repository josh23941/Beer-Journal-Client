package com.jmiller.brewjournal;

import java.util.Calendar;

import com.jmiller.brewjournal.util.CalendarUtils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;

public class NewBrewday extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_brewday);
		Intent intent = getIntent();
		EditText editText = (EditText)findViewById(R.id.new_brewday_date_field);
		editText.setText(CalendarUtils.getCurrentDateFormatted());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_brewday, menu);
		return true;
	}

}
