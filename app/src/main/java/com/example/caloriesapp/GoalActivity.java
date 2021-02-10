package com.example.caloriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.microedition.khronos.egl.EGLDisplay;

public class GoalActivity extends AppCompatActivity {

    private ProgressBar simpleProgressBar;
    public final static String EXTRA_MESSAGE = "MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);
        simpleProgressBar = (ProgressBar) findViewById(R.id.progressBar2);

    }

    public void onBtnSetClick(View view) {
        Intent intent = getIntent();
        String message = intent.getStringExtra(CaloriesCount.EXTRA_MESSAGE);
        double suma1 = Double.parseDouble(message);
        simpleProgressBar.setMax((int) suma1);


        double suma = 0;


        for (int i = 0; i < CaloriesCount.kalorie.size(); i++)
            suma += CaloriesCount.kalorie.get(i);

        double wynik = suma1 - suma;

        double procent = suma / suma1 * 100;

        TextView textView = (TextView) findViewById(R.id.textLeft);
        TextView textView1 = (TextView) findViewById(R.id.textProcent);
        simpleProgressBar.setProgress((int) suma);
        NumberFormat f = new DecimalFormat("0");
        textView.setText("Left: " + f.format(wynik) + " calories");

        if (suma < suma1) {
            textView1.setText("Progres:  " +f.format(procent) + "%");
        } else if (suma == suma1) {
            textView1.setText("You have achieved your goal");
        } else if (suma > suma1) {
            textView1.setText("You exceeded your goal!");
            textView1.setTextColor(Color.RED);
            textView.setText("+ " +Math.abs(Integer.parseInt(f.format(wynik))) + " calories ");
            textView.setTextColor(Color.RED);
        }
    }
}