package com.gemptc.secondbrotherdemo.cinemamode;


import java.util.List;

import com.example.fragmentdemo.R;
import com.google.gson.Gson;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Cinema_detail_Activity extends Activity {
	TextView tv_cinemaname,lv_ticket,tv_address;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cinema_detail_layout);
		
		tv_cinemaname = (TextView) findViewById(R.id.tv_cinemaname);
		final ListView lv_ticket=(ListView) findViewById(R.id.lv_ticket_price);
		Intent intent = getIntent();
		String cinema_id = intent.getStringExtra("id");
		int cinemaid = Integer.parseInt(cinema_id);
		Toast.makeText(this, "接收到的id" + cinemaid, Toast.LENGTH_SHORT).show();

		Parameters params = new Parameters();
		params.add("dtype", "json");
		params.add("cinemaid", cinemaid);
		
		
		JuheData.executeWithAPI(42, "http://v.juhe.cn/movie/cinemas.movies",
				JuheData.GET, params, new DataCallBack() {

					/**
					 * @param err
					 *            错误码,0为成功
					 * @param reason
					 *            原因
					 * @param result
					 *            数据
					 */
					@Override
					public void resultLoaded(int err, String reason,
							String result) {
						if (err == 0) {
							Gson g = new Gson();
							Cinema_detail_mode cinema_detail_mode = g.fromJson(
									result, Cinema_detail_mode.class);

							MovieAndCinema_info movieAndCinema = cinema_detail_mode
									.getResult();
//							Cinema_info cinema_info = movieAndCinema
//									.getCinema_info();
//							// String city=cinema_info.getCity();
//							// Toast.makeText(Activity_Cinema_detail.this, city,
//							// Toast.LENGTH_SHORT).show();
//							//
							List<Movie_info> movie_info_List = movieAndCinema
									.getLists();
//							String moviename = movie_info_List.get(0)
//									.getBroadcast().get(0).getHall();// 测试解析完毕
							// String id=movie_info_List.get(0).getMovieId();
//							Toast.makeText(Activity_Cinema_detail.this,
//									moviename, Toast.LENGTH_SHORT).show();
							//-------------------------------------------
							List<Ticket_detail> ticket_detail_list=movie_info_List.get(3).getBroadcast();
							//这里取一部电影为例，后面需要写点击图片选择电影相应的生成票的listView
							Ticket_Hall_Adapter ticket_hall_adapter=new Ticket_Hall_Adapter(ticket_detail_list);
							lv_ticket.setAdapter(ticket_hall_adapter);
							
						} else {
							Toast.makeText(getApplicationContext(), reason,
									Toast.LENGTH_SHORT).show();
						}
					}

				});

	}

	class Ticket_Hall_Adapter extends BaseAdapter {
		private List<Ticket_detail> data;

		public Ticket_Hall_Adapter(List<Ticket_detail> data) {
			this.data = data;
		}

		@Override
		public int getCount() {
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			Ticket_detail ticket_detail =data.get(position);
			if (convertView == null) {
				LayoutInflater inflater = LayoutInflater
						.from(Cinema_detail_Activity.this);
				convertView = inflater.inflate(R.layout.ticket_price_item,null);
			}
			TextView moviename = (TextView) convertView.findViewById(R.id.tv_moviename);
			TextView hall_address = (TextView) convertView.findViewById(R.id.tv_hall);
			TextView price = (TextView) convertView.findViewById(R.id.tv_price);
			moviename.setText(ticket_detail.getTime());
			hall_address.setText(ticket_detail.getHall());
			price.setText(ticket_detail.getPrice()+"元");
			return convertView;
		}

	}
}
