package com.wytiger.mydemo.test.permission;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.wytiger.mydemo.R;
import com.wytiger.mydemo.Tags;
import com.wytiger.mydemo.utils.PermissionUtil2;

public class CheckPermissionActivity extends Activity implements OnClickListener {
	private static String TAG = Tags.TAG_PERMISSION;
	private TextView tvPermission;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_permission);

		tvPermission = (TextView) findViewById(R.id.tvPermission);
		findViewById(R.id.btnRecordPermission).setOnClickListener(this);
		findViewById(R.id.btnCameraPermission).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnRecordPermission:
			tvPermission.setText("RecordPermission:"+ PermissionUtil2.hasRecordPermission());
			break;
			
		case R.id.btnCameraPermission:
			tvPermission.setText("CameraPermission:"+PermissionUtil2.hasCameraPermission());
			break;

		default:
			break;
		}

	}
}
