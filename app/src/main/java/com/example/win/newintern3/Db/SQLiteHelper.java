package com.example.win.newintern3.Db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.win.newintern3.Utils.logger.Logger;

import java.util.List;



/**
 * Created by TAO_SX on 2016/4/19/019.
 */
public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "intern3.db";
    private static final int VERSION = 1;
    public static SQLiteHelper ourInstance;

    private SQLiteHelper(Context context) {
        this(context, DB_NAME, null, VERSION);
    }

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static SQLiteHelper getInstance(Context context) {
        if (ourInstance == null) ourInstance = new SQLiteHelper(context);
        return ourInstance;
    }

    public static final String TB_City = "tb_city";
    public static final String TB_FirstChar = "firstChar";
    public static final String TB_CityName = "cityName";
    public static final String TB_ParentCode = "parentCode";
    public static final String TB_CityCode = "cityCode";

    public static final String TB_SCHOOL_SQL = "CREATE TABLE IF NOT EXISTS " + TB_City + "("+
            TB_FirstChar + " INTEGER NOT NULL," +
            TB_CityName + " INTEGER NOT NULL," +
            TB_ParentCode + " INTEGER NOT NULL," +
            TB_CityCode + " Text NOT NULL)";


    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     * 首次创建数据库时调用。这就是创建表和表的初始种群。
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_City);
        db.execSQL(TB_SCHOOL_SQL);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * 数据库需要更新时调用，实现类应该使用这个方法删除表，添加表，或者做其他事情需要更新表到新模式版本
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * 如果你添加新的列你可以使用ALTER TABLE插入到现存的表里。如果你想重命名或移除列你可以使用ALTER TABLE重命名
     * 旧表，然后创建新表，接着填充新表与旧表的内容
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * 这个方法执行了一个事务。如果抛出一个异常，所有更改将自动回滚。
     * </p>
     *
     * @param db         The database. 数据库
     * @param oldVersion The old database version. 旧数据库版本
     * @param newVersion The new database version. 新数据库版本
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            Logger.d("更新数据库");
        }
    }


    /**
     * 删除城市表
     */
    public void deleteCityTable() {
        SQLiteDatabase delete = this.getWritableDatabase();
        delete.execSQL("DROP TABLE " + TB_City);
        delete.close();
    }

    /**
     * 清空城市表
     */
    public void deleteCityAll() {
        SQLiteDatabase deleteAll = this.getWritableDatabase();
        deleteAll.delete(TB_City, null, null);
        deleteAll.close();
    }

    /**
     * 添加城市
     *
     * @param table             表名
     * @param contentValuesList 值
     */
    public void insert(String table, List<ContentValues> contentValuesList) {
        if (contentValuesList != null && contentValuesList.size() > 0) {
            SQLiteDatabase db = this.getWritableDatabase();
            //使用事务提交
            db.beginTransaction();
            try {
                for (ContentValues contentValues : contentValuesList) {
                    db.replace(table, null, contentValues);
                }
                db.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                db.endTransaction();
            }

            db.close();//关闭DB
        }
    }

    /**
     * 查询数据
     *
     * @param table         表名
     * @param columns       要查询出来的列名，为 null 查询所有
     * @param selection     查询条件，允许使用占位符"?"
     * @param selectionArgs 对应于selection语句中占位符的值
     * @param groupBy       分组
     * @param having        过滤器
     * @param orderBy       排序
     * @param limit         限制查询返回的行数，
     * @return Cursor 注意使用完要关闭
     */
    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy, String limit) {
        Cursor c =this.getWritableDatabase().query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
//        DBManager.getInstance().closeDatabase();//关闭DB
        //游标必须要在关闭数据库之前关闭，不能放在后面
        return c;
    }

}
