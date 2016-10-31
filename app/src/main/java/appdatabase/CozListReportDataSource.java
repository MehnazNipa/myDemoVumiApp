package appdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import appmodel.CozListReportModel;
import appmodel.Information;

public class CozListReportDataSource {

    public String currentDate = "";

    private AppDatabaseHelper mDbHelper;
    private SQLiteDatabase mDatabase;

    Cursor mCursor;
    List<CozListReportModel> mCozList = new ArrayList<CozListReportModel>();


    public CozListReportDataSource(Context context) {

        mDbHelper = new AppDatabaseHelper(context);

    }

    /*
    * open a method for writable database
    */
    public void open() throws SQLException {

        mDatabase = mDbHelper.getWritableDatabase();

    }



    /*
     * close database connection
     */
    public void close() {

        mDbHelper.close();

    }


    public void cDate() {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date date = new Date();

        currentDate = dateFormat.format(date);

    }



			/*
			 * insert data into the database.
			 */

    public boolean insert(CozListReportModel eInsertObj) {


        this.open();

        ContentValues cv = new ContentValues();

        cv.put(AppDatabaseHelper.COLUMN_CASE_NO, eInsertObj.getCaseNo());
        cv.put(AppDatabaseHelper.COLUMN_DATE_OF_FILLING, eInsertObj.getDateOfFiling());
        cv.put(AppDatabaseHelper.COLUMN_NEXT_SET_DATE, eInsertObj.getNextSetDate());
        cv.put(AppDatabaseHelper.COLUMN_CURRENT_CASE_STATUS, eInsertObj.getCurrentCaseStatus());
        cv.put(AppDatabaseHelper.COLUMN_CASE_TYPE, eInsertObj.getCaseType());
        cv.put(AppDatabaseHelper.COLUMN_CASE_CLASS, eInsertObj.getCaseClass());
        cv.put(AppDatabaseHelper.COLUMN_COURT_NAME, eInsertObj.getCourtName());
        cv.put(AppDatabaseHelper.COLUMN_BRANCH_NO, eInsertObj.getBranchNo());
        cv.put(AppDatabaseHelper.COLUMN_DIVISION, eInsertObj.getDivision());


        Long check = mDatabase.insert(AppDatabaseHelper.TABLE_NAME_COZ_LIST_REPORT, null, cv);

        mDatabase.close();

        this.close();

        if (check < 0)

            return false;

        else

            return true;

    }


