package com.example.namebattler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CustomOpenHelper extends SQLiteOpenHelper {

    // データベースの名前
    static final private String DBName = "NameBattler";
    private static final String TABLE_NAME = "CHARACTERS";
    private static final String _ID = "_id";
    private static final String COLUMN_NAME_TITLE1 = "NAME";
    private static final String COLUMN_NAME_TITLE2 = "JOB";
    private static final String COLUMN_NAME_TITLE3 = "HP";
    private static final String COLUMN_NAME_TITLE4 = "MP";
    private static final String COLUMN_NAME_TITLE5 = "STR";
    private static final String COLUMN_NAME_TITLE6 = "DEF";
    private static final String COLUMN_NAME_TITLE7 = "AGI";
    private static final String COLUMN_NAME_TITLE8 = "LUCK";
    private static final String COLUMN_NAME_TITLE9 = "CREATE_AT";

    // データベースのバージョン(2,3と挙げていくとonUpgradeメソッドが実行される)
    static final private int VERSION = 1;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_TITLE1 + " TEXT," +
                    COLUMN_NAME_TITLE2 + " INTEGER," +
                    COLUMN_NAME_TITLE3 + " INTEGER," +
                    COLUMN_NAME_TITLE4 + " INTEGER," +
                    COLUMN_NAME_TITLE5 + " INTEGER," +
                    COLUMN_NAME_TITLE6 + " INTEGER," +
                    COLUMN_NAME_TITLE7 + " INTEGER," +
                    COLUMN_NAME_TITLE8 + " INTEGER," +
                    COLUMN_NAME_TITLE9 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    // コンストラクタ　以下のように呼ぶこと
    public CustomOpenHelper(Context context){
        super(context, DBName, null, VERSION);
    }

    // データベースが作成された時に実行される処理
    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブル作成
        db.execSQL(
                SQL_CREATE_ENTRIES
        );
    }

    // データベースをバージョンアップした時に実行される処理
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // アップデートの判別、古いバージョンは削除して新規作成
        db.execSQL(
                SQL_DELETE_ENTRIES
        );
        onCreate(db);
    }

    // データベースが開かれた時に実行される処理
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
