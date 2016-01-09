package kr.jhb.cheetahnumg.game;

import kr.jhb.cheetahnumg.R;
import kr.jhb.cheetahnumg.game.engine.GameView;
import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;

public class GameActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// setContentView(new GameView(this));
		setContentView(R.layout.activity_game);
		
		LinearLayout v = (LinearLayout)findViewById(R.id.ag_v_game);
		GameView gameView = new GameView(this);
		
		v.addView(gameView);
		
		
	}
	
}
