package com.artplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class SelectActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);

		findViewById(R.id.layout_1_img).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				((ImageView)findViewById(R.id.layout_1_img)).setImageDrawable(getDrawable(R.drawable.w1_on));
				((ImageView)findViewById(R.id.layout_2_img)).setImageDrawable(getDrawable(R.drawable.w2_off));
				((RadioButton) findViewById(R.id.layout_1)).setChecked(true);
				((RadioButton) findViewById(R.id.layout_2)).setChecked(false);
			}
		});
		findViewById(R.id.layout_2_img).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				((ImageView)findViewById(R.id.layout_2_img)).setImageDrawable(getDrawable(R.drawable.w2_on));
				((ImageView)findViewById(R.id.layout_1_img)).setImageDrawable(getDrawable(R.drawable.w1_off));
				((RadioButton) findViewById(R.id.layout_2)).setChecked(true);
				((RadioButton) findViewById(R.id.layout_1)).setChecked(false);
			}
		});
		findViewById(R.id.ok).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				if(((RadioButton) findViewById(R.id.layout_1)).isChecked()){
					startActivity(new Intent(SelectActivity.this, MainActivity.class));
					finish();
				}
				else Toast.makeText(SelectActivity.this, "책자형은 선택할 수 없습니다.", Toast.LENGTH_LONG).show();
			}
		});
	}
}
