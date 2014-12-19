package com.gemptc.secondbrotherdemo.cinemamode;

import java.util.List;

import com.example.fragmentdemo.R;
import com.gemptc.secondbrotherdemo.MyApplication;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CinemaFragment extends Fragment {

	LayoutInflater in;
	private Context fragment;
	MyApplication myapplication;
	public List<Cinema_local> listcinemalocal;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View cinemaLayout = inflater.inflate(R.layout.cinema_layout, container,
				false);
		final ListView lv_cinema = (ListView) cinemaLayout
				.findViewById(R.id.listView1);
		in = getActivity().getLayoutInflater();
		fragment = CinemaFragment.this.getActivity();
		listcinemalocal = ((MyApplication) getActivity().getApplication()).listcinemalocal;// 从application取得聚合网json解析结果
		final MovieAdapter adapter = new MovieAdapter(listcinemalocal);
		if (listcinemalocal == null) {// 处理断网无法访问
			Toast.makeText(fragment, "网络访问失败", Toast.LENGTH_SHORT).show();
			return null;
		} else {
			lv_cinema.setAdapter(adapter);
		
			lv_cinema.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					String cinema_id = listcinemalocal.get(position).id;
					
					Intent intent = new Intent();
					intent.putExtra("id", cinema_id);
					intent.setClass(fragment, Cinema_detail_Activity.class);
					startActivity(intent);

				}
			});
			return cinemaLayout;
		}
	}

	class MovieAdapter extends BaseAdapter {
		private List<Cinema_local> data;

		public MovieAdapter(List<Cinema_local> data) {
			this.data = data;
		}

		// 说明ListView的条目数目
		@Override
		public int getCount() {
			return data.size();
		}

		// 说明position指定的条目关联对象
		@Override
		public Object getItem(int position) {
			return data.get(position);
		}

		// 条目ID
		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Cinema_local cinemalocal = data.get(position);
			if (convertView == null) {
				// LayoutInflater inflater = LayoutInflater.from(fragment);
				convertView = in.inflate(R.layout.myadapter_item_local, null);
			}
			TextView cinemaname = (TextView) convertView
					.findViewById(R.id.cinema_name);
			TextView address = (TextView) convertView
					.findViewById(R.id.cinema_local);
			TextView distance = (TextView) convertView
					.findViewById(R.id.cinema_distance);
			cinemaname.setText(cinemalocal.cinemaName);
			address.setText(cinemalocal.address);
			distance.setText("距离" + cinemalocal.distance + "米");
			return convertView;
		}
	}

}
