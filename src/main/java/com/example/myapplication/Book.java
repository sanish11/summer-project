package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Book extends AppCompatActivity {

    EditText name, nationality, address, phone_num, bike, visit_date, return_date, price_per_day, total_price;
    Button submit;
    Calendar myCalendar;

    MyDBHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book);
        createNotificationChannel();
        myCalendar=Calendar.getInstance();

        setTitle("Booking Section");

        name = findViewById(R.id.name);
        nationality = findViewById(R.id.nationality);
        address = findViewById(R.id.address);
        phone_num = findViewById(R.id.phone);
        bike = findViewById(R.id.bike);
        visit_date = (EditText) findViewById(R.id.visit);
        return_date = (EditText)findViewById(R.id.returnd);
        price_per_day = findViewById(R.id.ppday);
        total_price = findViewById(R.id.totalprice);
        submit = findViewById(R.id.button3);
        db = new MyDBHelper(Book.this, "BikesDB", null, 1);

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
            new DatePickerDialog(Book.this,date1,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });
        return_date.setOnClickListener(view->{
            new DatePickerDialog(Book.this,date2,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });



//        String visitDateString = visit_date.getText().toString();
//        String returnDateString = return_date.getText().toString();



        //saving data to SQLite
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("Name is compulsary");
                }

                if(TextUtils.isEmpty(nationality.getText().toString())){
                    nationality.setError("Nationality is compulsary");
                }
                if(TextUtils.isEmpty(address.getText().toString())){
                    address.setError("Address is compulsary");
                }
                if(TextUtils.isEmpty(phone_num.getText().toString())){
                    phone_num.setError("Phone number is compulsary");
                }
                if(TextUtils.isEmpty(bike.getText().toString())){
                    bike.setError("Bike name is compulsary");
                }if(TextUtils.isEmpty(visit_date.getText().toString())){
                    visit_date.setError("visit date is compulsary");
                }
                if(TextUtils.isEmpty(return_date.getText().toString())){
                    return_date.setError("Return date is compulsary");
                }
                if(TextUtils.isEmpty(price_per_day.getText().toString())){
                    price_per_day.setError("Price per day is compulsary");
                }
                if(TextUtils.isEmpty(total_price.getText().toString())){
                    total_price.setError("Total price is compulsary");
                }


                String personName = name.getText().toString();
                String Nationality = nationality.getText().toString();
                String Address = address.getText().toString();
                String Phone_num = phone_num.getText().toString();
                String Bike = bike.getText().toString();
                String v_date = visit_date.getText().toString();

                String r_date = return_date.getText().toString();
                String ppday = price_per_day.getText().toString();
                String tprice = total_price.getText().toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

//                String sDate1="31/12/1998";
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




//                assert selectedDate != null;
//                assert returnDate != null;
                long recordid = db.saveBooking(personName, Nationality, Address, Phone_num, Bike, date1,date2, ppday, tprice);

                if (recordid > 0){
                    Toast.makeText(getApplicationContext(), "Saved successfully", Toast.LENGTH_LONG).show();
                    /*Toast.makeText(getApplicationContext(), "wala wala", Toast.LENGTH_LONG).show();*/
                } else
                    Toast.makeText(getApplicationContext(), "Unsaved", Toast.LENGTH_LONG).show();

                String NotificationDateFormat = "dd-MM-yyyy";


                long visitdatemiliseconds = date1.getTime()-86400000;
                Log.d("vdate", String.valueOf(visitdatemiliseconds));


                Intent intent = new Intent(Book.this,RemainderBroadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(Book.this,0,intent,PendingIntent.FLAG_MUTABLE);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                long timeAtButtonClick =System.currentTimeMillis();
                long tenSecondsInMillis = 1000;
                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        timeAtButtonClick + tenSecondsInMillis, pendingIntent);
                //visitdatemiliseconds : to be used for the noptification day before visit date


            }
        });


 }
    private void updateLabel1(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat1=new SimpleDateFormat(myFormat,Locale.US);

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
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name="MaharjanBikes";
            String description = "Channel for maharjanbikes";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel =  new NotificationChannel("maharjanbikes",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


}