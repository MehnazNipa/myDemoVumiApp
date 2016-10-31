package com.example.mirmhrakib.mydemoapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goClassBaseRepo(View view){

        Intent i = new Intent(HomeActivity.this,
                ClassBaseReportActivity.class);
        startActivity(i);
    }

    public void goSituationBaseRepo(View view){

        Intent i = new Intent(HomeActivity.this,
                SituationBaseReportActivity.class);
        startActivity(i);
    }

    public void goTypeBaseRepo(View view){

        Intent i = new Intent(HomeActivity.this,
                TypeBaseReportActivity.class);
        startActivity(i);
    }

    public void goAreaBaseRepo(View view){

        Intent i = new Intent(HomeActivity.this,
                AreaBasedReportActivity.class);
        startActivity(i);
    }

    public void goCozListRepo(View view){

        Intent i = new Intent(HomeActivity.this,
                CozListReportActivity.class);
        startActivity(i);
    }

    public void goYearlyAppealRepo(View view){

        Intent i = new Intent(HomeActivity.this,
                YearlyAppealReportActivity.class);
        startActivity(i);
    }

    public void goContact(View view){

        Intent i = new Intent(HomeActivity.this,
                ContactActivity.class);
        startActivity(i);
    }

    public void goAboutUs(View view){

        Intent i = new Intent(HomeActivity.this,
                AboutUsActivity.class);
        startActivity(i);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
