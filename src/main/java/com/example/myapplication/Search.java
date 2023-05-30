package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name,nationlality,address,number,bike,visit_date,end_date,price_per_day,total_price;
    private Button delete;
    TextView output;
    MyDBHelper db=new MyDBHelper(Search.this, "BikesDB", null, 1);
     String d_name;
    MyAdapter3  adapter ;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent intent = getIntent();
        d_name = intent.getStringExtra("DELETE_NAME");


//         d_name = delete_name.getText().toString();


//        button= (Button)findViewById(R.id.Update);
        name = new ArrayList<>();
        nationlality = new ArrayList<>();
        address = new ArrayList<>();
        number = new ArrayList<>();
        bike = new ArrayList<>();
        visit_date = new ArrayList<>();
        end_date = new ArrayList<>();
        price_per_day = new ArrayList<>();
        total_price = new ArrayList<>();
        recyclerView = findViewById(R.id.test);
        Log.d("Search","recycle vire:"+recyclerView);
        adapter = new MyAdapter3(this, name, nationlality, address, number, bike, visit_date, end_date, price_per_day, total_price);
        if (recyclerView != null) {
            Log.d("Search","msg: recycler view ");
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            displaydata();

        }
        else{

            Log.d("Search","msg: recycler view empty");
        }


    }



    private void displaydata(){
            Cursor cursor = db.showResult(String.valueOf(d_name));
        Log.d("Search","logname:"+d_name);
            Log.d("Search","log:"+cursor.getCount());
            if (cursor.getCount() == 0) {
                Toast.makeText(Search.this, "No Data Found", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(Search.this, " Data Found", Toast.LENGTH_SHORT).show();
                while (cursor.moveToNext()) {
                    name.add(cursor.getString(1));
                    nationlality.add(cursor.getString(2));
                    address.add(cursor.getString(3));
                    number.add(cursor.getString(4));
                    bike.add(cursor.getString(5));
                    visit_date.add(cursor.getString(6));
                    end_date.add(cursor.getString(7));
                    price_per_day.add(cursor.getString(8));
                    total_price.add(cursor.getString(9));
                }
            }
        }
}