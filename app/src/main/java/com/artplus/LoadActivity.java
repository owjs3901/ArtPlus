package com.artplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.artplus.connect.ConnectObj;
import com.artplus.connect.ServerConnector;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoadActivity extends AppCompatActivity{

	private List<String> list;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		System.out.println("로드드드드");
		setContentView(R.layout.activity_load);
		try{
			list=new ServerConnector.Connect(this).execute((ConnectObj) getIntent().getSerializableExtra("type")).get();
		} catch(ExecutionException e){
			e.printStackTrace();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		Intent in=new Intent();
		String[] st=new String[list.size()];
		for(int i = 0; i <list.size(); i++)
			st[i]=list.get(i);
		in.putExtra("r", st);
		setResult(RESULT_OK,in);
	}
}
