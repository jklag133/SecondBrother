package com.gemptc.secondbrotherdemo;

import com.example.fragmentdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class CityListActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_citylist);
		
		int i=9;
		String i="这是主干";
		String a="ca";
		System.out.println(i+a);
	}

}
