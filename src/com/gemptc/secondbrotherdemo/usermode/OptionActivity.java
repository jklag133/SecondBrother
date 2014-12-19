package com.gemptc.secondbrotherdemo.usermode;

import com.example.fragmentdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ToggleButton;

public class OptionActivity extends Activity implements OnClickListener{
	
	private ToggleButton remind_btn;
	private TextView clean_tv;
	private TextView feedback_tv;
	private TextView about_tv;

	private void findId(){
		remind_btn = (ToggleButton) findViewById(R.id.remind_btn);
		clean_tv = (TextView) findViewById(R.id.clean_tv);
		feedback_tv = (TextView) findViewById(R.id.feedback_tv);
		about_tv = (TextView) findViewById(R.id.about_tv);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.option_layout);
		findId();
		
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id == R.id.remind_btn){
			
		}else if(id == R.id.clean_tv){
			
		}else if(id == R.id.feedback_tv){
			
		}else if(id == R.id.about_tv){
			
		}
	}
}
