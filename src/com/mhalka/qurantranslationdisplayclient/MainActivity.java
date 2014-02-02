package com.mhalka.qurantranslationdisplayclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView mHiddenSettings;
	private ImageButton mPrevious;
	private ImageButton mNext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mHiddenSettings = (ImageView) findViewById(R.id.btn_settings);
		mPrevious = (ImageButton) findViewById(R.id.btn_previous);
		mNext = (ImageButton) findViewById(R.id.btn_next);
		
		mHiddenSettings.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				Intent intent = new Intent(MainActivity.this, HiddenSettingsActivity.class);
                startActivity(intent);
				return false;
			}
		});
		
		mPrevious.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
