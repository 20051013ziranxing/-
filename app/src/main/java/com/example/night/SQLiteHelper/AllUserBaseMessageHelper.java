package com.example.night.SQLiteHelper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AllUserBaseMessageHelper extends SQLiteOpenHelper {
    static String TAG = "nightText";
    String error = "这个电话号码并没有注册过，你可以注册一个哦！";
    /*static String name = "AllUserBaseMessage";*/
    //数据库所存放的是用户的名字、电话、密码、头像
    public static final String CREATE_ALLUSERBaseMESSAGE = "create table allUserBaseMessage ("
            + "id integer primary key autoincrement, "
            + "userName text, "
            + "userNumber text UNIQUE, "
            + "userPassword text, "
            + "userAvatar text )";
    private Context mcontext;

    public AllUserBaseMessageHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, 1);
        mcontext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ALLUSERBaseMESSAGE);
        Toast.makeText(mcontext, "成功创建用户信息表", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists allUserBaseMessage");
        onCreate(db);
    }

    public boolean insertUser(String userName, String userNumber, String userPassword, String userAvatar) {
        queryAllUser();
        Log.d(TAG, "我进行了添加");
        SQLiteDatabase db;
        try {
            db = getWritableDatabase();
            Log.d(TAG, "我进行了添加1");
            ContentValues contentValues = new ContentValues();
            Log.d(TAG, "我进行了添加2");
            contentValues.put("userName", userName);
            contentValues.put("userNumber", userNumber);
            contentValues.put("userPassword", userPassword);
            contentValues.put("userAvatar", userAvatar);
            long result = db.insert("allUserBaseMessage", null, contentValues);
            if (result != -1) {
                Log.d(TAG, "我添加成功了");
            } else {
                Log.d(TAG, "我添加失败了");
            }
            queryAllUser();
            return result != -1;
        } catch (SQLiteException e) {
            Log.e(TAG, String.valueOf(e)+"我添加失败了");
        }
        return false;
    }

    public boolean deleteUser(String userNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("allUserBaseMessage", "userNumber = ?", new String[]{userNumber});
        queryAllUser();
        return true;
    }

    public void queryAllUser() {
        Log.d(TAG, "我要开始查询所有的用户信息了");
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d(TAG, "我查询到所有的用户信息了");
        Cursor cursor = db.query("allUserBaseMessage", null, null, null,
                null, null, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String userName = cursor.getString(cursor.getColumnIndex("userName"));
                @SuppressLint("Range") String userNumber = cursor.getString(cursor.getColumnIndex("userNumber"));
                @SuppressLint("Range") String userPassword = cursor.getString(cursor.getColumnIndex("userPassword"));
                @SuppressLint("Range") String userAvatar = cursor.getString(cursor.getColumnIndex("userAvatar"));
                Log.d(TAG, "userName:" + userName + ";userNumber:" + userNumber + ";userPassword:" + userPassword + ";userAvatar:" + userAvatar);
            } while (cursor.moveToNext());
        }
    }

    @SuppressLint("Range")
    public String queryUser(String userNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("allUserBaseMessage", null, "userNumber = ?", new String[]{userNumber}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex("userPassword"));
        } else {
            return error;
        }
    }
}
