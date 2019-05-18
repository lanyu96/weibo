package mvp.com.zhou.mvp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PersonInfo.db";  //数据库名
    private static final int DATABASE_VERSION = 1;               //数据库版本号


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String JinInfoSQL = "CREATE TABLE JpeopleInfo(id varchar(10) primary key , " +
                "name test ," +
                "phoneNumber test ," +
                "wxNumber test ," +
                "wbName test," +
                "fensi test," +
                "money test," +
                "JH test," +
                "wbIndex test)";
        String HuangInfoSQL = "CREATE TABLE HpeopleInfo(id varchar(10) primary key , " +
                "name test ," +
                "phoneNumber test ," +
                "wxNumber test ," +
                "wbName test," +
                "fensi test," +
                "money test," +
                "JH test," +
                "wbIndex test)";
        String XuanChuanInfoSQL = "CREATE TABLE XpeopleInfo(id varchar(10) primary key , " +
                "name test ," +
                "phoneNumber test ," +
                "wxNumber test)";
        db.execSQL(JinInfoSQL);
        db.execSQL(HuangInfoSQL);
        db.execSQL(XuanChuanInfoSQL);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
