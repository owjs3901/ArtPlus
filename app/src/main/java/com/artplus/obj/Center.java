package com.artplus.obj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Center{
	public String name,address,date,tag;
	public int star=0;
	public ArrayList<String> list=new ArrayList<>();
	public Bitmap bit1,bit2,bit3,bit4;
	public String bit11,bit22,bit33,bit44;
	public Center(String name,String ad,String dat,String tag,int star,String b1,String b2,String b3,String b4,String... lore){
		this.name=name;
		address=ad;
		date=dat;
		this.tag=tag;
		this.star=star;
		bit11=b1;
		bit22=b2;
		bit33=b3;
		bit44=b4;
		for(String l:lore)
			list.add(l);
	}
	public void loadImg(final ImageView v1, final ImageView v2, final ImageView v3, final ImageView v4){
		new AsyncTask<String,Bitmap,Void>(){
			@Override
			protected Void doInBackground(String... strings){
				Bitmap[] bits=new Bitmap[4];
				for(int i = 0; i < 4; i++){
					try{
						bits[i] = BitmapFactory.decodeStream(new URL(strings[i]).openStream());
					} catch(IOException e){
						e.printStackTrace();
					}
				}
				publishProgress(bits);
				return null;
			}

			@Override
			protected void onProgressUpdate(final Bitmap... values){
				super.onProgressUpdate(values);
				v1.setImageBitmap(values[0]);
				v2.setImageBitmap(values[1]);
				v3.setImageBitmap(values[2]);
				v4.setImageBitmap(values[3]);
			}
		}.execute(bit11,bit22,bit33,bit44);
	}
}
