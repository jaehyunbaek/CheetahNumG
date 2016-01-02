package kr.jhb.cheetahnumg;

import kr.jhb.cheetahnumg.game.GameActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			
					
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void onClickTvTmp(View v) {
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
		
		/*
		Rect rt1 = new Rect(10,100,210,300);
		Rect rt2 = new Rect(5,50,250,200);
		//Rect rt1 = new Rect(378);
		//Rect rt2 = new Rect(540,780,624,855);
		
		boolean flag = rt1.intersect(rt2);
		Log.v("TEST",flag+"");
		Log.v("TEST",rt1.toShortString());
		Log.v("TEST",rt2.toShortString());
		*/
		
	}
	
	
}
