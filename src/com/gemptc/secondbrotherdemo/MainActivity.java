package com.gemptc.secondbrotherdemo;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.example.fragmentdemo.R;
import com.gemptc.secondbrotherdemo.MyApplication.MyLocationListener;
import com.gemptc.secondbrotherdemo.activitymode.AcitivityFragment;
import com.gemptc.secondbrotherdemo.cinemamode.CinemaFragment;
import com.gemptc.secondbrotherdemo.moviemode.MovieFragment;
import com.gemptc.secondbrotherdemo.usermode.LoginActivity;
import com.gemptc.secondbrotherdemo.usermode.NetUtil;
import com.gemptc.secondbrotherdemo.usermode.UserFragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * 项目的主Activity，所有的Fragment都嵌入在这里。gggggggggggggggg
 * 
 * @author guolin
 */
public class MainActivity extends Activity implements OnClickListener {
	public MyLocationListener mMyLocationListener;
	LocationClient mLocationClient;
	/**
	 * 用于展示消息的Fragment
	 */
	private MovieFragment movieFragment;

	/**
	 * 用于展示联系人的Fragment
	 */
	private CinemaFragment cinemaFragment;

	/**
	 * 用于展示动态的Fragment
	 */
	private AcitivityFragment activityFragment;

	/**
	 * 用于展示设置的Fragment
	 */
	private UserFragment userFragment;

	private FragmentManager fragmentManager;

	private View movieLayout;

	private View cinemaLayout;

	private View activityLayout;

	private View userLayout;

	private ImageView movieImage;

	private ImageView cinemaImage;

	private ImageView activityImage;

	private ImageView userImage;

	private TextView movieText;

	private TextView cinemaText;

	private TextView activityText;

	private TextView userText;

	private TextView titleText;

	private ImageView title_iv;

	public MyApplication my;

