package kr.jhb.cheetahnumg.game.engine;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface IGame {

	void init();
	void update(long dt);
	void render(Canvas c, long dt);
	void onTouchEvent(MotionEvent e);
	
	
	
}
