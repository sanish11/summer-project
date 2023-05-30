package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button_1;
    private Button button_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setTitle("Maharjan Bikes Hire");
        button_1= (Button)findViewById(R.id.button4);
        button = (Button) findViewById(R.id.button);
        button_2= (Button) findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityBook();
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityDetails();
            }
        });


    }
    public void openActivity2(){
        Intent intent =new Intent(this,Activity2.class);
        startActivity(intent);
    }
    public void openActivityBook(){
        Intent intent =new Intent(this,Book.class);
        startActivity(intent);

    }
    public void openActivityDetails(){
        Intent intent =new Intent(this,Details.class);
        startActivity(intent);

    }



}