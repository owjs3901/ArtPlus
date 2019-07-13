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
		System.out.println("로드드드드");
		setContentView(R.layout.activity_load);

	}


	@Override
	protected void onResume(){
		super.onResume();
		System.out.println("스타트");
		ConnectObj on=(ConnectObj) getIntent().getSerializableExtra("type");
		System.out.println("스타트~~");

		try{
			System.out.println("스2323타트");

			list=new ServerConnector.Connect(this).execute(on).get();
		} catch(ExecutionException e){
			e.printStackTrace();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		Intent in=new Intent();
		ArrayList<String> li=new ArrayList<>();
		System.out.println("승승");
		for(int i = 0; i <list.size(); i++){
			if(list.get(i).trim().length()!=0)
				li.add(list.get(i));
		}
		if(list.size()==0)list.add("-1");
		System.out.println("승~승");
		in.putStringArrayListExtra("r", li);
		in.putExtra("type", on.getType().ordinal());
		setResult(RESULT_OK,in);
	}
}
