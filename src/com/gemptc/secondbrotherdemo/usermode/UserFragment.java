package com.gemptc.secondbrotherdemo.usermode;


import com.example.fragmentdemo.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UserFragment extends Fragment {

	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View userLayout = inflater.inflate(R.layout.loginsuccess_layout,
				container, false);
		
		
		return userLayout;
	}

	

	

}
