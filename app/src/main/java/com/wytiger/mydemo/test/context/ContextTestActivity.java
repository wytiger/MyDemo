package com.wytiger.mydemo.test.context;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wytiger.mydemo.R;

public class ContextTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_test);

        LinearLayout activity_main = (LinearLayout) findViewById(R.id.activity_context_test);
        TextView tvText = new TextView(GlobalActivity.instance);
        tvText.setText("我的context是一个独立的activity提供的");
        activity_main.addView(tvText);

        showDialog();
    }
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("普通对话框的标题");
        builder.setMessage("这是一个普通对话框的内容");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ContextTestActivity.this, "取消", Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ContextTestActivity.this, "确定", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁
        GlobalActivity.instance.finish();
    }
}
