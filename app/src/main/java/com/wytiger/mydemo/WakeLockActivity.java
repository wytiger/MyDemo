package com.wytiger.mydemo;


import android.app.Activity;
import android.os.Bundle;
import android.os.PowerManager;

import com.wytiger.mydemo.utils.WakeLockUtil;


public class WakeLockActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wake_lock);

		WakeLockUtil.acquireWakeLock(this, PowerManager.PARTIAL_WAKE_LOCK);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		WakeLockUtil.releaseWakeLock();
	}
}
