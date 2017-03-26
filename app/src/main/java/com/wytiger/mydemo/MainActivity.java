package com.wytiger.mydemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wytiger.mydemo.test.permission.CheckPermissionActivity;
import com.wytiger.mydemo.test.screen.ScreenActivity;
import com.wytiger.mydemo.test.screen.SystemUIActivity;
import com.wytiger.mydemo.test.screen.WindowDemoActivity;
import com.wytiger.mydemo.test.zoom.SurfaceZoomActivity;
import com.wytiger.mydemo.test.zoom.ZoomActivity;
import com.wytiger.mydemo.utils.RawDbUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends Activity implements OnClickListener {
    private static String TAG = "MyDemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        testPicasso();


        SQLiteDatabase db = RawDbUtil.openDatabase(this,R.raw.mytest);
       query(db);
    }

    private void query(SQLiteDatabase db) {
        Cursor cursor = db.query("student", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Log.i("TAG", cursor.getString(cursor.getColumnIndex("name")));
        }
    }


    private void copyRawToInternalStorage(int rawResId, String dbPath) {
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            File dbFile = new File(dbPath, "mytest.db");
            if (!dbFile.exists()) {
               boolean mkdirs =  dbFile.mkdirs();
                Log.i("TAG", "mkdirs = " + mkdirs);
            }
            is = this.getResources().openRawResource(rawResId); // 你Raw的那个db索引
            fos = new FileOutputStream(dbPath);
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = is.read(buffer)) > 0) {
                fos.write(buffer, 0, count);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TAG", "数据库复制失败");
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void initView() {
        findViewById(R.id.btnGrayUnckickable).setOnClickListener(this);
        findViewById(R.id.btnWindow).setOnClickListener(this);
        findViewById(R.id.btnSurfaceZoom).setOnClickListener(this);
        findViewById(R.id.btnZoom).setOnClickListener(this);
        findViewById(R.id.btnCheckPermission).setOnClickListener(this);
        findViewById(R.id.btnSystemUI).setOnClickListener(this);
        findViewById(R.id.btnScreen).setOnClickListener(this);
    }

    private void testPicasso() {
        Picasso.with(this)
                .load("http://imgstore.cdn.sogou.com/app/a/100540002/467502.jpg")
                .placeholder(R.drawable.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into((ImageView) findViewById(R.id.ivImage));
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