    public List<CozListReportModel> getCurrentDateCozList() {

        this.open();

        this.cDate();

        Cursor mCursor = mDatabase.query(

                AppDatabaseHelper.TABLE_NAME_COZ_LIST_REPORT,new String[] {

                        AppDatabaseHelper.COLUMN_CASE_ID,

                        AppDatabaseHelper.COLUMN_CASE_NO,

                        AppDatabaseHelper.COLUMN_DATE_OF_FILLING,

                        AppDatabaseHelper.COLUMN_NEXT_SET_DATE,

                        AppDatabaseHelper.COLUMN_CURRENT_CASE_STATUS,

                        AppDatabaseHelper.COLUMN_CASE_TYPE,

                        AppDatabaseHelper.COLUMN_CASE_CLASS,

                        AppDatabaseHelper.COLUMN_COURT_NAME,

                        AppDatabaseHelper.COLUMN_BRANCH_NO,

                        AppDatabaseHelper.COLUMN_DIVISION},

                AppDatabaseHelper.COLUMN_DATE_OF_FILLING

                        + " = '" + currentDate + "'", null, null, null, null);


        if (mCursor != null) {

            if (mCursor.moveToFirst()) {

                do {

                    int caseId = mCursor.getInt(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_ID));

                    String caseNo = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_NO));

                    String dateOfFiling = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_DATE_OF_FILLING));

                    String nextSetDate = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_NEXT_SET_DATE));

                    String currentCaseStatus = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CURRENT_CASE_STATUS));

                    String caseType = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_TYPE));

                    String caseClass = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_CLASS));

                    String courtName = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_CLASS));

                    String branchNo = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_BRANCH_NO));

                    String division = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_DIVISION));


                    mCozList.add(new CozListReportModel(caseId, caseNo,dateOfFiling, nextSetDate, currentCaseStatus, caseType, caseClass, courtName, branchNo, division));

                } while (mCursor.moveToNext());

            }

            mCursor.close();

        }

        this.close();

        return mCozList;

    }


    public List<CozListReportModel> getDateRangeCozList(String eFromDate, String eToDate) {

        this.open();

        this.cDate();

        Cursor mCursor = mDatabase.query(

                AppDatabaseHelper.TABLE_NAME_COZ_LIST_REPORT,new String[] {

                        AppDatabaseHelper.COLUMN_CASE_ID,

                        AppDatabaseHelper.COLUMN_CASE_NO,

                        AppDatabaseHelper.COLUMN_DATE_OF_FILLING,

                        AppDatabaseHelper.COLUMN_NEXT_SET_DATE,

                        AppDatabaseHelper.COLUMN_CURRENT_CASE_STATUS,

                        AppDatabaseHelper.COLUMN_CASE_TYPE,

                        AppDatabaseHelper.COLUMN_CASE_CLASS,

                        AppDatabaseHelper.COLUMN_COURT_NAME,

                        AppDatabaseHelper.COLUMN_BRANCH_NO,

                        AppDatabaseHelper.COLUMN_DIVISION},

                AppDatabaseHelper.COLUMN_DATE_OF_FILLING

                        + " >= '" + eFromDate + "' AND " +   AppDatabaseHelper.COLUMN_DATE_OF_FILLING

                        + " <= '" + eToDate + "'", null, null, null, null);


        if (mCursor != null) {

            if (mCursor.moveToFirst()) {

                do {

                    int caseId = mCursor.getInt(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_ID));

                    String caseNo = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_NO));

                    String dateOfFiling = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_DATE_OF_FILLING));

                    String nextSetDate = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_NEXT_SET_DATE));

                    String currentCaseStatus = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CURRENT_CASE_STATUS));

                    String caseType = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_TYPE));

                    String caseClass = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_CLASS));

                    String courtName = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_CLASS));

                    String branchNo = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_BRANCH_NO));

                    String division = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_DIVISION));


                    mCozList.add(new CozListReportModel(caseId, caseNo,dateOfFiling, nextSetDate, currentCaseStatus, caseType, caseClass, courtName, branchNo, division));

                } while (mCursor.moveToNext());

            }

            mCursor.close();

        }

        this.close();

        return mCozList;

    }


    public List<CozListReportModel> getCozList() {

        this.open();

        mCursor = mDatabase.query(

                AppDatabaseHelper.TABLE_NAME_COZ_LIST_REPORT, new String[] {

                        AppDatabaseHelper.COLUMN_CASE_ID,

                        AppDatabaseHelper.COLUMN_CASE_NO,

                        AppDatabaseHelper.COLUMN_DATE_OF_FILLING,

                        AppDatabaseHelper.COLUMN_NEXT_SET_DATE,

                        AppDatabaseHelper.COLUMN_CURRENT_CASE_STATUS,

                        AppDatabaseHelper.COLUMN_CASE_TYPE,

                        AppDatabaseHelper.COLUMN_CASE_CLASS,

                        AppDatabaseHelper.COLUMN_COURT_NAME,

                        AppDatabaseHelper.COLUMN_BRANCH_NO,

                        AppDatabaseHelper.COLUMN_DIVISION},

                null, null, null, null, null);


        if (mCursor != null) {

            if (mCursor.moveToFirst()) {

                do {

                    int caseId = mCursor.getInt(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_ID));

                    String caseNo = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_NO));

                    String dateOfFiling = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_DATE_OF_FILLING));

                    String nextSetDate = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_NEXT_SET_DATE));

                    String currentCaseStatus = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CURRENT_CASE_STATUS));

                    String caseType = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_TYPE));

                    String caseClass = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_CLASS));

                    String courtName = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_CASE_CLASS));

                    String branchNo = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_BRANCH_NO));

                    String division = mCursor.getString(mCursor.getColumnIndex(AppDatabaseHelper.COLUMN_DIVISION));


                    mCozList.add(new CozListReportModel(caseId, caseNo,dateOfFiling, nextSetDate, currentCaseStatus, caseType, caseClass, courtName, branchNo, division));

                } while (mCursor.moveToNext());

            }

            mCursor.close();

        }

        this.close();

        return mCozList;

    }

    public boolean isEmpty() {

        this.open();

        mCursor = mDatabase.query(
                AppDatabaseHelper.TABLE_NAME_COZ_LIST_REPORT, new String[] {
                        AppDatabaseHelper.COLUMN_CASE_ID,

                        AppDatabaseHelper.COLUMN_CASE_NO,

                        AppDatabaseHelper.COLUMN_DATE_OF_FILLING,

                        AppDatabaseHelper.COLUMN_NEXT_SET_DATE,

                        AppDatabaseHelper.COLUMN_CURRENT_CASE_STATUS,

                        AppDatabaseHelper.COLUMN_CASE_TYPE,

                        AppDatabaseHelper.COLUMN_CASE_CLASS,

                        AppDatabaseHelper.COLUMN_COURT_NAME,

                        AppDatabaseHelper.COLUMN_BRANCH_NO,

                        AppDatabaseHelper.COLUMN_DIVISION},
                null, null, null, null, null);
        int count = -1;
        if (mCursor != null && mCursor.moveToFirst()) {
            count = mCursor.getInt(0);
            if (count > 0) {
                return false;
            }
            else {
                return true;
            }
        }
        return true;
    }

}