	public int layout = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_main);

		// 自定义的标题栏xml布局
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
				R.layout.title_layout);

		my = (MyApplication) this.getApplication();

		initViews();
		fragmentManager = getFragmentManager();
		// 第一次启动时选中第0个tab
		
		setTabSelection(0);
		mLocationClient=((MyApplication) getApplication()).mLocationClient;//从application读取LocationClient对象启动定位SDK
		InitLocation();//初始化定位
		mLocationClient.start();//开始定位

	}

	/**
	 * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
	 */
	public void initViews() {
		titleText = (TextView) findViewById(R.id.title_tv);
		movieLayout = findViewById(R.id.movie_layout);
		cinemaLayout = findViewById(R.id.cinema_layout);
		activityLayout = findViewById(R.id.activity_layout);
		userLayout = findViewById(R.id.user_layout);
		movieImage = (ImageView) findViewById(R.id.movie_image);
		cinemaImage = (ImageView) findViewById(R.id.cinema_image);
		activityImage = (ImageView) findViewById(R.id.activity_image);
		userImage = (ImageView) findViewById(R.id.user_image);
		movieText = (TextView) findViewById(R.id.movie_text);
		cinemaText = (TextView) findViewById(R.id.cinema_text);
		activityText = (TextView) findViewById(R.id.activity_text);
		userText = (TextView) findViewById(R.id.user_text);
		title_iv = (ImageView) findViewById(R.id.title_iv);
		movieLayout.setOnClickListener(this);
		cinemaLayout.setOnClickListener(this);
		activityLayout.setOnClickListener(this);
		userLayout.setOnClickListener(this);
	}

	 public void share(View v){
			if (layout==2) {
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
				intent.putExtra(Intent.EXTRA_TEXT,
						"ganhuaquan 国服第一机器人 (分享自secondbrother)");

				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(Intent.createChooser(intent, "分享到...."));
			} else if (layout==3) {
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("text/plain");
				intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
				intent.putExtra(Intent.EXTRA_TEXT,
						"I have successfully share my message through my app (分享自secondbrother)");

				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(Intent.createChooser(intent, getTitle()));
			}
		
	
	 }
	 public void citylist(View v){
		 Intent intent=new Intent();
		 intent.setClass(MainActivity.this, CityListActivity.class);
		 startActivity(intent);
	 }


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.movie_layout:
			if(layout == 0){}
			else if(layout == 4){}
			else{
			titleText.setText(R.string.movie);
			// 当点击了消息tab时，选中第1个tab
			title_iv.setImageResource(R.drawable.search);
			layout = 0;
			setTabSelection(0);
			}
			break;
		case R.id.cinema_layout:
			if(layout == 1){}
			else{
			titleText.setText(R.string.cinema);
			// 当点击了联系人tab时，选中第2个tab
			title_iv.setImageResource(R.drawable.search);
			layout = 1;
			setTabSelection(1);
			}
			break;
		case R.id.activity_layout:
			if(layout == 2){}
			else{
			titleText.setText(R.string.activity);
			// 当点击了动态tab时，选中第3个tab
			title_iv.setImageResource(R.drawable.share);
			layout = 2;
			setTabSelection(2);
			}
			break;
		case R.id.user_layout:
			
			if (my.isUSER() == false) {
				Intent intent = new Intent(MainActivity.this,
						LoginActivity.class);
				startActivity(intent);
			} else {
				titleText.setText(R.string.user);
				// 当点击了设置tab时，选中第4个tab
				title_iv.setImageResource(R.drawable.share);
				layout = 3;
				setTabSelection(3);
			}
			break;
			
		default:
			break;
		}
	}

	/**
	 * 根据传入的index参数来设置选中的tab页。
	 * 
	 * @param index
	 * 
	 */
	private void setTabSelection(int index) {
		// 每次选中之前先清楚掉上次的选中状态
		clearSelection();
		// 开启一个Fragment事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 当点击了movielayout时，改变控件的图片和文字颜色
			movieImage.setImageResource(R.drawable.select_movie);
			movieText.setTextColor(Color.WHITE);

			movieFragment = new MovieFragment();
			transaction.replace(R.id.content, movieFragment);

			break;
		case 1:
			// 当点击了cinemalayout时，改变控件的图片和文字颜色
			cinemaImage.setImageResource(R.drawable.select_cinema);
			cinemaText.setTextColor(Color.WHITE);

			cinemaFragment = new CinemaFragment();
			transaction.replace(R.id.content, cinemaFragment);

			break;
		case 2:
			// 当点击了activitylayout时，改变控件的图片和文字颜色
			activityImage.setImageResource(R.drawable.select_activity);
			activityText.setTextColor(Color.WHITE);

			activityFragment = new AcitivityFragment();
			transaction.replace(R.id.content, activityFragment);

			break;
		case 3:
		default:
			// 当点击了userlayout时，改变控件的图片和文字颜色
			userImage.setImageResource(R.drawable.select_user);
			userText.setTextColor(Color.WHITE);

			userFragment = new UserFragment();
			transaction.replace(R.id.content, userFragment);

			break;
		}
		transaction.commit();
	}

	/**
	 * 清除掉所有的选中状态。
	 */
	private void clearSelection() {
		movieImage.setImageResource(R.drawable.noselect_movie);
		movieText.setTextColor(Color.parseColor("#82858b"));
		cinemaImage.setImageResource(R.drawable.noselect_cinema);
		cinemaText.setTextColor(Color.parseColor("#82858b"));
		activityImage.setImageResource(R.drawable.noselect_activity);
		activityText.setTextColor(Color.parseColor("#82858b"));
		userImage.setImageResource(R.drawable.noselect_user);
		userText.setTextColor(Color.parseColor("#82858b"));
	}

	/**
	 * 将所有的Fragment都置为隐藏状态。
	 * 
	 * @param transaction
	 *            用于对Fragment执行操作的事务
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (movieFragment != null) {
			transaction.hide(movieFragment);
		}
		if (cinemaFragment != null) {
			transaction.hide(cinemaFragment);
		}
		if (activityFragment != null) {
			transaction.hide(activityFragment);
		}
		if (userFragment != null) {
			transaction.hide(userFragment);
		}
	}
	private void InitLocation() {// 设定位参数
		LocationClientOption option = new LocationClientOption();
		/**
		 * 设置定位参数包括：定位模式（高精度定位模式，低功耗定位模式和仅用设备定位模式），返回坐标类型，是否打开GPS等等。
		 * 高精度定位模式：这种定位模式下，会同时使用网络定位和GPS定位，优先返回最高精度的定位结果；
		 * 低功耗定位模式：这种定位模式下，不会使用GPS，只会使用网络定位（Wi-Fi和基站定位）
		 * 仅用设备定位模式：这种定位模式下，不需要连接网络，只使用GPS进行定位，这种模式下不支持室内环境的定位
		 * 
		 */
		option.setLocationMode(LocationMode.Hight_Accuracy);// 设置定位模式
		option.setCoorType("gcj02");// 返回的定位结果是百度经纬度，默认值gcj02
		option.setScanSpan(5000);// 设置发起定位请求的间隔时间为5000ms
		option.setIsNeedAddress(true);// 返回的定位结果包含地址信息
		mLocationClient.setLocOption(option);

	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			AlertDialog.Builder build = new AlertDialog.Builder(this);
			build.setTitle("系统提示").setMessage("确定要退出吗？");
			build.setPositiveButton("确定",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
//							onDestroy();
//							finish();
							System.exit(0);
						}
					});
			build.setNegativeButton("取消",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					}).show();
			break;
		}
		return super.onKeyDown(keyCode, event);
	}
	

}
