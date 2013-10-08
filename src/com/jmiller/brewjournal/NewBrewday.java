package com.jmiller.brewjournal;

import com.jmiller.brewjournal.util.CalendarUtils;
import com.jmiller.brewjournal.persistance.BrewdayDAO;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewBrewday extends Activity {
	BrewdayDAO datasource;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_brewday);
		datasource = new BrewdayDAO(this);
		datasource.open();
		EditText editText = (EditText)findViewById(R.id.new_brewday_date_field);
		editText.setText(CalendarUtils.getCurrentDateFormatted());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_brewday, menu);
		return true;
	}
	
	private void nextActivity(){
		Intent intent = new Intent(this, SecondActivity.class);
		startActivity(intent);
	}
	
	public void saveBrewday(View view){
		//Check that the name is not null
		EditText beerNameEditText = (EditText)findViewById(R.id.new_brewday_beer_name_field);
		String beerNameString = beerNameEditText.getText().toString();
		if (!(beerNameString.trim().length() == 0) && (beerNameString != null)){
			//insert name into database and goto next activity
			datasource.insertBrewday(beerNameString);
			datasource.close();
			nextActivity();
		}else{
			//fire a toast and don't goto next activity
			Toast toast = Toast.makeText(getApplicationContext(), "Enter A Name", Toast.LENGTH_SHORT);
			toast.show();
		}
	}

}
