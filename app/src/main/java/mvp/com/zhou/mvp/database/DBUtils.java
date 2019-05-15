package mvp.com.zhou.mvp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import mvp.com.zhou.mvp.ui.bean.weibo.JVBean;

public class DBUtils {
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private static final String TABLE_NAME = "peopleInfo";

    public DBUtils(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    /**
     * 添加数据
     */
    /*
    例如
     dbUtils.addData(new String[]{"name", "phoneNumber", "wxNumber", "wbName", "money"}
                    , new String[]{"b3", "手机号", "微信号", "啊啊啊", "300"});
     */
    public void addData(String[] key, String[] values) {
        ContentValues contentValues = new ContentValues();
        for (int i = 0; i < key.length; i++) {
            contentValues.put(key[i], values[i]);
        }
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();
    }

    /**
     * 删除数据
     */
    //例如 ： dbUtils.delData("userName=?",new String[]{user.getName()})
    public int delData(String where, String[] values) {
        int del_data;

        del_data = db.delete(TABLE_NAME, where, values);
        return del_data;
    }

    /**
     * 修改数据
     */
    public void update(String set, String where, String[] values) {
        db.execSQL("update " + TABLE_NAME + " set " + set + " where " + where, values);
    }

    /**
     * 查询数据
     */
    public List<JVBean> queryData() {
        List<JVBean> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select name,phoneNumber,wxNumber,money,wbName" +
                " from " + TABLE_NAME, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String phoneNumber = cursor.getString(1);
            String wxNumber = cursor.getString(2);
            String money = cursor.getString(3);
            String wbName = cursor.getString(4);
            JVBean user = new JVBean();
            user.setName(name);
            user.setPhoneNumber(phoneNumber);
            user.setWxNumber(wxNumber);
            user.setMoney(money);
            user.setWBName(wbName);
            list.add(user);
        }

        return list;
    }

    /**
     * 关闭数据库连接
     */
    public void setClose() {
        if (db != null) {
            db.close();
        }
    }


}
