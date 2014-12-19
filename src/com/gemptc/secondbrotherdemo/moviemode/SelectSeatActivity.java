package com.gemptc.secondbrotherdemo.moviemode;

import java.util.ArrayList;

import com.example.fragmentdemo.R;
import com.ldm.seatchoosetest.view.SSThumView;
import com.ldm.seatchoosetest.view.SSView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SelectSeatActivity extends Activity {
	private static final int ROW = 10;
	private static final int EACH_ROW_COUNT =11;
	private SSView mSSView;
	private SSThumView mSSThumView;
	private ArrayList<SeatInfo> list_seatInfos = new ArrayList<SeatInfo>();
	private ArrayList<ArrayList<Integer>> list_seat_conditions = new ArrayList<ArrayList<Integer>>();
	private TextView movie_name;
	private ImageView title_iv;
	private TextView title_tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.selectseat_layout);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_layout);
		Intent intent = getIntent();
		String moviename = intent.getStringExtra("moviename");
		init();
		title_iv.setImageResource(R.drawable.share);
		title_tv.setText(moviename);
		movie_name.setText(moviename);
		
	}
	
	
	private void init(){
		mSSView = (SSView)SelectSeatActivity.this.findViewById(R.id.mSSView);
		mSSThumView = (SSThumView)SelectSeatActivity.this.findViewById(R.id.ss_ssthumview);
		movie_name = (TextView) findViewById(R.id.seat_movie_name);
		title_iv = (ImageView) findViewById(R.id.title_iv);
		title_tv = (TextView) findViewById(R.id.title_tv);
//		mSSView.setXOffset(20);
		setSeatInfo();
		mSSView.init(EACH_ROW_COUNT, ROW, list_seatInfos, list_seat_conditions, mSSThumView, 5);
		mSSView.setOnSeatClickListener(new OnSeatClickListener() {
			
			@Override
			public boolean b(int column_num, int row_num, boolean paramBoolean) {
				String desc =  "您选择了第"+(row_num+1)+"排" + " 第" + (column_num+1) +"列";
				Toast.makeText(SelectSeatActivity.this,desc.toString(), Toast.LENGTH_SHORT).show();
				return false;
			}
			
			@Override
			public boolean a(int column_num, int row_num, boolean paramBoolean) {
				String desc =  "您取消了第"+(row_num+1)+"排" + " 第" + (column_num+1) +"列";
				Toast.makeText(SelectSeatActivity.this,desc.toString(), Toast.LENGTH_SHORT).show();	
				return false;
			}
			
			@Override
			public void a() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	

	private void setSeatInfo(){
		for(int i =0;i<ROW;i++){//8行
			SeatInfo mSeatInfo = new SeatInfo();
			ArrayList<Seat> mSeatList = new ArrayList<Seat>();
			ArrayList<Integer> mConditionList = new ArrayList<Integer>();
			for(int j=0;j<EACH_ROW_COUNT;j++){//每排20个座位
				Seat mSeat = new Seat();
				if(j<1){
					mSeat.setN("Z");
					mConditionList.add(0);
				}else{
					mSeat.setN(String.valueOf(j-2));
					if(j>10){//每排可选座位数
						mConditionList.add(2);
					}else{
						mConditionList.add(1);
					}
					
				}
				mSeat.setDamagedFlg("");
				mSeat.setLoveInd("0");
				mSeatList.add(mSeat);
			}
			mSeatInfo.setDesc(String.valueOf(i+1));
			mSeatInfo.setRow(String.valueOf(i+1));
			mSeatInfo.setSeatList(mSeatList);
			list_seatInfos.add(mSeatInfo);
			list_seat_conditions.add(mConditionList);
		}
	
	}
}
		
	
