package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Activity2 extends AppCompatActivity {
    ImageButton camera;
    EditText name, nationality, address, phone_num, bike, bike_num,visit_date, return_date, license_no, passport_no, total_price;
    Button submit;
    Calendar myCalendar;
    MyDBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        myCalendar=Calendar.getInstance();
        name = findViewById(R.id.customer_name);
        nationality = findViewById(R.id.customer_nationality);
        address = findViewById(R.id.customer_address);
        phone_num = findViewById(R.id.customer_number);
        bike = findViewById(R.id.customer_bike);
        bike_num = findViewById(R.id.c_bike_num);
        license_no = findViewById(R.id.customer_license_no);
        passport_no = findViewById(R.id.customer_passport);
        visit_date = (EditText) findViewById(R.id.c_visitdate);
        return_date = (EditText)findViewById(R.id.c_returndate);
        total_price = findViewById(R.id.c_c_totalprice);
        submit = findViewById(R.id.button3);
        db = new MyDBHelper(Activity2.this, "BikesDB", null, 1);
        setTitle("Record Info Section");
        camera = (ImageButton) findViewById(R.id.btnCam);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent= new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }


        });
        DatePickerDialog.OnDateSetListener date1= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel1();


            }
        };
        DatePickerDialog.OnDateSetListener date2= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel2();


            }
        };
        visit_date.setOnClickListener(view->{
            new DatePickerDialog(Activity2.this,date1,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });
        return_date.setOnClickListener(view->{
            new DatePickerDialog(Activity2.this,date2,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
//                if(TextUtils.isEmpty(name.getText().toString())){
//                    name.setError("Name is compulsary");
//                }
//
//                if(TextUtils.isEmpty(nationality.getText().toString())){
//                    nationality.setError("Nationality is compulsary");
//                }
//                if(TextUtils.isEmpty(address.getText().toString())){
//                    address.setError("Address is compulsary");
//                }
//                if(TextUtils.isEmpty(phone_num.getText().toString())){
//                    phone_num.setError("Phone number is compulsary");
//                }
//                if(TextUtils.isEmpty(bike.getText().toString())){
//                    bike.setError("Bike name is compulsary");
//
//                    if(TextUtils.isEmpty(bike_num.getText().toString())){
//                        bike_num.setError("Phone number is compulsary");
//                    }
//                    if(TextUtils.isEmpty(license_no.getText().toString())){
//                        license_no.setError("Phone number is compulsary");
//                    }
//                    if(TextUtils.isEmpty(passport_no.getText().toString())){
//                        passport_no.setError("Phone number is compulsary");
//                    }
//                }if(TextUtils.isEmpty(visit_date.getText().toString())){
//                    visit_date.setError("visit date is compulsary");
//                }
//                if(TextUtils.isEmpty(return_date.getText().toString())){
//                    return_date.setError("Return date is compulsary");
//                }
//                if(TextUtils.isEmpty(total_price.getText().toString())){
//                    total_price.setError("Total price is compulsary");
//                }
                String personName = name.getText().toString();
                String Nationality = nationality.getText().toString();
                String Address = address.getText().toString();
                String License_no= license_no.getText().toString();
                String Passport_no= passport_no.getText().toString();
                String Phone_num = phone_num.getText().toString();
                String Bike = bike.getText().toString();
                String Bike_num= bike_num.getText().toString();

                String v_date = visit_date.getText().toString();
                String r_date = return_date.getText().toString();
                String tprice = total_price.getText().toString();


                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

                Date date1= null;
                try {
                    date1 = new SimpleDateFormat("dd/MM/yyyy").parse(v_date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(v_date+"\t"+date1);

                if(TextUtils.isEmpty(v_date) || TextUtils.isEmpty(r_date)){
                    Toast.makeText(getApplicationContext(), "Please select visit and return dates", Toast.LENGTH_LONG).show();
                    return;
                }
                Date date2= null;
                try {
                    date2 = new SimpleDateFormat("dd/MM/yyyy").parse(r_date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                long recordcustomer = db.saveCustomer(personName,Nationality,License_no,Passport_no,Address,Phone_num,date1,date2,Bike,Bike_num,tprice);

                if (recordcustomer > 0)
                    Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "Unsaved", Toast.LENGTH_LONG).show();
            }

        }
        );
    }
    private void updateLabel1() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat1 = new SimpleDateFormat(myFormat, Locale.US);

        dateFormat1.setTimeZone(TimeZone.getTimeZone("GMT"));
        visit_date.setText(dateFormat1.format(myCalendar.getTime()));
    }

    private void updateLabel2() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat1 = new SimpleDateFormat(myFormat, Locale.US);
        Calendar calendar = myCalendar;
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return_date.setText(dateFormat1.format(calendar.getTime()));
    }
}
