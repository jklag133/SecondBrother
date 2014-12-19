package com.gemptc.secondbrotherdemo.usermode;

import com.example.fragmentdemo.R;
import com.gemptc.secondbrotherdemo.MainActivity;
import com.gemptc.secondbrotherdemo.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener{
	private EditText user_name;
	private EditText user_pwd;
	private TextView registered;
	private TextView forgotpwd;
	private Button login_btn2;
	private TextView title_tv;
	private ImageView title_iv;
	
	public static final String PATH="http://10.30.6.6:8080/WebServletabc/servlet/ofUserLoginServlet";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.login_layout);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_layout);

		title_iv = (ImageView) findViewById(R.id.title_iv);
		title_tv = (TextView) findViewById(R.id.title_tv);
		title_iv.setImageResource(R.drawable.share);
		title_tv.setText("账户登录");
		user_name = (EditText) findViewById(R.id.user_name);
		user_pwd = (EditText) findViewById(R.id.user_pwd);
		registered = (TextView) findViewById(R.id.registered);
		forgotpwd = (TextView) findViewById(R.id.forgotpwd);
		login_btn2 = (Button) findViewById(R.id.login_btn2);
		registered.setOnClickListener(this);
		forgotpwd.setOnClickListener(this);
		login_btn2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if(id == R.id.registered){
			Intent intent = new Intent(this,RegisteredActivity.class);
			startActivity(intent);
		}else if(id == R.id.forgotpwd){
			Intent intent = new Intent(this,ForgotActivity.class);
			startActivity(intent);
		}else if(id == R.id.login_btn2){
			String username = user_name.getText().toString();
			String userpwd = user_pwd.getText().toString();
			NetUtil.uploadDataByHttpClientPost(LoginActivity.this, username, userpwd);
			
//			if(user==true){
//			finish();
//			}
		}
	}
	public void finish(int i){
		if(i==0){
			MyApplication my=(MyApplication) this.getApplication();
			System.out.println(my.isUSER());
			this.finish();
		}
		
	}
}
