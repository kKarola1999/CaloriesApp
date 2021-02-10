package com.example.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<String> wyniki = new ArrayList<>();


        wyniki.add("Calories: " + CaloriesCount.kalorie.get(CaloriesCount.sugar.size() - 1));
        wyniki.add("Sugar: " + CaloriesCount.sugar.get(CaloriesCount.sugar.size() - 1) + " [g]");
        wyniki.add("Fiber: " + CaloriesCount.fiber.get(CaloriesCount.fiber.size() - 1) +" [g]");
        wyniki.add("Cholesterol: " + CaloriesCount.cholesterol.get(CaloriesCount.cholesterol.size() - 1) +" [mg]");


        TextView textView = new TextView(this);
        textView.setText("Information about: " + CaloriesCount.names.get(CaloriesCount.names.size() - 1));
        textView.setTextSize(24);
        textView.setGravity(Gravity.CENTER);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.BLACK);


        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, wyniki);
        listView.setAdapter(adapter);
        listView.addHeaderView(textView);

    }
}