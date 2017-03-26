package com.wytiger.mydemo.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * desc:
 * Created by wytiger at 2017/3/26 0026.
 */

public class RawDbUtil {
    private static String sdpath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/mydatabase";//sdpath用于存放保存的路径。
    private static String filename = "test.db";//filename用于保存文件名。


    public static SQLiteDatabase openDatabase(Context context, int rawId) {
        File filepath = copy(context, rawId);
        SQLiteDatabase database = SQLiteDatabase.openDatabase(filepath.getPath(), null, SQLiteDatabase.OPEN_READWRITE);//利用openDatabase方法打开数据库。
        return database;
    }

    @NonNull
    private static File copy(Context context, int rawId) {
        File dir = new File(sdpath);
        if (!dir.exists()) {
            dir.mkdir();
        }//如果该目录不存在，创建该目录
        String databasefilename = sdpath + "/" + filename;//其值等于database的路径
        File filepath = new File(databasefilename);
        if (!filepath.exists()) {//如果文件不存在
            try {
                InputStream inputStream = context.getResources().openRawResource(rawId);//将raw中的test.db放入输入流中
                FileOutputStream fileOutputStream = new FileOutputStream(databasefilename);//将新的文件放入输出流中
                byte[] buff = new byte[8192];
                int len = 0;
                while ((len = inputStream.read(buff)) > 0) {
                    fileOutputStream.write(buff, 0, len);
                }
                fileOutputStream.close();
                inputStream.close();
            } catch (Exception e) {
                Log.i("RawDbUtil", "复制数据库失败");
                e.printStackTrace();
            }
        }//写入文件结束
        Log.i("RawDbUtil", "filepath = " + filepath);
        return filepath;
    }
}
