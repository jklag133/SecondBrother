package com.gemptc.secondbrotherdemo;

import java.util.List;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.gemptc.secondbrotherdemo.cinemamode.Cinema;
import com.gemptc.secondbrotherdemo.cinemamode.Cinema_local;
import com.google.gson.Gson;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;
import com.thinkland.sdk.android.SDKInitializer;
import android.app.Application;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MyApplication extends Application {
	public LocationClient mLocationClient;// 定位sdk的核心类 必须在主线程中声明，需要Context类型参数
	public MyLocationListener mMyLocationListener;
	public TextView tv_address, tv_lon, tv_lat;
	public String address;
	public List<Cinema_local> listcinemalocal;
	public double lon, lat;// 经纬度
	public boolean USER = false;

	public boolean isUSER() {
		return USER;
	}

	public void setUSER(boolean uSER) {
		USER = uSER;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mLocationClient = new LocationClient(this.getApplicationContext());
		mMyLocationListener = new MyLocationListener();
		mLocationClient.registerLocationListener(mMyLocationListener);
		SDKInitializer.initialize(getApplicationContext());// 聚合数据相关
	}

	public class MyLocationListener implements BDLocationListener {

		@Override
		// 接收异步返回来的定位结果
		// BDLocation类，封装了定位SDK的定位结果，在BDLocationListener的onReceive方法中获取。
		// 通过该类用户可以获取定位返回的数据
		public void onReceiveLocation(BDLocation location) {
			lon = location.getLongitude();
			lat = location.getLatitude();
			mLocationClient.stop();
			address = location.getAddrStr();
			// tv_address.setText("当前位置：" + location.getAddrStr());
			// tv_lat.setText("当前纬度：" + location.getLatitude());
			// tv_lon.setText("当前经度:" + location.getLongitude());

			Parameters params = new Parameters();// 请求到百度经纬度后设定聚合请求条件（周围影院）
			params.add("dtype", "json");
			params.add("lat", lat + "");
			params.add("lon", lon + "");
			params.add("radius", "5000");
			JuheData.executeWithAPI(42, "http://v.juhe.cn/movie/cinemas.local",
					JuheData.GET, params, new DataCallBack() {

						@Override
						public void resultLoaded(int err, String reason,
								String result) {
							Log.e("tag", "定位结果返回后请求聚合数据");
							if (err == 0) {
								// tv.setText(result);

								Gson g = new Gson();
								Cinema cinema = g
										.fromJson(result, Cinema.class);
								listcinemalocal = cinema.result;// 把解析结果设为application全局常量,在fragment页面取出来设置adapter
								// mLocationClient.stop();
								// MovieAdapter adapter = new MovieAdapter(
								// listcinemalocal);
								// listview.setAdapter(adapter);
								// mLocationClient.stop();
							} else {
								Toast.makeText(getApplicationContext(), reason,
										Toast.LENGTH_SHORT).show();
							}
						}

					});

		}
	}
}
