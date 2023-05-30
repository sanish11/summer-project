package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerDetails extends AppCompatActivity {
    RecyclerView recycler;
    ArrayList<String> name,nationlality,address,number,License_no,Passport_no,bike,bike_no,visit_date,end_date,total_price;
    TextView output;
    MyDBHelper db=new MyDBHelper(CustomerDetails.this, "BikesDB", null, 1);
    MyAdapter2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Customer Details");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);
        Context context;

        name= new ArrayList<>();

        number= new ArrayList<>();
        address= new ArrayList<>();
        nationlality= new ArrayList<>();

        bike= new ArrayList<>();
        bike_no= new ArrayList<>();
        License_no= new ArrayList<>();
        Passport_no= new ArrayList<>();
        visit_date= new ArrayList<>();
        end_date= new ArrayList<>();

        total_price= new ArrayList<>();
        recycler = findViewById(R.id.recycler);
        adapter = new MyAdapter2(this,name,nationlality,address,number,bike,bike_no,visit_date,end_date,License_no,Passport_no,total_price);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }
    private void displaydata(){
        Cursor cursor= db.getData();
        if(cursor.getCount()==0){
            Toast.makeText(CustomerDetails.this,"No Data Found",Toast.LENGTH_SHORT).show();
            return;

        }
        else {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(1));
                number.add(cursor.getString(2));
                address.add(cursor.getString(3));
                nationlality.add(cursor.getString(4));
                bike.add(cursor.getString(5));
                bike_no.add(cursor.getString(6));
                visit_date.add(cursor.getString(7));
                end_date.add(cursor.getString(8));
                License_no.add(cursor.getString(9));
                Passport_no.add(cursor.getString(10));

                total_price.add(cursor.getString(11));
            }
            adapter.notifyDataSetChanged();
        }

    }
}