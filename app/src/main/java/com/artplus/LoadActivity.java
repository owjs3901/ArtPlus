package com.artplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.artplus.connect.ConnectObj;
import com.artplus.connect.ServerConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LoadActivity extends AppCompatActivity{

	private List<String> list;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_load);

	}

	@Override
	protected void onResume(){
		super.onResume();
		System.out.println("로딩 시작");
		ConnectObj on=(ConnectObj) getIntent().getSerializableExtra("type");
		try{
			System.out.println("로딩 진짜 시작");

			list=new ServerConnector.Connect(this).execute(on).get();
		} catch(ExecutionException e){
			e.printStackTrace();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("로딩끝");
		Intent in=new Intent();
		ArrayList<String> li=new ArrayList<>();
		for(int i = 0; i <list.size(); i++){
			if(list.get(i).trim().length()!=0)
				li.add(list.get(i));
		}
		if(list.size()==0)list.add("-1");
		in.putStringArrayListExtra("r", li);
		in.putExtra("type", on.getType().ordinal());
		setResult(RESULT_OK,in);
	}
}
