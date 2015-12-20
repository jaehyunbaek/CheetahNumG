package kr.jhb.cheetahnumg.game;

import kr.jhb.cheetahnumg.game.engine.GameView;
import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(new GameView(this));
		
		
	}
	
}
