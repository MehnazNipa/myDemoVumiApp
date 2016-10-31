package com.example.mirmhrakib.mydemoapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import appadapter.InformationItem;
import appmodel.Information;


public class CozListReportActivity1 extends AppCompatActivity {

    ArrayList<Information> informationArrayList;
    ListView mInformationList = null;
    InformationItem mInformationItem = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coz_list_report1);

        informationArrayList = new ArrayList<Information>();
        mInformationList = (ListView) findViewById(R.id.informationList);

        String [] date = new String[]{"০১/১০/২০১৬", "০৩/১০/২০১৬","০৭/১০/২০১৬","০৮/১০/২০১৬","০৯/১০/২০১৬"};
        String [] subject = new String[]{"ভূমি সংক্রান্ত আইন", "ভূমি মন্ত্রণালয়ের বাজেট","তথ্য প্রকাশ নীতিমালা","বার্ষিক উদ্ভাবন কর্মপরিকল্পনা","ভূমিহীনদের বন্দোবস্তের আবেদন"};
        String [] time = new String[]{"১২.২৫ pm", "৩.৩০ pm","৭.২৫ pm","১১.০৪ am","১.১০ pm"};


        for (int i = 0; i<date.length; i++){
            String nDate = date[i];
            String nSubject = subject[i];
            String nTime = time[i];
            informationArrayList.add(new Information(nDate, nSubject, nTime));
        }

        mInformationItem = new InformationItem(informationArrayList,this);
        mInformationList.setAdapter(mInformationItem);
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
