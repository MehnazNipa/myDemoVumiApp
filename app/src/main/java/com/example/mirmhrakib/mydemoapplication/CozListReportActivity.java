package com.example.mirmhrakib.mydemoapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import appadapter.CozListReportItem;
import appdatabase.CozListReportDataSource;
import appmodel.CozListReportModel;


public class CozListReportActivity extends AppCompatActivity {

    List<CozListReportModel> cozReportArrayList;
    ListView mCozList = null;
    CozListReportItem mCozListItem = null;
    CozListReportDataSource mCozListReportDataSource;
    CozListReportModel mCozListReportModel;
    static EditText fromDateET;
    static EditText toDateET;
    String fromDate = "";
    String toDate = "";

    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coz_list_report);

        fromDateET = (EditText) findViewById(R.id.fromDate);
        toDateET = (EditText) findViewById(R.id.toDate);
        cozReportArrayList = new ArrayList<CozListReportModel>();
        mCozList = (ListView) findViewById(R.id.cozList);
        mCozListReportDataSource = new CozListReportDataSource(this);
        mCozListReportModel = new CozListReportModel();

        String [] caseNo = new String[]{"৪-১৮/২০১৫ রিভিশন, চট্টগ্রাম","৩-১১৬/২০১৫-নামজারী-আপীল-নারায়ণগঞ্জ","৩-১৩৯/২০১৫-নামজারী-আপীল-ঢাকা","৪-৪৬/২০১৬-নামজারী-আপীল-বাগেরহাট","৩-২০/২০১৬-নামজারী-আপীল-নারায়ণগঞ্জ","৩-৭৬/১৫ (নাম) আপীল, নারায়ণগঞ্জ","৩-১১২/২০১৫-নামজারী-আপীল-গাজীপুর","৩-৩৮/২০১৬-রেকর্ড সংশোধন-বিবিধ-ঢাকা","৩-১৪৪/২০১৫-নামজারী-আপীল-নারায়ণগঞ্জ","৪-০৯/২০১৪ আপীল,কক্সাবাজার"};
        String [] dateOfFiling = new String[]{"18/02/2015","01/07/2015","26/08/2015","12/04/2016","19/04/2016","09/04/2015","25/06/2015","25/10/2016","31/10/2016","31/10/2016"};
        String [] nextSetDate = new String[]{"25/10/2016","25/10/2016","25/10/2016","25/10/2016","25/10/2016","25/10/2016","25/10/2016","25/12/2016","08/01/2017","03/03/2017"};
        String [] currentCaseStatus = new String[]{"নথির জন্য","নথির জন্য","নথির জন্য","নথির জন্য","নথির জন্য","শুনানীর জন্য","শুনানীর জন্য","শুনানীর জন্য","শুনানীর জন্য","শুনানীর জন্য"};
        String [] caseType = new String[]{"নামজারী","নামজারী","নামজারী","নামজারী","নামজারী","নামজারী","নামজারী","রেকর্ড সংশোধন","নামজারী","নামজারী"};
        String [] caseClass = new String[]{"রিভিশন","আপীল","আপীল","আপীল","আপীল","আপীল","আপীল","বিবিধ","আপীল","আপীল"};
        String [] courtName = new String[]{"সদস্য-১ মহোদয়","চেয়ারম্যান","চেয়ারম্যান","সদস্য-১ মহোদয়","চেয়ারম্যান","চেয়ারম্যান","চেয়ারম্যান","চেয়ারম্যান","চেয়ারম্যান","সদস্য-১ মহোদয়"};
        String [] branchNo = new String[]{"৪","৩","৩","৪","৩","৩","৩","৩","৩","৪"};
        String [] division = new String[]{"চট্টগ্রাম","ঢাকা","খুলনা","ঢাকা","ঢাকা","ঢাকা","ঢাকা","ঢাকা","ঢাকা","চট্টগ্রাম"};


        if (mCozListReportDataSource.isEmpty() == true) {

            for (int i = 0; i < caseNo.length; i++) {
                String caseNoString = caseNo[i];
                String dateOfFilingString = dateOfFiling[i];
                String nextSetDateString = nextSetDate[i];
                String currentCaseStatusString = currentCaseStatus[i];
                String caseTypeString = caseType[i];
                String caseClassString = caseClass[i];
                String courtNameString = courtName[i];
                String branchNoString = branchNo[i];
                String divisionString = division[i];

                mCozListReportModel = new CozListReportModel(caseNoString, dateOfFilingString, nextSetDateString, currentCaseStatusString, caseTypeString, caseClassString, courtNameString, branchNoString, divisionString);

                if (mCozListReportDataSource.insert(mCozListReportModel)) {

                    Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Data Not Saved.", Toast.LENGTH_SHORT).show();

                }
            }
        }


        cozReportArrayList = mCozListReportDataSource.getCurrentDateCozList();
        //cozReportArrayList = mCozListReportDataSource.getCozList();
        mCozListItem = new CozListReportItem(cozReportArrayList,this);
        mCozList.setAdapter(mCozListItem);


        fromDateET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment1();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });

        toDateET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment2();
                newFragment.show(getFragmentManager(), "datePicker");
            }
        });

    }

    public void searchCozlist(View v){
        cozReportArrayList.clear();

       cozReportArrayList = new ArrayList<CozListReportModel>();

        Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show();

        fromDate = fromDateET.getText().toString();
        toDate = toDateET.getText().toString();
        cozReportArrayList = mCozListReportDataSource.getDateRangeCozList(fromDate,toDate);

        //cozReportArrayList = mCozListReportDataSource.getCozList();
        mCozListItem = new CozListReportItem(cozReportArrayList,this);
        mCozList.setAdapter(mCozListItem);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coz_list_report, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class DatePickerFragment1 extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {



        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user

            String newDay ="";
            String newMonth ="";
            String newDate ="";

            if(day<10){
                newDay = '0'+String.valueOf(day);
            }else {
                newDay = String.valueOf(day);
            }

            if(month<9){
                newMonth = '0'+ String.valueOf(month + 1);
            }else {
                newMonth = String.valueOf(month + 1);
            }

            newDate = newDay+ " / " + newMonth+ " / " + String.valueOf(year);
            fromDateET.setText(newDate);
        }
    }

    public static class DatePickerFragment2 extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {



        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user

            String newDay ="";
            String newMonth ="";
            String newDate ="";

            if(day<10){
                newDay = '0'+String.valueOf(day);
            }else {
                newDay = String.valueOf(day);
            }

            if(month<9){
                newMonth = '0'+ String.valueOf(month + 1);
            }else {
                newMonth = String.valueOf(month + 1);
            }

            newDate = newDay+ " / " + newMonth+ " / " + String.valueOf(year);
            toDateET.setText(newDate);
        }
    }

}








