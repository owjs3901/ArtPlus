package com.artplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginLoseActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_lose);
	}

	@Override
	public void onBackPressed(){
		startActivity(new Intent(this,LoginActivity.class));
		finish();
	}

	public void onBack(View v){
		startActivity(new Intent(this,LoginActivity.class));
		finish();
	}
	public void onIdSearch(View v){
		startActivity(new Intent(this,IdLoseActivity.class));
		finish();
	}
	public void onPwSearch(View v){
		startActivity(new Intent(this,PwLoseActivity.class));
		finish();
	}
}
