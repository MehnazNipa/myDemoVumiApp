package appdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AppDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG =null ;

    public final Context fContext ;


    public static final String DATABASE_NAME = "vumi_appeal.db";

    private static final int DATABASE_VERSION = 1;


    //cozlist report table constant

    public static final String TABLE_NAME_COZ_LIST_REPORT = "cozListReport";

    public static final String COLUMN_CASE_ID = "caseId";

    public static final String COLUMN_CASE_NO = "caseNo";

    public static final String COLUMN_DATE_OF_FILLING = "dateOfFiling";

    public static final String COLUMN_NEXT_SET_DATE = "nextSetDate";

    public static final String COLUMN_CURRENT_CASE_STATUS = "currentCaseStatus";

    public static final String COLUMN_CASE_TYPE = "caseType";

    public static final String COLUMN_CASE_CLASS = "caseClass";

    public static final String COLUMN_COURT_NAME = "courtName";

    public static final String COLUMN_BRANCH_NO = "branchNo";

    public static final String COLUMN_DIVISION = "division";



// create cozlist report table

    private static final String CREATE_TABLE_COZ_LIST_REPORT = "create table "

            + TABLE_NAME_COZ_LIST_REPORT + "("

            + COLUMN_CASE_ID + " integer primary key, "

            + COLUMN_CASE_NO + " text not null,"

            + COLUMN_DATE_OF_FILLING + " text not null, "

            + COLUMN_NEXT_SET_DATE + " text not null,"

            + COLUMN_CURRENT_CASE_STATUS + " text not null,"

            + COLUMN_CASE_TYPE + " text not null,"

            + COLUMN_CASE_CLASS + " text not null,"

            + COLUMN_COURT_NAME + " text not null,"

            + COLUMN_BRANCH_NO + " text not null,"

            + COLUMN_DIVISION + " text not null);";



    public AppDatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        fContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_COZ_LIST_REPORT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        Log.w(TAG, "Upgrading database from version " + oldVersion + " to "

                + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_COZ_LIST_REPORT);
    }
}
