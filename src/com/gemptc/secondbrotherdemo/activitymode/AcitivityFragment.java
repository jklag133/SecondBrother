package com.gemptc.secondbrotherdemo.activitymode;



import com.example.fragmentdemo.R;
import com.gemptc.secondbrotherdemo.MainActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AcitivityFragment extends Fragment {


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View activityLayout = inflater.inflate(R.layout.activity_layout, container,
				false);
		
		
		
		return activityLayout;
	}


}
