package com.example.caloriesapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.widget.Toast;
public class CaloriesCount extends AppCompatActivity {
    public final static ArrayList<Double> sugar= new ArrayList<>();
    public final static ArrayList<String> names=new ArrayList<>();
    public final static ArrayList<Double> kalorie=new ArrayList<>();
    public final static ArrayList<Double> fiber=new ArrayList<>();
    public final static ArrayList<Double> cholesterol=new ArrayList<>();
    public final static ArrayList<String> times=new ArrayList<>();
    public final static String EXTRA_MESSAGE = "MESSAGE";
    public final static String MESSAGE="You ate it";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_count);


    }

    public void onListViewClick(View view) {
        final EditText editText = (EditText) findViewById(R.id.editProduct);
        String dane = editText.getText().toString();
        if (dane.equals(""))
            Toast.makeText(getApplicationContext(), "EMPTY EDIT TEXT", Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent(this, ListActivity.class);
            this.startActivity(intent);
        }
    }

    public void onStatsClick(View view) {
        Intent intent1 = getIntent();
        String message = intent1.getStringExtra(MainActivity.EXTRA_MESSAGE);


        Intent intent = new Intent(this, GoalActivity.class);
       intent.putExtra(EXTRA_MESSAGE, message);
        this.startActivity(intent);

    }

    public void onAddProduct(View view) {
        final EditText editText = (EditText) findViewById(R.id.editProduct);
        String dane = editText.getText().toString();

        // nie wiem jak pobrać pierwszą część
        // "10oz beef"
        //xxx beef
        String[] cz1=dane.split(" ");
        double uncje=Double.parseDouble(cz1[0])*0.03;

        String name=cz1[1];



        if (dane.equals(""))
            Toast.makeText(getApplicationContext(), "EMPTY EDIT TEXT", Toast.LENGTH_SHORT).show();
        else {


            String url = "https://api.calorieninjas.com/v1/nutrition?query=" + uncje +"oz "+name;


            RequestQueue queue = Volley.newRequestQueue(this);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();


            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onResponse(String response) {


                    Map p = gson.fromJson(response.toString(), Map.class);
                    for (Object key : p.keySet()) ;
                    String items = p.get("items").toString();
                    FoodData[] test = gson.fromJson(items, FoodData[].class);
                    if (test.length==0){
                        Toast toast1 = Toast.makeText(getApplicationContext(), "That's a bad name", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                    else {
                        kalorie.add(test[0].getCalories());
                        sugar.add(test[0].getSugar_g());
                        names.add(test[0].getName());
                        fiber.add(test[0].getFiber_g());
                        cholesterol.add(test[0].getCholesterol_mg());
                        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm");
                        times.add(dtf1.format(LocalTime.now()));


                        Toast toast = Toast.makeText(getApplicationContext(), MESSAGE, Toast.LENGTH_SHORT);
                        toast.show();

                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "That's a bad name", Toast.LENGTH_SHORT);
                    toast1.show();


                }


            }

            ) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("X-Api-Key", "ElV+T4uG18TJbc0r6L1HpQ==r0T6teZhgqF7RLXx");
                    return headers;
                }
            };


            queue.add(stringRequest);


        }
    }


    public void onProductClick(View view) {
        Intent intent = new Intent(this, StatsActivity.class);
        this.startActivity(intent);
    }
}
