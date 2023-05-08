package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete_Booking extends AppCompatActivity {
    MyDBHelper db = new MyDBHelper(Delete_Booking.this, "BikesDB", null, 5);
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_booking);
        EditText name = findViewById(R.id.delete_name);
        delete =findViewById(R.id.del_btn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = db.deleteBook(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(Delete_Booking.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Delete_Booking.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });
    }
}