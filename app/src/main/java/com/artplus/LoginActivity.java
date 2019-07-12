package com.artplus;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.artplus.connect.LoadData;
import com.artplus.connect.ServerConnector;

public class LoginActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		findViewById(R.id.register).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
				finish();
			}
		});
		findViewById(R.id.login).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				LoadData.sendLogin(LoginActivity.this, ((EditText)findViewById(R.id.id)).getText().toString(),((EditText)findViewById(R.id.pw)).getText().toString() );
			}
		});
		findViewById(R.id.guest_login).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){

			}
		});
	}

	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if(LoadData.getLogin(data)== LoadData.LoadStat.SU){
			startActivity(new Intent(this,SelectActivity.class));
			finish();
		}
		else Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show();
	}
}
