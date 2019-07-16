package com.artplus.obj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Center{
	public String name,address,date,tag,cont;
	public int star=0;
	public String bit11,bit22,bit33,bit44;
	public boolean isLoad=false;
	private Center(String name,String ad,String dat,String tag,int star,String[] b,String lore){
		System.out.println("크리에이트"+name);
		this.name=name;
		address=ad;
		date=dat;
		this.tag=tag.replace("tag", "".replace(":", " #"));
		this.star=star;
		bit11=b[0].trim();
		bit22=b[1].trim();
		bit33=b[2].trim();
		bit44=b[3].trim();
		cont=lore;
	}
	public void loadImg(final ImageView v1, final ImageView v2, final ImageView v3, final ImageView v4){
		isLoad=true;
		new AsyncTask<String,Bitmap,Void>(){
			@Override
			protected Void doInBackground(String... strings){
				Bitmap[] bits=new Bitmap[4];
				for(int i = 0; i < 4; i++){
					try{
						System.out.println("비트"+strings[i]);
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
	public static Center createCenter(String st){
		String[] k=st.split("@!@");
		// 이름
		// 태그
		// 주소
		// 내용
		// 사진
		// 별점
		return new Center(k[0],k[2],"날짜",k[1],Integer.parseInt(k[5]),k[4].split(" @!!!@ "),k[3]);
	}
}
