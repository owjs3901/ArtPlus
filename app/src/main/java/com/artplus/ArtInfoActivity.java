package com.artplus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ImageReader;
import android.net.Uri;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import com.artplus.connect.BLE;
import com.artplus.connect.ConnectObj;
import com.artplus.connect.ServerConnector;
import no.nordicsemi.android.support.v18.scanner.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

public class ArtInfoActivity extends AppCompatActivity{
	public static String ip = "http://221.153.203.86:88/";
	String url;

	String im;
	String vi;
	String mp;
	String name;
	String lore="";
	VideoView videoView=null;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_art_info);
		System.out.println("시작이야!");
		url = getIntent().getStringExtra("r").split("@a")[0];
		findViewById(R.id.im).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				findViewById(R.id.im).setVisibility(View.INVISIBLE);
				videoView.start();
			}
		});
		new Thread(){
			@Override
			public void run(){
				super.run();
				try{
					System.out.println("시작!!!!@@@@@@@@@이야!");
					BufferedReader r = new BufferedReader(new InputStreamReader(new URL(ip+url+".txt").openStream(), Charset.forName("UTF-8")));
					im=r.readLine();
					vi=r.readLine();
					mp=r.readLine();
					name=r.readLine();
					System.out.println("시작!!!!@@@@@@@@@이야!"+im+"/"+vi+"/"+mp);
					lore=name;

					while(true){
						String ac=r.readLine();
						if(ac==null)break;
						lore+=ac+" ";
					}
					r.close();
					final Bitmap bit = BitmapFactory.decodeStream(new URL(ip+url+"%2E"+im).openStream());
					runOnUiThread(new Runnable(){
						@Override
						public void run(){
							((ImageView) findViewById(R.id.im)).setImageBitmap(bit);
							((TextView)findViewById(R.id.lore)).setText(lore);
							String LINK = ip+url+"."+vi;
							videoView =(VideoView)findViewById(R.id.vi);
							MediaController mc = new MediaController(ArtInfoActivity.this);
							mc.setAnchorView(videoView);
							mc.setMediaPlayer(videoView);
							Uri video = Uri.parse(LINK);
							videoView.setMediaController(null);
							videoView.setVideoURI(video);
							videoView.requestFocus();
						}
					});

				} catch(MalformedURLException e){
					e.printStackTrace();
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		}.start();


	}

	@Override
	protected void onResume(){
		super.onResume();
	}

	@Override
	protected void onDestroy(){
		super.onDestroy();
		BLE.b=false;
	}

	@Override
	public void onBackPressed(){
		super.onBackPressed();
		BLE.b=false;

	}

	@Override
	protected void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data){
		super.onActivityResult(requestCode, resultCode, data);
	}
}