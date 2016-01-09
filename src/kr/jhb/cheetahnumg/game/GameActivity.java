package kr.jhb.cheetahnumg.game;

import kr.jhb.cheetahnumg.R;
import kr.jhb.cheetahnumg.game.engine.GameView;
import kr.jhb.cheetahnumg.util.EnvSession;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends Activity{

	protected TextView mTvCount = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// setContentView(new GameView(this));
		setContentView(R.layout.activity_game);
		
		mTvCount = (TextView)findViewById(R.id.ag_tv_count);
		//mTvCount.setTypeface(EnvSession.getDefaultFont(this));
		
		LinearLayout v = (LinearLayout)findViewById(R.id.ag_v_game);
		GameView gameView = new GameView(this);
		
		
		
		v.addView(gameView);
		
		mTimer.start();
		
		
	}
	
	CountDownTimer mTimer = new CountDownTimer(1000000,100) {
		
		@Override
		public void onTick(long millisUntilFinished) {

			// Log.v("TEST",millisUntilFinished+"");
			
			long ss = (1000000-millisUntilFinished)/100 - 30;
			
			long s = ss / 10;
			ss = ss % 10;
			if (s >= 0 && ss >= 0) // start
				mTvCount.setText(s+"."+ss);
			else if (s >= -3) // ready
				mTvCount.setText(-(s-1)+"");
			
		}
		
		@Override
		public void onFinish() {

			Log.v("TEST","FINISH");
			
		}
	};
	
	
}
