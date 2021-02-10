package com.example.caloriesapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class StatsActivity extends AppCompatActivity {
    public final static ArrayList<Double> sugar = new ArrayList<>();
    public final static ArrayList<String> names = new ArrayList<>();
    public final static ArrayList<Double> kalorie = new ArrayList<>();
    public final static ArrayList<Double> fiber = new ArrayList<>();
    public final static ArrayList<Double> cholesterol = new ArrayList<>();
    public final static ArrayList<String> times = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);


        ArrayList<String> statsNames = new ArrayList<>();
        ArrayList<String> statsCalories = new ArrayList<>();
        ArrayList<String> statsTime = new ArrayList<>();
        for (int i = 0; i < CaloriesCount.names.size(); i++) {
            statsNames.add(CaloriesCount.names.get(i));
            statsCalories.add(CaloriesCount.kalorie.get(i).toString());
            statsTime.add(CaloriesCount.times.get(i));
        }
        TextView textView = new TextView(this);
        textView.setText("Your product list:");
        textView.setTextSize(24);
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.BLACK);


        ListView listView = (ListView) findViewById(R.id.statView);
        MyListAdapter adapter = new MyListAdapter(this, statsNames, statsCalories, statsTime);
        listView.setAdapter(adapter);
        listView.addHeaderView(textView);

    }

}