package com.artplus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity{
	boolean isConnected;
	TextView tvId;
	Region region;
	@Override protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvId = (TextView) findViewById(R.id.tvId);
		BeaconManager beaconManager = new BeaconManager(this);
		isConnected = false;
		beaconManager.setRangingListener(new BeaconManager.RangingListener(){
			@Override
			public void onBeaconsDiscovered(Region region, List<Beacon> list){
				if(!list.isEmpty()){
					Beacon nearestBeacon = list.get(0);
					Log.d("Airport", "Nearest places: "+nearestBeacon.getRssi());
					tvId.setText(nearestBeacon.getRssi()+"");
					if(!isConnected && nearestBeacon.getRssi() > -70){
						isConnected = true;
						AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
						dialog.setTitle("알림").setMessage("비콘이 연결되었습니다.").setPositiveButton("확인", new DialogInterface.OnClickListener(){
							@Override
							public void onClick(DialogInterface dialog, int which){
							}
						}).create().show();
					}
					else if(isConnected && nearestBeacon.getRssi() < -70){
						Toast.makeText(MainActivity.this, "연결이 끊어졌습니다.", Toast.LENGTH_SHORT).show();
						isConnected = false;
					}
				}
			}
		});
		region = new Region("ranged region", UUID.fromString("74278BDA-B644-4520-8F0C-720EAF059935"), null, null);
	}

	@Override
	protected void onResume(){
		super.onResume();
		SystemRequirementsChecker.checkWithDefaultDialogs(this);

	}
}
