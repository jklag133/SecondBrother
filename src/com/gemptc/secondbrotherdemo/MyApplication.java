package com.gemptc.secondbrotherdemo;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.thinkland.sdk.android.SDKInitializer;
import android.app.Application;
import android.widget.TextView;

public class MyApplication extends Application {
	public LocationClient mLocationClient;// 定位sdk的核心类 必须在主线程中声明，需要Context类型参数
	public MyLocationListener mMyLocationListener;
	public TextView tv_address, tv_lon, tv_lat;
	public String address;
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
			address = location.getAddrStr();
			tv_address.setText("当前位置：" + location.getAddrStr());
			tv_lat.setText("当前纬度：" + location.getLatitude());
			tv_lon.setText("当前经度:" + location.getLongitude());
		}

	}
}
