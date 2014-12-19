package com.gemptc.secondbrotherdemo.moviemode;

import java.util.List;

import net.tsz.afinal.FinalBitmap;

import com.example.fragmentdemo.R;
import com.google.gson.Gson;

import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieFragment extends Fragment implements OnItemClickListener{
	
	TextView moviemode_tv;
	ListView listview;
	FinalBitmap fb;
	ImageView iv;
	LayoutInflater in;
	private Context fragment;
	ImageView title_iv;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View movieLayout = inflater.inflate(R.layout.movie_layout, container,
				false);
		title_iv = (ImageView) movieLayout.findViewById(R.id.title_iv);
		listview=(ListView) movieLayout.findViewById(R.id.listView1);
		in = getActivity().getLayoutInflater();
		fragment = MovieFragment.this.getActivity();
		fb = FinalBitmap.create(getActivity());
		listview.setOnItemClickListener(this);
		Parameters params = new Parameters();
		params.add("dtype", "json");
//		params.add("cinemaid", 1188);
		params.add("cityid", 21);

		/**
		 * 请求的方法 参数: 第一个参数 接口id 第二个参数 接口请求的url 第三个参数 接口请求的方式 第四个参数
		 * 接口请求的参数,键值对com.thinkland.sdk.android.Parameters类型; 第五个参数
		 * 请求的回调方法,com.thinkland.sdk.android.DataCallBack;
		 * 
		 */
		JuheData.executeWithAPI(42, "http://v.juhe.cn/movie/movies.today",
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
							// tv.setText(result);
							Gson g = new Gson();
							Movie movie = g.fromJson(result, Movie.class);
							List<Movie_today> listmovietoday = movie.result;
							MovieAdapter adapter = new MovieAdapter(listmovietoday,fragment);
							
							listview.setAdapter(adapter);

						} else {
							Toast.makeText(
									getActivity().getApplicationContext(),
									reason, Toast.LENGTH_SHORT).show();
						}
					}

				});
		return movieLayout;

	}


	class MovieAdapter extends BaseAdapter{
		private List<Movie_today> data;
		private Context mcontext;
		
		public MovieAdapter(List<Movie_today> data,Context context){
			this.data=data;
			this.mcontext = context;
		}
		//说明ListView的条目数目
		@Override
		public int getCount() {
			return data.size();
		}
		//说明position指定的条目关联对象
		@Override
		public Object getItem(int position) {
			return data.get(position);
		}
		//条目ID
		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Movie_today movietoday=data.get(position);
			if(convertView == null){
				//LayoutInflater inflater = LayoutInflater.from(mcontext);
				convertView = in.inflate(R.layout.movie_list_layout, null);
				System.out.println("aaaa"+in.toString());
			}  
			
			TextView movie_name=(TextView) convertView.findViewById(R.id.movie_name_tv);
			TextView movie_text=(TextView) convertView.findViewById(R.id.movie_text_tv);
			ImageView movie_lisi_iv=(ImageView) convertView.findViewById(R.id.movie_list_iv);
			movie_name.setText(movietoday.getMovieName());
			movie_text.setText(movietoday.movieId+"");
			fb.display(movie_lisi_iv, movietoday.getPic_url());
			return convertView;
		}}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		TextView text=(TextView) view.findViewById(R.id.movie_name_tv);
		
		String moviename=(String) text.getText();
		
		Intent intent = new Intent(getActivity(),MovieDetailActivity.class);
		intent.putExtra("moviename", moviename);
		startActivity(intent);
		
	}

}
