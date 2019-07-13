package com.artplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GuestLoginActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guest_login);


		findViewById(R.id.login).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				startActivity(new Intent(GuestLoginActivity.this,SelectActivity.class));
				finish();
			}
		});
		findViewById(R.id.back).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				startActivity(new Intent(GuestLoginActivity.this,LoginActivity.class));
				finish();
			}
		});
	}

	@Override
	public void onBackPressed(){
		startActivity(new Intent(GuestLoginActivity.this,LoginActivity.class));
		finish();
	}
}
