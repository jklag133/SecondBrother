package com.gemptc.secondbrotherdemo.usermode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.gemptc.secondbrotherdemo.MainActivity;
import com.gemptc.secondbrotherdemo.MyApplication;


import android.os.AsyncTask;
import android.widget.Toast;

public class NetUtil {
	
	
	public static void uploadDataByHttpClientPost(final LoginActivity loginActivity,
			final String username, final String userpwd) {
		AsyncTask<Void, Void, String> at = new AsyncTask<Void, Void, String>(){

			private InputStream is;
			
			

			@Override
			protected String doInBackground(Void... params) {
				HttpClient client = new DefaultHttpClient();
				try {
					HttpPost post = new HttpPost(LoginActivity.PATH);
					List<NameValuePair> reqParams = new ArrayList<NameValuePair>();
					
					reqParams.add(new BasicNameValuePair("username", URLEncoder.encode(username,"UTF-8")));
					reqParams.add(new BasicNameValuePair("userpwd", URLEncoder.encode(userpwd,"UTF-8")));
					System.out.println(reqParams);
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(reqParams);
					post.setEntity(entity);
					
					HttpResponse response = client.execute(post);
					if(response.getStatusLine().getStatusCode()==200){
						is = response.getEntity().getContent();
						byte[] buffer = new byte[1024];
						int len;
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						while((len = is.read(buffer))>0){
							bos.write(buffer,0,len);
						}
						String back = new String(bos.toByteArray());
						System.out.println(back);
						return back;
					}
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					if(is!=null){
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					}
				}
				return null;
			}
			
			@Override
			protected void onPostExecute(String result) {
				super.onPostExecute(result);
				if (result != null) {
					MyApplication my=(MyApplication) loginActivity.getApplication();
					if ("true".equals(result)) {
						Toast.makeText(loginActivity, "登陆成功",
								Toast.LENGTH_SHORT).show();
						my.setUSER(true);
						loginActivity.finish(0);
					} else if ("false".equals(result)) {
						Toast.makeText(loginActivity, "登录失败",
								Toast.LENGTH_SHORT).show();
					}
				}
			}
		};
		at.execute();
		
	}
	
	
}
