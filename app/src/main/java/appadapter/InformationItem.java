package appadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mirmhrakib.mydemoapplication.R;

import java.util.ArrayList;

import appmodel.Information;

public class InformationItem extends ArrayAdapter<Information> {

    ArrayList<Information> informations;
    Context mContext;
    LayoutInflater inflater;

    public InformationItem(ArrayList<Information> data, Context context){
        super(context, R.layout.item_information_list, data);

        this.mContext = context;
        this.informations = data;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_information_list,null);
        }


        Information information = informations.get(position);
        String nDate = information.getmDate();
        String nSubject = information.getmSubject();
        String nTime = information.getmTime();

        TextView dateView = (TextView) convertView.findViewById(R.id.date);
        TextView subjectView = (TextView) convertView.findViewById(R.id.subject);
        TextView timeView = (TextView) convertView.findViewById(R.id.time);

        dateView.setText(nDate);
        subjectView.setText(nSubject);
        timeView.setText(nTime);

        return convertView;
    }
}
