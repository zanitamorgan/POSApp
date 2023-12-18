package com.zanita.posapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Checkout extends AppCompatActivity {

    private ImageButton imageButton2;
    ListView listView;

    // creating  a String type array (fruitNames)
    // which contains names of different fruits' images
    String fruitNames[] = {"5:17PM | Terra Rueegger", "5:17PM | Elizabeth Rueegger"};

    // creating an Integer type array (fruitImageIds) which
    // contains IDs of different fruits' images
    int fruitImageIds[] = {R.drawable.cocktail,
            R.drawable.cocktail,
            R.drawable.cocktail,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        // Binding the ListView  of activity_main.xml file
        // with this java code in MainActivity.java
        listView = findViewById(R.id.list);
        imageButton2 = findViewById(R.id.imageButton2);


        // creating an ArrayList of HashMap.The kEY of the HashMap
        // is a String and VALUE is of any datatype(Object)
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();

        // By a for loop, entering different types of data in HashMap,
        // and adding this map including it's datas into the ArrayList
        // as list item and this list is the second parameter of the SimpleAdapter
        for (int i = 0; i < fruitNames.length; i++) {

            // creating an Object of HashMap class
            HashMap<String, Object> map = new HashMap<>();

            // Data entry in HashMap
            map.put("fruitName", fruitNames[i]);
            map.put("fruitImage", fruitImageIds[i]);

            // adding the HashMap to the ArrayList
            list.add(map);
        }

        // creating A string type array(from) which contains
        // column names for each View in each row of the list
        // and this array(form) is the fourth parameter of the SimpleAdapter
        String[] from = {"fruitName", "fruitImage"};

        // creating an integer type array(to) which contains
        // id of each View in each row of the list
        // and this array(form) is the fifth parameter of the SimpleAdapter
        int to[] = {R.id.textView, R.id.imageView};

        // creating an Object of SimpleAdapter class and
        // passing all the required parameters
        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(), list, R.layout.list_row_items, from, to);

        // now setting the simpleAdapter to the ListView
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(Checkout.this, Orders.class));
                Toast.makeText(Checkout.this, list.get(position).get("fruitName").toString() , Toast.LENGTH_SHORT).show();
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }



    private void showDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_new_order);
        dialog.show();



    }
}