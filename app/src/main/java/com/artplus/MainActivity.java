package com.artplus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import no.nordicsemi.android.support.v18.scanner.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity{
	TextView tvId;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvId = findViewById(R.id.tvId);



		BluetoothLeScannerCompat scanner = BluetoothLeScannerCompat.getScanner();
		ScanSettings settings = new ScanSettings.Builder()
				.setLegacy(false)
				.setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
				.setReportDelay(1000)
				.setUseHardwareBatchingIfSupported(true)
				.build();
		List<ScanFilter> filters = new ArrayList<>();
		filters.add(new ScanFilter.Builder().setDeviceAddress("C8:F9:D8:D2:8D:F4").build());
//		filters.add(new ScanFilter.Builder().setServiceUuid(mUuid).build());
		System.out.println("뭥ㅁㅇ");
		scanner.startScan(filters,settings,new ScanCallback(){
			@Override
			public void onScanResult(int callbackType, @NonNull ScanResult result){
				super.onScanResult(callbackType, result);
				System.out.println("스캔 결과"+result.toString());
			}

			@Override
			public void onBatchScanResults(@NonNull List<ScanResult> results){
				super.onBatchScanResults(results);



				System.out.println("스캔 결과2"+results.size());
				for(ScanResult r:results){
					System.out.println("=====================================");
					System.out.println("distance"+r.getRssi());
					System.out.println("name"+r.getDevice().getName());
					System.out.println(r.toString());
					System.out.println("sc"+r.getScanRecord());
					System.out.println(r.getDevice().toString());

					try{
						Toast.makeText(MainActivity.this, new String(r.getScanRecord().getBytes(),"utf-8"), Toast.LENGTH_SHORT).show();
					} catch(UnsupportedEncodingException e){
						e.printStackTrace();
					}
				}


			}

			@Override
			public void onScanFailed(int errorCode){
				super.onScanFailed(errorCode);
				System.out.println("스캔 실패"+errorCode);

			}
		});
	}

	@Override
	protected void onResume(){
		super.onResume();
	}

	@Override
	protected void onDestroy(){

		super.onDestroy();
	}

}
