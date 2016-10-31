package com.example.mirmhrakib.mydemoapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import appadapter.CozListReportItem;
import appadapter.InformationItem;
import appmodel.CozListReportModel;
import appmodel.Information;


public class CozListReportActivity2 extends AppCompatActivity {

    ArrayList<CozListReportModel> cozReportArrayList;
    ListView mCozList = null;
    CozListReportItem mCozListReportItem = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coz_list_report1);

        cozReportArrayList = new ArrayList<CozListReportModel>();
        mCozList = (ListView) findViewById(R.id.informationList);

        String [] caseNo = new String[]{"৪-১৮/২০১৫ রিভিশন, চট্টগ্রাম","৩-১১৬/২০১৫-নামজারী-আপীল-নারায়ণগঞ্জ","৩-১৩৯/২০১৫-নামজারী-আপীল-ঢাকা","৪-৪৬/২০১৬-নামজারী-আপীল-বাগেরহাট","৩-২০/২০১৬-নামজারী-আপীল-নারায়ণগঞ্জ","৩-৭৬/১৫ (নাম) আপীল, নারায়ণগঞ্জ","৩-১১২/২০১৫-নামজারী-আপীল-গাজীপুর","৩-৩৮/২০১৬-রেকর্ড সংশোধন-বিবিধ-ঢাকা","৩-১৪৪/২০১৫-নামজারী-আপীল-নারায়ণগঞ্জ","৪-০৯/২০১৪ আপীল,কক্সাবাজার"};
        String [] dateOfFiling = new String[]{"18/02/2015","01/07/2015","26/08/2015","12/04/2016","19/04/2016","09/04/2015","25/06/2015","26/10/2016","26/10/2016","26/10/2016"};
        String [] nextSetDate = new String[]{"25/10/2016","25/10/2016","25/10/2016","25/10/2016","25/10/2016","25/10/2016","25/10/2016","25/12/2016","08/01/2017","03/03/2017"};
        String [] currentCaseStatus = new String[]{"নথির জন্য","নথির জন্য","নথির জন্য","নথির জন্য","নথির জন্য","শুনানীর জন্য","শুনানীর জন্য","শুনানীর জন্য","শুনানীর জন্য","শুনানীর জন্য"};
        String [] caseType = new String[]{"নামজারী","নামজারী","নামজারী","নামজারী","নামজারী","নামজারী","নামজারী","রেকর্ড সংশোধন","নামজারী","নামজারী"};
        String [] caseClass = new String[]{"রিভিশন","আপীল","আপীল","আপীল","আপীল","আপীল","আপীল","বিবিধ","আপীল","আপীল"};
        String [] courtName = new String[]{"সদস্য-১ মহোদয়","চেয়ারম্যান","চেয়ারম্যান","সদস্য-১ মহোদয়","চেয়ারম্যান","চেয়ারম্যান","চেয়ারম্যান","চেয়ারম্যান","চেয়ারম্যান","সদস্য-১ মহোদয়"};
        String [] branchNo = new String[]{"৪","৩","৩","৪","৩","৩","৩","৩","৩","৪"};
        String [] division = new String[]{"চট্টগ্রাম","ঢাকা","খুলনা","ঢাকা","ঢাকা","ঢাকা","ঢাকা","ঢাকা","ঢাকা","চট্টগ্রাম"};


        for (int i = 0; i<caseNo.length; i++){
            String caseNoString = caseNo[i];
            String dateOfFilingString = dateOfFiling[i];
            String nextSetDateString = nextSetDate[i];
            String currentCaseStatusString = currentCaseStatus[i];
            String caseTypeString = caseType[i];
            String caseClassString = caseClass[i];
            String courtNameString = courtName[i];
            String branchNoString = branchNo[i];
            String divisionString = division[i];

            cozReportArrayList.add(new CozListReportModel(caseNoString,dateOfFilingString,nextSetDateString,currentCaseStatusString,caseTypeString,caseClassString,courtNameString,branchNoString,divisionString));
        }

        mCozListReportItem = new CozListReportItem(cozReportArrayList,this);
        mCozList.setAdapter(mCozListReportItem);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info_list, menu);
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
}
