package com.artplus.adapt;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.artplus.R;
import com.artplus.connect.ServerConnector;
import com.artplus.obj.Center;

import java.util.ArrayList;

public class CenterAdapter extends BaseAdapter{
	ArrayList<Center> list=new ArrayList<>();
	private LayoutInflater inflater;
	public CenterAdapter(Activity a){
		inflater=(LayoutInflater)a.getSystemService(a.LAYOUT_INFLATER_SERVICE);
	}
	public void addCenter(Center cc){
		list.add(cc);
	}
	@Override
	public int getCount(){
		return list.size();
	}

	@Override
	public Center getItem(int i){
		return list.get(i);
	}

	@Override
	public long getItemId(int i){
		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup){
		if(view==null)
			view=inflater.inflate(R.layout.search_el,viewGroup,false);
		Center c=list.get(i);
		if(!c.isLoad){
			((TextView) view.findViewById(R.id.name)).setText(c.name);
			c.loadImg((ImageView) view.findViewById(R.id.img1), (ImageView) view.findViewById(R.id.img2), (ImageView) view.findViewById(R.id.img3), (ImageView) view.findViewById(R.id.img4));
			((TextView) view.findViewById(R.id.tag)).setText(c.tag);
			((TextView) view.findViewById(R.id.date)).setText(c.date);
			((TextView) view.findViewById(R.id.adress)).setText(c.address);
			((TextView) view.findViewById(R.id.descrip)).setText(c.cont);
		}
		switch(c.star){
			case 10:
				((ImageView)view.findViewById(R.id.star5)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star4)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star3)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star2)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star1)).setImageResource(R.drawable.star1);
				break;
			case 9:
				((ImageView)view.findViewById(R.id.star5)).setImageResource(R.drawable.star05);
				((ImageView)view.findViewById(R.id.star4)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star3)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star2)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star1)).setImageResource(R.drawable.star1);
				break;
			case 8:
				((ImageView)view.findViewById(R.id.star4)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star3)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star2)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star1)).setImageResource(R.drawable.star1);
				break;
			case 7:
				((ImageView)view.findViewById(R.id.star4)).setImageResource(R.drawable.star05);
				((ImageView)view.findViewById(R.id.star3)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star2)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star1)).setImageResource(R.drawable.star1);
				break;

			case 6:
				((ImageView)view.findViewById(R.id.star3)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star2)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star1)).setImageResource(R.drawable.star1);
				break;

			case 5:
				((ImageView)view.findViewById(R.id.star3)).setImageResource(R.drawable.star05);
				((ImageView)view.findViewById(R.id.star2)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star1)).setImageResource(R.drawable.star1);
				break;
			case 4:
				((ImageView)view.findViewById(R.id.star2)).setImageResource(R.drawable.star1);
				((ImageView)view.findViewById(R.id.star1)).setImageResource(R.drawable.star1);
				break;

			case 3:
				((ImageView)view.findViewById(R.id.star2)).setImageResource(R.drawable.star05);
				((ImageView)view.findViewById(R.id.star1)).setImageResource(R.drawable.star1);
				break;

			case 2:
				((ImageView)view.findViewById(R.id.star1)).setImageResource(R.drawable.star1);
				break;

			case 1:
				((ImageView)view.findViewById(R.id.star1)).setImageResource(R.drawable.star05);
				break;

			case 0:
		}
		return view;
	}
}
