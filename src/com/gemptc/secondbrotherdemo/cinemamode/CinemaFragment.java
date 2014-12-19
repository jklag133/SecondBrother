package com.gemptc.secondbrotherdemo.cinemamode;



import com.example.fragmentdemo.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CinemaFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View cinemaLayout = inflater.inflate(R.layout.cinema_layout,
				container, false);
		return cinemaLayout;
	}

}
