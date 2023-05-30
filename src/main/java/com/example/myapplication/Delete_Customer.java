package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class Delete_Customer extends AppCompatActivity {
    Button del, search;
    EditText delete_name;
    MyDBHelper db = new MyDBHelper(Delete_Customer.this, "BikesDB", null, 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_customer);
        del = findViewById(R.id.del_btn_customer);
        delete_name = findViewById((R.id.delete_name_customer));
        search = findViewById(R.id.show_customer);
        search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openSearchActivity(delete_name);
            }
            private void openSearchActivity(EditText delete_name) {
                Intent intent =new Intent(Delete_Customer.this,search_2.class);
                intent.putExtra("DELETE_NAME", delete_name.getText().toString());
                startActivity(intent);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = delete_name.getText().toString();
                Boolean checkudeletedata = db.deleteCustomer(nameTXT);
                if (checkudeletedata == true)
                    Toast.makeText(Delete_Customer.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Delete_Customer.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}