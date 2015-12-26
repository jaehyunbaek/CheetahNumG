package kr.jhb.cheetahnumg.game.engine;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

public interface IGame {

	void init(final Rect rect);
	void update(long dt);
	void render(Canvas c, long dt);
	void onTouchEvent(MotionEvent e);
	
	
	
}
