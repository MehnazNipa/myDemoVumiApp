package appadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mirmhrakib.mydemoapplication.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import appmodel.CozListReportModel;
import appmodel.Information;

public class CozListReportItem extends ArrayAdapter<CozListReportModel> {

    List<CozListReportModel> cozListReportModelArrayList;
    Context mContext;
    LayoutInflater inflater;

    public CozListReportItem(List<CozListReportModel> data, Context context){
        super(context, R.layout.item_coz_list_report, data);

        this.mContext = context;
        this.cozListReportModelArrayList = data;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override


    public int getCount() {


        // TODO Auto-generated method stub


        return cozListReportModelArrayList.size();


    }




    @Override


    public long getItemId(int position) {


        // TODO Auto-generated method stub


        return position;


    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_coz_list_report,null);
        }


        DateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");

        Date date = new Date();

        String currentDate = dateFormat.format(date);

        CozListReportModel cozList = cozListReportModelArrayList.get(position);
        int caseId = cozList.getCaseId();
        String caseNo = cozList.getCaseNo();
        String dateOfFiling = cozList.getDateOfFiling();
        String nextSetDate = cozList.getNextSetDate();
        String currentCaseStatus = cozList.getCurrentCaseStatus();
        String caseType = cozList.getCaseType();
        String caseClass = cozList.getCaseClass();
        String courtName = cozList.getCourtName();
        String branchNo = cozList.getBranchNo();
        String division = cozList.getDivision();

        TextView caseNoView = (TextView) convertView.findViewById(R.id.caseNO);
        TextView dateOfFilingView = (TextView) convertView.findViewById(R.id.caseDate);
        TextView nextSetDateView = (TextView) convertView.findViewById(R.id.hearingDate);
        TextView currentCaseStatusView = (TextView) convertView.findViewById(R.id.caseStatus);
        TextView caseTypeView = (TextView) convertView.findViewById(R.id.caseType);
        TextView caseClassView = (TextView) convertView.findViewById(R.id.caseClass);
        TextView courtNameView = (TextView) convertView.findViewById(R.id.courtName);
        TextView branchNoView = (TextView) convertView.findViewById(R.id.branchNo);
        TextView divisionView = (TextView) convertView.findViewById(R.id.location);


            caseNoView.setText("মামলা নং : " + caseNo);
            dateOfFilingView.setText("মামলা দায়েরের তারিখ: " + dateOfFiling);
            nextSetDateView.setText("পরবর্তী ধার্য তারিখ: " + nextSetDate);
            currentCaseStatusView.setText("মামলার বর্তমান অবস্থা: " + currentCaseStatus);
            caseTypeView.setText("মামলার প্রকৃতি: " + caseType);
            caseClassView.setText("মামলার শ্রেণি/ধরণ: " + caseClass);
            courtNameView.setText("আদালতের নাম: " + courtName);
            branchNoView.setText("শাখা নম্বর: " + branchNo);
            divisionView.setText("বিভাগ: " + division);


        return convertView;
    }
}
