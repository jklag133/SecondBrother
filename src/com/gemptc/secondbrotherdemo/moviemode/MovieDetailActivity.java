package com.gemptc.secondbrotherdemo.moviemode;

import java.util.List;

import net.tsz.afinal.FinalBitmap;

import com.example.fragmentdemo.R;
import com.google.gson.Gson;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetailActivity extends Activity implements OnClickListener{
//	private TextView movie_title;
	private ImageView movie_poster;
	private TextView movie_runtime;
	private TextView movie_rating;
	private TextView movie_genres;
	private TextView movie_plot_simple;
	private TextView movie_film_locations;
	private TextView movie_release_date;
	private TextView movie_directors;
	private TextView movie_actors;
	private FinalBitmap fb;
	private ImageView title_iv;
	private TextView title_tv;
	private ScrollView scrollView;
	private Button movie_pay;
	
	public void findId(){
//		movie_title = (TextView) findViewById(R.id.movie_title);
		scrollView = (ScrollView) findViewById(R.id.movie_scrollView);
		movie_poster = (ImageView) findViewById(R.id.movie_poster);
		movie_runtime = (TextView) findViewById(R.id.movie_runtime);
		movie_rating = (TextView) findViewById(R.id.movie_rating);
		movie_genres = (TextView) findViewById(R.id.movie_genres);
		movie_plot_simple = (TextView) findViewById(R.id.movie_plot_simple);
		movie_film_locations = (TextView) findViewById(R.id.movie_film_locations);
		movie_release_date = (TextView) findViewById(R.id.movie_release_date);
		movie_directors = (TextView) findViewById(R.id.movie_directors);
		movie_actors = (TextView) findViewById(R.id.movie_actors);
		movie_pay = (Button) findViewById(R.id.movie_pay);
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.movie_detail_layout);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_layout);
		Intent intent = getIntent();
		String moviename = intent.getStringExtra("moviename");
		title_iv = (ImageView) findViewById(R.id.title_iv);
		title_tv = (TextView) findViewById(R.id.title_tv);
		title_iv.setImageResource(R.drawable.share);
		title_tv.setText(moviename);
		findId();
		movie_pay.setOnClickListener(this);
		fb = FinalBitmap.create(this);
		// movie_title.setText(moviename);
		Parameters params = new Parameters();
		params.add("dtype", "json");
		params.add("title", moviename);

		/**
		 * 请求的方法 参数: 第一个参数 接口id 第二个参数 接口请求的url 第三个参数 接口请求的方式 第四个参数
		 * 接口请求的参数,键值对com.thinkland.sdk.android.Parameters类型; 第五个参数
		 * 请求的回调方法,com.thinkland.sdk.android.DataCallBack;
		 * 
		 */
		JuheData.executeWithAPI(42, "http://v.juhe.cn/movie/index",
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
//							movie_title.setText(result);
							Gson gson = new Gson();
							MovieDetail moviedetail = gson.fromJson(result,MovieDetail.class);
							List<Movie_detail> listmoviedetail = moviedetail.result;
							Movie_detail data = listmoviedetail.get(0);
//							movie_title.setText(data.getTitle().toString());
							movie_rating.setText(data.getRating().toString());
							movie_release_date.setText(data.getRelease_date().toString());
							movie_runtime.setText(data.getRuntime().toString());
							movie_plot_simple.setText(data.getPlot_simple().toString());
							fb.display(movie_poster, data.getPoster().toString());							
							movie_directors.setText(data.getDirectors().toString());
							movie_actors.setText(data.getActors().toString());
							movie_film_locations.setText(data.getFilm_locations().toString());
							movie_genres.setText(data.getGenres().toString());
							
							
						} else {
							Toast.makeText(getApplicationContext(), reason,
									Toast.LENGTH_SHORT).show();
						}
					}

				});

	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(MovieDetailActivity.this,SelectSeatActivity.class);
		String moviename = title_tv.getText().toString();
		
		intent.putExtra("moviename", moviename);
		startActivity(intent);
	}

}
