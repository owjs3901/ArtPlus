package com.artplus.connect;

import android.app.Activity;
import android.content.ContentProviderResult;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.artplus.LoadActivity;
import com.artplus.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ServerConnector{
	public static boolean isLoad=false;

	public static void loadData(Activity con, ConnectObj obj){
		Intent in=new Intent(con, LoadActivity.class);
		System.out.println("뭐야");
		in.putExtra("type", obj);
		con.startActivityForResult(in, 3000);

	}

	public static String ip="http://183.97.200.230:5647";
	public static enum ConnectionType implements Serializable{
		REGISTER(ip+"/register"),
		;
		private String url;
		ConnectionType(String st){
			try{
				url = st;
			}catch(Exception e){e.printStackTrace();}
		}

		public URL getUrl(Map<String,String> m){
			String ac="";
			if(m.size()>0){
				ac="?";
				for(String k:m.keySet())
					ac+=k+"="+m.get(k)+"&";
			}
			System.out.println("유알엘"+(this.url+ac.substring(0, ac.length()-1)));
			URL url=null;
			try{
				url=new URL(this.url+ac.substring(0, ac.length()-1));
			} catch(MalformedURLException e){
				e.printStackTrace();
			}
			return url;
		}
	}
	public static class Connect extends AsyncTask<ConnectObj,Void, List<String>>{
		private Activity con;
		public Connect(Activity con){
			this.con=con;
		}
		@Override
		protected void onPreExecute(){
			super.onPreExecute();
		}

		@Override
		protected List<String> doInBackground(ConnectObj... o){
			ArrayList<String> list=new ArrayList<>();
			try{
				BufferedReader r=new BufferedReader(new InputStreamReader(o[0].getType().getUrl(o[0].getMap()).openConnection().getInputStream()));
				while(true){
					String st=r.readLine();
					if(st==null)break;
					list.add(st);
				}

			}
			catch(Exception e){
				e.printStackTrace();
			}
			return list;
		}
		@Override
		protected void onProgressUpdate(final Void... values){
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(final List<String> strings){
			super.onPostExecute(strings);
			con.finish();
		}
	}
}
