package com.artplus;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import com.artplus.connect.LoadData;

public class RegisterActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		findViewById(R.id.gender_g).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				((RadioButton)findViewById(R.id.gender_g)).setChecked(true);
				((RadioButton)findViewById(R.id.gender_m)).setChecked(false);
			}
		});

		findViewById(R.id.gender_m).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				((RadioButton)findViewById(R.id.gender_g)).setChecked(false);
				((RadioButton)findViewById(R.id.gender_m)).setChecked(true);
			}
		});
		findViewById(R.id.back).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
				finish();
			}
		});
		findViewById(R.id.register).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				String name=((EditText)findViewById(R.id.name)).getText().toString();
				String id=((EditText)findViewById(R.id.id)).getText().toString();
				String gender=((RadioButton)findViewById(R.id.gender_g)).isChecked()?"G":"M";
				String pw=((EditText)findViewById(R.id.pw)).getText().toString();
				String email=((EditText)findViewById(R.id.mail)).getText().toString();
				int age=Integer.parseInt(((EditText)findViewById(R.id.age)).getText().toString());
				LoadData.sendRegister(RegisterActivity.this, id,pw,email,gender, name, age%10*10);
			}
		});
	}

	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		switch(LoadData.getRegister(data)){
			case EX:
				Toast.makeText(this, "심각한 오류", Toast.LENGTH_LONG).show();
				break;
			case FA:
				Toast.makeText(this, "이미 존재하는 계정입니다", Toast.LENGTH_LONG).show();
				break;
			case SU:
				startActivity(new Intent(this,SelectActivity.class));
				finish();
				break;
			case WR:
				Toast.makeText(this, "서버쪽 오류", Toast.LENGTH_LONG).show();
				break;
		}
	}
}
