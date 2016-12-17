package com.wytiger.mydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * 需要设置透明主题
 */
public class GlobalActivity extends Activity {
    public static GlobalActivity instance;
    String TAG = "GlobalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);
        instance = this;
        startActivity(new Intent(this, MainActivity.class));
        Log.e(TAG, "onCreate");
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }
}
