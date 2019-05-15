package mvp.com.zhou.mvp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


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
        String InfoSQL = "CREATE TABLE peopleInfo(id varchar(10) primary key , " +
                "name test ," +
                "phoneNumber test ," +
                "wxNumber test ," +
                "wbName test," +
                "money test)";
        db.execSQL(InfoSQL);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
