package com.artplus.connect;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.artplus.ArtInfoActivity;
import no.nordicsemi.android.support.v18.scanner.*;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class BLE{
	public static boolean b = false;

	public static String url = "";

	public static void startBLE(final Activity a){
		if(b) return;
		b = true;
		BluetoothLeScannerCompat scanner = BluetoothLeScannerCompat.getScanner();
		ScanSettings settings = new ScanSettings.Builder()
				.setLegacy(false)
				.setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
				.setReportDelay(1000)
				.setUseHardwareBatchingIfSupported(true)
				.build();
		List<ScanFilter> filters = new ArrayList<>();
		filters.add(new ScanFilter.Builder().setDeviceAddress("C8:F9:D8:D2:8D:F4").build());
		scanner.startScan(filters, settings, new ScanCallback(){
			@Override
			public void onScanResult(int callbackType, @NonNull ScanResult result){
				super.onScanResult(callbackType, result);
				try{
					String url1 = new String(result.getScanRecord().getBytes(), "utf-8").split("a@")[1];
					if(!url1.equals(url)){
						url=url1;
						Intent in=new Intent(a, ArtInfoActivity.class);
						in.putExtra("r", url);
						a.startActivity(in);
					}
				} catch(UnsupportedEncodingException e){
					e.printStackTrace();
				}
			}

			@Override
			public void onBatchScanResults(@NonNull List<ScanResult> results){
				super.onBatchScanResults(results);


				System.out.println("스캔 결과2"+results.size());
				for(final ScanResult r : results){
					try{
						String st=new String(r.getScanRecord().getBytes(), "UTF-8");
						System.out.println("BLE"+st);
						String url1 = st.split("a@")[1];
						if(!url1.equals(url)){
							url=url1;
							Intent in=new Intent(a, ArtInfoActivity.class);
							in.putExtra("r", url);
							a.startActivity(in);
						}
					} catch(UnsupportedEncodingException e){
						e.printStackTrace();
					}
				}
			}

			@Override
			public void onScanFailed(int errorCode){
				super.onScanFailed(errorCode);
				System.out.println("스캔 실패"+errorCode);
				b = false;
			}
		});
	}
}
