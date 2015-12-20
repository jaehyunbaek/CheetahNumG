package kr.jhb.cheetahnumg.game.engine;

import kr.jhb.cheetahnumg.game.stage.FirstStage;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread{

	public static final long MILLIS_PER_FRAME = 33; // ~30fps // not guaranteed
	protected SurfaceHolder mHolder = null;
	
	
	private boolean isRunning = false; 
	
	
	private FirstStage mStage1;
	
	
	public GameThread(SurfaceHolder holder) {
		mHolder = holder;
		
		
		
		mStage1 = new FirstStage();
		mStage1.init();
		
	}
	
	@Override
	public synchronized void start() {
		isRunning = true;
		super.start();
	}
	
	public void setLoop(boolean loop) {
		isRunning = loop;
	}
	
	
	
	@Override
	public void run() {
		super.run();
		
		long now, dt;
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
					if (dt < MILLIS_PER_FRAME) {
						//Thread.sleep(MILLIS_PER_FRAME-dt); // not guaranteed 
						//dt = MILLIS_PER_FRAME;
						continue;
					}
					
					
					mStage1.update(dt);
					mStage1.render(c, dt);
					Log.v("TEST","TEST"+dt);
					
					
					
					
					last = now;
				}
			}
			catch(Exception e) {
				
			}
			finally {
				if (c!=null && mHolder!=null)
					mHolder.unlockCanvasAndPost(c);
			}
			
			
			
		}
		
		
	}
	
	
}
