package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchDelete_Booking extends AppCompatActivity {
    MyDBHelper db = new MyDBHelper(SearchDelete_Booking.this, "BikesDB", null, 5);
    Button delete,search;
    EditText delete_name;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_booking);
        delete_name = findViewById(R.id.delete_name);
        delete =findViewById(R.id.del_btn);
        search = findViewById(R.id.show);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String nameTXT = delete_name.getText().toString();
//                Cursor searchdata= db.showResult(nameTXT);
//
//                if(searchdata.moveToFirst()){
//                    Log.d("Delete_Booking","msg:"+searchdata.moveToFirst());
//                    Toast.makeText(Delete_Booking.this, "Show entry", Toast.LENGTH_SHORT).show();

                        openSearchActivity(delete_name);

//                }
//                else
//                {
//                    Toast.makeText(Delete_Booking.this, "no entry", Toast.LENGTH_SHORT).show();}

            }
            private void openSearchActivity(EditText delete_name) {
                Intent intent =new Intent(SearchDelete_Booking.this,Search.class);
                intent.putExtra("DELETE_NAME", delete_name.getText().toString());
                startActivity(intent);
            }


        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = delete_name.getText().toString();
                Boolean checkudeletedata = db.deleteBook(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(SearchDelete_Booking.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SearchDelete_Booking.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });
    }
}