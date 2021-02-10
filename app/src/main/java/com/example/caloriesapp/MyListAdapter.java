package com.example.caloriesapp;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> maintitle;
    private final ArrayList<String> subtitle;
    private final ArrayList<String> times;


    public MyListAdapter(Activity context, ArrayList<String> maintitle,ArrayList<String> subtitle,ArrayList<String> times) {
        super(context, R.layout.mylist, maintitle);

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        this.times=times;


    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
        TextView dateText = (TextView) rowView.findViewById(R.id.Time);

        titleText.setText(maintitle.get(position));
        subtitleText.setText(subtitle.get(position).toString());
        dateText.setText(times.get(position).toString());

        return rowView;

    };


}
