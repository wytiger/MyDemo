package com.wytiger.mydemo.test.screen;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.wytiger.mydemo.R;
import com.wytiger.mydemo.utils.ScreenUtil;
import com.wytiger.mydemo.utils.SystemUIUtil;


public class SystemUIActivity extends Activity {
	String TAG = "SystemUIUtil";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_system_ui);

	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			Log.i(TAG, "statusBarHeight = " + SystemUIUtil.getStatusBarHeight(this));
			Log.i(TAG, "navigationBarHeight = " + SystemUIUtil.getNavigationBarHeight(this));
			Log.i(TAG, "getRealMetrics = " + ScreenUtil.getRealMetrics(this));
			Log.i(TAG, "getRealSize = " + ScreenUtil.getRealSize(this));
		}
	}

}
