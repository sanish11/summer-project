package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Details extends AppCompatActivity {
    private Button button_1;
    private Button b2;
    private Button b3;
    private Button b4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle("Check Details");
        button_1= (Button)findViewById(R.id.view_book_details);
        b2= (Button)findViewById(R.id.view_customer_details);
        b3= (Button)findViewById(R.id.delete_bookings);
        b4=(Button)findViewById(R.id.delete_customer);

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBookingDetails();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomerDetails();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeleteBookings();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeleteCustomers();
            }
        });
    }
    public void openBookingDetails(){
        Intent intent =new Intent(this,BookingDetails.class);
        startActivity(intent);
    }
    public void openCustomerDetails(){
        Intent intent =new Intent(this,CustomerDetails.class);
        startActivity(intent);
    }
    public void openDeleteBookings(){
        Intent intent =new Intent(this, SearchDelete_Booking.class);
        startActivity(intent);
    }
    public void openDeleteCustomers(){
        Intent intent =new Intent(this,Delete_Customer.class);
        startActivity(intent);
    }
}