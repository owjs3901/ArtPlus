package com.artplus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DashBoardActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener{

	List<TextView> list = new ArrayList<>();


	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dash_board);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
				this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
		drawer.addDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);

		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag1));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag2));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag3));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag4));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag5));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag6));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag7));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag8));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag9));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag10));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag11));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag12));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag13));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag14));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag15));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag16));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag17));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag18));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag19));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag20));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag21));
		list.add((TextView) navigationView.getHeaderView(0).findViewById(R.id.tag22));
		for(final TextView t : list){
			t.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View view){
					t.setTextColor(getColor(t.getCurrentTextColor() == getColor(R.color.thema_grey) ? R.color.thema : R.color.thema_grey));
				}
			});
		}
	}

	@Override
	public void onBackPressed(){
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if(drawer.isDrawerOpen(GravityCompat.START)){
			drawer.closeDrawer(GravityCompat.START);
		}
		else{
			super.onBackPressed();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		// Inflate the menu; this adds items to the action bar if it is present.
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if(id == R.id.action_settings){
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("StatementWithEmptyBody")
	@Override
	public boolean onNavigationItemSelected(MenuItem item){
		// Handle navigation view item clicks here.
		int id = item.getItemId();

		if(id == R.id.nav_camera){
			// Handle the camera action
		}
		else if(id == R.id.nav_gallery){

		}
		else if(id == R.id.nav_slideshow){

		}
		else if(id == R.id.nav_manage){

		}
		else if(id == R.id.nav_share){

		}
		else if(id == R.id.nav_send){

		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}
}
