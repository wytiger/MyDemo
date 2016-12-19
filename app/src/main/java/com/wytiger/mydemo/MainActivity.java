package com.wytiger.mydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.wytiger.mydemo.test.permission.CheckPermissionActivity;
import com.wytiger.mydemo.test.screen.ScreenActivity;
import com.wytiger.mydemo.test.screen.SystemUIActivity;
import com.wytiger.mydemo.test.screen.WindowDemoActivity;
import com.wytiger.mydemo.test.zoom.SurfaceZoomActivity;
import com.wytiger.mydemo.test.zoom.ZoomActivity;


public class MainActivity extends Activity implements OnClickListener {
	private static String TAG = "MyDemo";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.btnGrayUnckickable).setOnClickListener(this);
		findViewById(R.id.btnWindow).setOnClickListener(this);
		findViewById(R.id.btnSurfaceZoom).setOnClickListener(this);
		findViewById(R.id.btnZoom).setOnClickListener(this);
		findViewById(R.id.btnCheckPermission).setOnClickListener(this);
		findViewById(R.id.btnSystemUI).setOnClickListener(this);
		findViewById(R.id.btnScreen).setOnClickListener(this);


	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnGrayUnckickable:
			startActivity(new Intent(MainActivity.this, UnclickGrayActivity.class));
			break;
			
		case R.id.btnWindow:
			startActivity(new Intent(MainActivity.this, WindowDemoActivity.class));
			break;
			
		case R.id.btnSurfaceZoom:
			startActivity(new Intent(MainActivity.this, SurfaceZoomActivity.class));
			break;

		case R.id.btnZoom:
			startActivity(new Intent(MainActivity.this, ZoomActivity.class));
			break;

		case R.id.btnCheckPermission:
			startActivity(new Intent(MainActivity.this, CheckPermissionActivity.class));
			break;
			

			
		case R.id.btnSystemUI:
			startActivity(new Intent(MainActivity.this, SystemUIActivity.class));
			break;
			
		case R.id.btnScreen:
			startActivity(new Intent(this, ScreenActivity.class));
			break;
			
		default:
			break;
		}

	}

}
