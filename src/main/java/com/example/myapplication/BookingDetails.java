package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookingDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name,nationlality,address,number,bike,visit_date,end_date,price_per_day,total_price;
    private Button delete;
    TextView output;
    MyDBHelper db=new MyDBHelper(BookingDetails.this, "BikesDB", null, 1);

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        setTitle("Booking Details");
        MyDBHelper db = new MyDBHelper(BookingDetails.this, "BikesDB", null, 1);
//        button= (Button)findViewById(R.id.Update);
        name= new ArrayList<>();
        nationlality= new ArrayList<>();
        address= new ArrayList<>();
        number= new ArrayList<>();
        bike= new ArrayList<>();
        visit_date= new ArrayList<>();
        end_date= new ArrayList<>();
        price_per_day= new ArrayList<>();
        total_price= new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this,name,nationlality,address,number,bike,visit_date,end_date,price_per_day,total_price);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
//        delete = findViewById(R.id.delete);
//           delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int deletedRows =db.deleteBook(name.get(0));
//                if (deletedRows > 0) {
//                    Toast.makeText(BookingDetails.this,"Deleted the record", Toast.LENGTH_SHORT).show();
//                    Intent i = new Intent(BookingDetails.this, MainActivity.class);
//                    startActivity(i);
//                } else {
//                    Toast.makeText(BookingDetails.this,"Error deleting record", Toast.LENGTH_SHORT).show();
//                }
//            }
//       });
    }

    private void displaydata(){
        Cursor cursor= db.getAllRecords();
        if(cursor.getCount()==0){
            Toast.makeText(BookingDetails.this,"No Data Found",Toast.LENGTH_SHORT).show();
            return;

        }
        else {
            while(cursor.moveToNext())
            {
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