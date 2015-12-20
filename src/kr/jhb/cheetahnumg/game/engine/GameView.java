package kr.jhb.cheetahnumg.game.engine;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{

	protected GameThread mGameThread = null;
	
	
	
	public GameView(Context context) {
		super(context);

		SurfaceHolder holder = getHolder();
		holder.addCallback(this);
		
	}
		
	@Override
	public void surfaceCreated(SurfaceHolder holder) {

		
		mGameThread = new GameThread(getHolder());
		mGameThread.start();
		
		
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

		Log.v("TEST","surfaceChanged");
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

		boolean retry = true;
		mGameThread.setLoop(false);
		
		
		while (retry) {
			try {
				mGameThread.join();
				retry = false;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
