package com.wytiger.mydemo.dameon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wytiger.mydemo.R;

public class DaemonProcessActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daemon_process);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                startService(new Intent(this, LocalService.class));
                break;
            case R.id.button2:
                stopService(new Intent(this, LocalService.class));
                break;
            case R.id.button3:
                stopService(new Intent(this, RemoteService.class));
                break;
            default:
                break;
        }
    }
}
