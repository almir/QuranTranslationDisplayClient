package com.mhalka.qurantranslationdisplayclient;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class HiddenSettingsActivity extends Activity {
	// Set constants for Shared Preferences
	public static final String PREFS_NAME = "QuranTranslationDisplayClient";
	public static final String LETTERS_SIZE = "LettersSize";
	public static final String TIMEOUT_PERIOD = "TimeoutPeriod";
	
	// Set variables for layout elements
	private EditText mLetterSize;
	private Spinner mTimeout;
	private Button mSave;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_hidden_settings);
	    
	    mLetterSize = (EditText) findViewById(R.id.ed_letters);
	    mTimeout = (Spinner) findViewById(R.id.spin_timeout);
	    mSave = (Button) findViewById(R.id.btn_save);
	    
	    // Get Shared Preferences
	    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    
	    // Check whether the preferences exist and then set values
	    Boolean mEnteredPrefs = settings.contains(LETTERS_SIZE);
	    
	    if (mEnteredPrefs) {
	    	String LettersSize = settings.getString(LETTERS_SIZE, "20");
	    	Integer TimeoutPeriod = settings.getInt(TIMEOUT_PERIOD, 0);
	    	mLetterSize.setText(LettersSize.toString());
	    	mTimeout.setSelection(TimeoutPeriod);
	    } else {
	    	mLetterSize.setText("20");
	    	mTimeout.setSelection(0);
	    }
	    
	    mSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Get Shared Preferences and write new values
				SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
				SharedPreferences.Editor editor = settings.edit();
				editor.putString(LETTERS_SIZE, String.valueOf(mLetterSize.getText()));
				editor.putInt(TIMEOUT_PERIOD, mTimeout.getSelectedItemPosition());
				editor.commit();
				
				// Return to the MainActivity
				finish();
			}
		});
	}

}
