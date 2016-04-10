package com.example.linhdq.homework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LinhDQ on 4/10/2016.
 */
public class CustomView extends BaseAdapter {
    private ArrayList<Employee> employeeList;
    private Context context;
    private TextView txtName, txtAge, txtBirthplace;
    private static LayoutInflater inflater=null;
    public CustomView(ViewActivity viewActivity, ArrayList<Employee> employeesList) {
        // TODO Auto-generated constructor stub
        this.employeeList=employeesList;
        this.context=viewActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = inflater.inflate(R.layout.activity_custom_listvew, null);
        txtName=(TextView) rowView.findViewById(R.id.txtName);
        txtAge=(TextView) rowView.findViewById(R.id.txtAge);
        txtBirthplace=(TextView) rowView.findViewById(R.id.txtBirthPlace);
        txtName.setText(employeeList.get(position).getName());
        txtAge.setText(employeeList.get(position).getAge());
        txtBirthplace.setText(employeeList.get(position).getBirthPlace());
        return rowView;
    }
}
