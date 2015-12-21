package kr.jhb.cheetahnumg.game.stage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import kr.jhb.cheetahnumg.game.engine.IGame;

public class FirstStage implements IGame{

	private Paint mPaintRed = null;
	private Paint mPaintBlack = null;
	
	private float mDx = 0;
	// private int mDx = 0; // bad idea
	
	@Override
	public void init() {

		mPaintRed = new Paint();
		mPaintRed.setColor(Color.RED);
		
		mPaintBlack = new Paint();
		mPaintBlack.setColor(Color.BLACK);
		
		mDx = 0;
	}

	@Override
	public void update(long dt) {

		mDx += (dt*0.9); // must use 'float'
		// mDx += (int)(dt*0.9); // bad idea
		
		if (mDx > 900)
			mDx -= 900;
		
		
		
		
		
	}

	@Override
	public void render(Canvas c, long dt) {

		c.drawColor(Color.WHITE);
		
		c.drawRect(0, 0, mDx, 100, mPaintRed);
		
		
	}

	@Override
	public void onTouchEvent(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
