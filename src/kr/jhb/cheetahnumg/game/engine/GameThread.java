package kr.jhb.cheetahnumg.game.engine;

import kr.jhb.cheetahnumg.game.stage.FirstStage;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View.OnTouchListener;

public class GameThread extends Thread{

	public static final long MILLIS_PER_FRAME = 33; // ~30fps // not guaranteed
	protected SurfaceHolder mHolder = null;
	
	
	private boolean isRunning = false; 
	
	
	private FirstStage mStage1;
	
	
	public GameThread(Context context, SurfaceHolder holder) {
		mHolder = holder;
		
		
		
		mStage1 = new FirstStage();
		mStage1.init(holder.getSurfaceFrame(), context.getResources().getDisplayMetrics().density);
	}
	
	@Override
	public synchronized void start() {
		isRunning = true;
		super.start();
	}
	
	public void setLoop(boolean loop) {
		isRunning = loop;
	}
	
	
	public void onTouchEvent(MotionEvent e) {
		if (mStage1 != null)
			mStage1.onTouchEvent(e);
	}
	
	
	@Override
	public void run() {
		super.run();
		
		long now = 0, dt;
		long last = System.currentTimeMillis();
		
		while (isRunning) {
			
			if (mHolder == null) return;
			Canvas c = null;
			try {
				c = mHolder.lockCanvas();
				
				if (c == null)
					continue;
				
				synchronized (mHolder) {
					now = System.currentTimeMillis();
					dt = (now - last);
					while (dt < MILLIS_PER_FRAME) {
						Thread.sleep(1);
						now = System.currentTimeMillis();
						dt = (now - last);
					}
					
					
					// 해줘야 할 것. 
					// 1. 터치 하기 전에는 그림을 계속 그릴 필요가 음씀.
					// 2. 전화 같은거 오는 경우 다시 그려야 하는것 예외 처리.
					
					mStage1.update(dt);
					mStage1.render(c, dt);
					
					
				}
			}
			catch(Exception e) {
				
			}
			finally {
				if (c!=null && mHolder!=null)
					mHolder.unlockCanvasAndPost(c);
			}
			
			
			last = now;
		}
		
		
	}
	
	
}
