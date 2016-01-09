package kr.jhb.cheetahnumg.util;

import android.content.Context;
import android.graphics.Typeface;

public class EnvSession {

	protected static Typeface mDefaultFont = null;
	
	public static Typeface getDefaultFont(Context context) {
		
		if (mDefaultFont == null)
			mDefaultFont = Typeface.createFromAsset(context.getAssets(), "NanumBarunGothic.ttf");
		
		return mDefaultFont;
	}
	
	
}
