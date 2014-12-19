package com.gemptc.secondbrotherdemo;

import com.example.fragmentdemo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_layout);
		
		new Handler().postDelayed(new jump(), 3000);
		
	}
	
	public class jump implements Runnable  {  
	    @Override  
	    public void run() {  
	    	Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
			startActivity(intent);
	        finish();  
	    }  
	}  
}
