package mvp.com.zhou.mvp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String InfoSQL = "CREATE TABLE info(id varchar(10) primary key , " +
                "phoneNumber varchar(20) ," +
                "wxNumber varchar(20) ," +
                "wbName varchar(20)," +
                "money varchar(20))";
        db.execSQL(InfoSQL);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
