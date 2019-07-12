package com.artplus.connect;

import android.app.Activity;
import android.content.Intent;

public class LoadData{
	public static ServerConnector.ConnectionType resultType(Intent in){
		return ServerConnector.ConnectionType.values()[in.getIntExtra("type", 0)];
	}
	public static void sendRegister(Activity a,String id,String pw,String email,String gender,String name,int age){
		ServerConnector.loadData(a,ConnectObj.createObj(ServerConnector.ConnectionType.REGISTER,
				"id", id,"pw", pw,"email",email,"gender", gender,"name", name,"age",String.valueOf(age)));
	}

	public static void sendCheckAccountId(Activity a,String email){
		ServerConnector.loadData(a,ConnectObj.createObj(ServerConnector.ConnectionType.CHECK_ACCOUNT_ID,
				"email",email));
	}
	public static void sendCheckAccountPw(Activity a,String email,String id){
		ServerConnector.loadData(a,ConnectObj.createObj(ServerConnector.ConnectionType.CHECK_ACCOUNT_PW,
				"email",email,"id",id));
	}
	public static void sendLogin(Activity a,String id,String pw){
		ServerConnector.loadData(a,ConnectObj.createObj(ServerConnector.ConnectionType.LOGIN,
				"pw",pw,"id",id));
	}
	public static void sendRegisterReview(Activity a,String id,String content,String center,String fest,double st){
		ServerConnector.loadData(a,ConnectObj.createObj(ServerConnector.ConnectionType.RESISTER_REVIEW,
				"id",id,"content",content,"star",String.valueOf(st),"festival",fest,"center",center));
	}

	//result

	public static LoadStat getRegisterReview(Intent i){
		return Integer.parseInt(i.getStringArrayListExtra("r").get(0))==1?LoadStat.SU:LoadStat.EX;
	}
	public static LoadStat getRegister(Intent i){
		System.out.println("뭐받음"+i.getStringArrayListExtra("r").get(0));
		switch(Integer.parseInt(i.getStringArrayListExtra("r").get(0))){
			case 1:
				return LoadStat.SU;
			case 2:
				return LoadStat.FA;//이미 등록되어있음
			case 3:
				return LoadStat.WR;
		}
		return LoadStat.EX;
	}
	public static LoadStat getLogin(Intent i){
		switch(Integer.parseInt(i.getStringArrayListExtra("r").get(0))){
			case 1:
				return LoadStat.SU;
			case 2:
				return LoadStat.FA;//이미 등록되어있음
		}
		return LoadStat.EX;
	}
	public static LoadResult getCheckAccountId(Intent i){
		String[] st=i.getStringArrayListExtra("r").get(0).split(":");
		switch(st[0]){
			case "1":
				return new LoadResult(LoadStat.FA,st[1]);
			case "2":
				return new LoadResult(LoadStat.SU,st[1]);
			default:
				return new LoadResult(LoadStat.WR,st[1]);
		}
	}
	public static LoadResult getCheckAccountPw(Intent i){
		String[] st=i.getStringArrayListExtra("r").get(0).split(":");
		switch(st[0]){
			case "1":
				return new LoadResult(LoadStat.FA,st[1]);
			case "2":
				return new LoadResult(LoadStat.WR,st[1]);
			default:
				return new LoadResult(LoadStat.SU,st[1]);
		}
	}
	public static class LoadResult{
		LoadData.LoadStat stt;
		String da;
		private LoadResult(LoadData.LoadStat st, String data){
			da=data;
			stt=st;
		}

		public LoadData.LoadStat getStat(){
			return this.stt;
		}

		public String getData(){
			return this.da;
		}
	}
	public static enum LoadStat{
		SU, //성공
		FA, //실패
		WR, //이상
		EX //진짜 예외
	}
}
