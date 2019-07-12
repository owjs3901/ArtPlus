package com.artplus.connect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ConnectObj implements Serializable{
	private int type;
	private HashMap<String, String> map;

	private ConnectObj(ServerConnector.ConnectionType type, HashMap<String, String> map){
		this.map = map;
		this.type = type.ordinal();
	}

	public ServerConnector.ConnectionType getType(){
		return ServerConnector.ConnectionType.values()[type];
	}

	public HashMap<String, String> getMap(){
		return this.map;
	}

	public static ConnectObj createObj(ServerConnector.ConnectionType type, String... st){
		 try{
			 if(st.length%2 == 1)
				throw new Exception();
			HashMap m = new HashMap<>();
			for(int i = 0; i < st.length; i += 2) m.put(st[i], st[i+1]);
			return new ConnectObj(type, m);
		} catch(Exception e){
			e.printStackTrace();
		}
		 return null;
	}
}
