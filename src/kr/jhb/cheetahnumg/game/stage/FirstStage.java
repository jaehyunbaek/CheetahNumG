package kr.jhb.cheetahnumg.game.stage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import kr.jhb.cheetahnumg.game.engine.IGame;

public class FirstStage implements IGame{

	public final static int DEST_NO = 30;
	protected final int FONT_SIZE_MIN = 20;
	protected final int FONT_SIZE_MAX = 100;
	
	
	private Paint mPaintRed = null;
	private Paint mPaintBlack = null;
	private Paint mPaintFont = null;
	
	private float mDx = 0;
	
	protected int mScreenWidth = 0;
	protected int mScreenHeight = 0;
	protected float mScreenDensity = 0;
	
	
	protected Integer mCurNo = 1;
	
	// protected Point mNumberCoord[] = new Point[DEST_NO+1];
	protected int mFontSize[] = new int[DEST_NO+1];
	protected Rect mNumberRect[] = new Rect[DEST_NO+1];
	
	
	
	@Override
	public void init(final Rect screenRect, float density) {
		
		mPaintFont = new Paint();
		mPaintFont.setColor(Color.BLACK);
		mPaintFont.setTextAlign(Align.LEFT);
		// mPaintFont.setTextSize(density * 100);
		
		mPaintRed = new Paint();
		mPaintRed.setColor(Color.RED);
		
		mPaintBlack = new Paint();
		mPaintBlack.setColor(Color.BLACK);
		
		mDx = 0;
		
		mScreenWidth = screenRect.width();
		mScreenHeight = screenRect.height();
		mScreenDensity = density;
		
		
		// generate coordinate
		for (int i = 1;i <= DEST_NO; i++) {
			
			boolean flag = true;
			Point p = null;
			int fontSize = 0;
			Rect rect = new Rect();
			
			
			while (flag) {
				p = new Point( (int)(Math.random() * mScreenWidth), (int)(Math.random() * mScreenHeight));
				fontSize = (int) ((Math.random() * (FONT_SIZE_MAX - FONT_SIZE_MIN) + FONT_SIZE_MIN)*density);
				flag = checkCollision(i, p, fontSize, rect);
			}
			
			mFontSize[i] = fontSize;
			//mNumberCoord[i] = p;
			mNumberRect[i] = rect;
			
			
		}
	}
	
	
	/**
	 * 
	 * @param no
	 * @param p
	 * @param fontSize
	 * @param rect return bound rect coord
	 * @return true if it has a collision
	 */
	boolean checkCollision(int no, Point p, float fontSize, Rect rect) {
		
		String text = no+"";
		Rect bounds = new Rect();

		mPaintFont.setTextSize(fontSize);
		mPaintFont.getTextBounds(text, 0, text.length(), bounds);
		
		rect.left = p.x;
		rect.top = p.y - (bounds.bottom + bounds.height());
		rect.right = p.x + (bounds.left + bounds.width());
		rect.bottom = p.y;
		
		// check collision with screen		
		if (rect.top < 0 || rect.left < 0 || rect.right > mScreenWidth || rect.bottom > mScreenHeight)
			return true;
		
		
		// check collision with another rect
		for (int i = 1; i < no; i++) {
			Rect tmp = new Rect(mNumberRect[i]);
			
			if (tmp.intersect(rect)) {
				return true;
			}
		}
		
		return false;
	}
		
	
	

	@Override
	public void update(long dt) {

		//mDx += (dt*0.9); // must use 'float'
		//if (mDx > mWidth) mDx-=mWidth;
		// mDx += (int)(dt*0.9); // bad idea
		
		//for (int i = mCurNo)		
		
	}

	@Override
	public void render(Canvas c, long dt) {

		c.drawColor(Color.WHITE);
		
		synchronized (mCurNo) {
			for (int i = mCurNo; i <= DEST_NO; i++) {
				mPaintFont.setTextSize(mFontSize[i]);
				// c.drawText(i+"", mNumberCoord[i].x, mNumberCoord[i].y, mPaintFont);
				c.drawText(i+"", mNumberRect[i].left, mNumberRect[i].bottom, mPaintFont);
				
				/*
				{
					c.drawCircle(mNumberRect[i].left, mNumberRect[i].top, 5, mPaintRed);
					c.drawCircle(mNumberRect[i].right, mNumberRect[i].bottom, 5, mPaintRed);
					
					c.drawCircle(mNumberCoord[i].x, mNumberCoord[i].y, 5, mPaintBlack);
				}
				*/
			}
		}
		
		
	}

	@Override
	public void onTouchEvent(MotionEvent e) {

		synchronized (mCurNo) {
			int x = (int) e.getX();
			int y = (int) e.getY();
			
			final int margin = (int) (10*mScreenDensity);
			
			if (mNumberRect[mCurNo].left-margin <= x && x <= mNumberRect[mCurNo].right+margin &&
					mNumberRect[mCurNo].top-margin <= y && y <= mNumberRect[mCurNo].bottom+margin) {
				mCurNo++;
				Log.v("TESTY",mCurNo+"");
			}
			Log.v("TESTN",mCurNo+"");
		}
		
		
	}

}
