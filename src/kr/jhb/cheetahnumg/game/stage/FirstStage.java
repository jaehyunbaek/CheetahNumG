package kr.jhb.cheetahnumg.game.stage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import kr.jhb.cheetahnumg.game.engine.IGame;

public class FirstStage implements IGame{

	public final static int DEST_NO = 30;
	
	private Paint mPaintRed = null;
	private Paint mPaintBlack = null;
	
	private float mDx = 0;
	
	protected int mWidth = 0;
	protected int mHeight = 0;
	protected float mDensity = 0;
	
	
	protected int mCurNo = 1;
	
	protected PointF mNumberCoord[] = new PointF[50];
	
	@Override
	public void init(final Rect rect, float density) {
		
		
		mPaintRed = new Paint();
		mPaintRed.setColor(Color.RED);
		
		mPaintBlack = new Paint();
		mPaintBlack.setColor(Color.BLACK);
		
		mDx = 0;
		
		mWidth = rect.width();
		mHeight = rect.height();
		mDensity = density;
		
		
		// create coordinate
		for (int i = 1;i <= DEST_NO; i++) {
			PointF p = new PointF((float) (Math.random() * mWidth), (float) (Math.random() * mHeight));
			mNumberCoord[i] = p;			
			Log.v("TEST","x:"+Math.random() * mWidth+"/y:"+Math.random() * mHeight);
		}
		
		
	}

	@Override
	public void update(long dt) {

		mDx += (dt*0.9); // must use 'float'
		if (mDx > mWidth) mDx-=mWidth;
		// mDx += (int)(dt*0.9); // bad idea
		
		//for (int i = mCurNo)		
		
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
