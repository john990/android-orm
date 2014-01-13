package com.android.orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kai.wang on 1/13/14.
 */
public class DbHelper extends SQLiteOpenHelper{

	private static int DB_VERSION = 1;

	private static String DATABASE_PATH = null;
	private static String DATABASE_FILENAME = null;

	public DbHelper(Context context) {
		super(context, DATABASE_PATH + DATABASE_FILENAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String testSql = "create table test ( id integer,name varchar)";

		String testData1 = "insert into test values (1,'abc1')";
		String testData2 = "insert into test values (2,'abc2')";

		db.execSQL(testSql);
		db.execSQL(testData1);
		db.execSQL(testData2);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	/**
	 * 设置数据库版本
	 * @param version
	 */
	public static void setDbVersion(int version){
		DbHelper.DB_VERSION = version;
	}

	/**
	 * 设置数据库路径
	 * @param path
	 */
	public static void setDatabasePath(String path) {
		DbHelper.DATABASE_PATH = path;
	}

	/**
	 * 设置数据库名
	 * @param filename
	 */
	public static void setDatabaseFilename(String filename) {
		DbHelper.DATABASE_FILENAME = filename;
	}
}
