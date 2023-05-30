package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class MyDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;



//To create SQLite database
    public MyDBHelper(@Nullable Context context, String dbname ,SQLiteDatabase.CursorFactory factory,int version) {
        super(context, dbname, null, DATABASE_VERSION);
    }
//Creates table
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table book(id INTEGER primary key autoincrement,name varchar(20),nationality varchar(20),address varchar(20),phone varchar(20),Bike varchar(20),visit_date TEXT,return_date TEXT,priceperday int(20),total_price int(20))");
        db.execSQL("create table customer(id INTEGER primary key autoincrement,name varchar(20),phone varchar(20),address varchar(20),nationality varchar(20),Bike varchar(20),Bike_num varchar(20),License_no varchar(20),Passport_no varchar(20),visit_date TEXT,return_date TEXT,total_price int(20))");



    }

//drop table if exists when the veersion changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS book" );
        db.execSQL("DROP TABLE IF EXISTS customer" );
        onCreate(db);
    }
//to save user data
//    public long saveBooking(String name, String Phone_Number, String Address, String Nationality, String Bike, Date visit_date, Date Return_date, String Price_per_day, String Total_price){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv= new ContentValues();
//        cv.put("name",name);
//        cv.put("nationality",Nationality);
//
//        cv.put("address",Address);
//        cv.put("phone",Phone_Number);
//
//        cv.put("Bike",Bike);
//        cv.put("visit_date", visit_date.toString());
//        cv.put("return_date", Return_date.toString());
//
//        int pricePerDay = Integer.parseInt(Price_per_day);
//        int totalPrice = Integer.parseInt(Total_price);
//        cv.put("priceperday",Price_per_day);
//        cv.put("total_price",Total_price);
//        long recordid=db.insert("book",null,cv);
//        db.close();
//
//        return recordid;
//    }
public long saveBooking(String name, String nationality, String address, String phone, String bike, Date visit_date, Date return_date, String price_per_day, String total_price){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv= new ContentValues();
    cv.put("name",name);
    cv.put("nationality",nationality);
    cv.put("address",address);
    cv.put("phone",phone);
    cv.put("Bike",bike);
    cv.put("visit_date", visit_date.toString());
    cv.put("return_date", return_date.toString());
    int pricePerDay = Integer.parseInt(price_per_day);
    int totalPrice = Integer.parseInt(total_price);
    cv.put("priceperday",pricePerDay);
    cv.put("total_price",totalPrice);
    long recordid=db.insert("book",null,cv);
    db.close();
    return recordid;
}
//    public long saveCustomer(String c_name,String c_phone,String c_Address,String c_Nationality, String c_Bike,String c_Bike_no,Date c_visit_date,Date c_return_date, String c_License_no,String c_passport_no,String c_Total_price){
//        SQLiteDatabase db= this.getWritableDatabase();
//        ContentValues c= new ContentValues();
//        c.put("name",c_name);
//        c.put("phone",c_phone);
//        c.put("address",c_Address);
//        c.put("nationality",c_Nationality);
//        c.put("Bike",c_Bike);
//        c.put("Bike_num",c_Bike_no);
//        c.put("License_no",c_License_no);
//        c.put("Passport_no",c_passport_no);
//        c.put("visit_date", c_visit_date.toString());
//        c.put("return_date", c_return_date.toString());
//
//
//        int totalPrice = Integer.parseInt(c_Total_price);
//
//        c.put("total_price",c_Total_price);
//        long recordcustomer=db.insert("customer",null,c);
//        db.close();
//        return recordcustomer;
//    }
public long saveCustomer(String c_name, String c_phone, String c_Address, String c_Nationality, String c_Bike, String customerbikenumber, Date c_visit_date, Date c_return_date, String c_License_no, String c_passport_no, String c_Total_price) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues c = new ContentValues();
    c.put("name", c_name);
    c.put("phone", c_phone);
    c.put("address", c_Address);
    c.put("nationality", c_Nationality);
    c.put("Bike", c_Bike);
    c.put("Bike_num", customerbikenumber);
    c.put("License_no", c_License_no);
    c.put("Passport_no", c_passport_no);
    c.put("visit_date", c_visit_date.toString());
    c.put("return_date", c_return_date.toString());

    int totalPrice = Integer.parseInt(c_Total_price);

    c.put("total_price", totalPrice);
    long recordcustomer = db.insert("customer", null, c);
    db.close();
    return recordcustomer;
}
    public Cursor getAllRecords(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from book",null);
        return cursor;

    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cu=db.rawQuery("select * from customer",null);

        return cu;

    }
    public boolean deleteBook(String name){
        SQLiteDatabase db= this.getWritableDatabase();
        int result=db.delete("book","name=?",new String[]{String.valueOf(name)});
        db.close();
        return result>0;
    }
    public boolean deleteCustomer(String name){
        SQLiteDatabase db= this.getWritableDatabase();
        int result=db.delete("customer","name=?",new String[]{String.valueOf(name)});
        db.close();
        return result>0;
    }
    public Cursor showResult(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM book WHERE name = ?", new String[]{name});

        return cursor;
    }
    public Cursor showResult_customer(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM customer WHERE name = ?", new String[]{name});

        return cursor;
    }

}
