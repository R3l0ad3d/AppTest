package com.example.nil_akash.apptest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nil_akash.apptest.modelclass.DoctorInformation;

/**
 * Created by NiL-AkAsH on 4/10/2017.
 */

public class DatabaseDoctorInfo {
    private Context context;
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public DatabaseDoctorInfo(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
    }

    private void open(){
        db = dbHelper.getWritableDatabase();
    }

    private void close(){
        db.close();
    }

    public boolean InsertDoctorInfo(DoctorInformation drInfo){
        this.open();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_DOCTOR_NAME,drInfo.getDoctorName().toString());
        values.put(DatabaseHelper.COL_DOCTOR_DETAILS,drInfo.getDoctorDetails().toString());
        values.put(DatabaseHelper.COL_DOCTOR_MAIL,drInfo.getDoctorMail().toString());
        values.put(DatabaseHelper.COL_DOCTOR_PHONE,drInfo.getDoctorPhone().toString());
        values.put(DatabaseHelper.COL_DOCTOR_FIRST_MEET,drInfo.getDoctorFirstMeetDate().toString());
        values.put(DatabaseHelper.COL_DOCTOR_LAST_MEET,drInfo.getDoctorLastMeetDate().toString());
        values.put(DatabaseHelper.COL_DOCTOR_LOCATION,drInfo.getDoctorLocation().toString());

        long tmp = db.insert(DatabaseHelper.TABLE_DOCTOR_INFORMATION,null,values);
        this.close();
        if(tmp>0) return true;
        else return false;
    }

    public boolean UpdateDoctorInfo(DoctorInformation drInfo){
        this.open();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_DOCTOR_NAME,drInfo.getDoctorName().toString());
        values.put(DatabaseHelper.COL_DOCTOR_DETAILS,drInfo.getDoctorDetails().toString());
        values.put(DatabaseHelper.COL_DOCTOR_MAIL,drInfo.getDoctorMail().toString());
        values.put(DatabaseHelper.COL_DOCTOR_PHONE,drInfo.getDoctorPhone().toString());
        values.put(DatabaseHelper.COL_DOCTOR_FIRST_MEET,drInfo.getDoctorFirstMeetDate().toString());
        values.put(DatabaseHelper.COL_DOCTOR_LAST_MEET,drInfo.getDoctorLastMeetDate().toString());
        values.put(DatabaseHelper.COL_DOCTOR_LOCATION,drInfo.getDoctorLocation().toString());

        final String WHERE = DatabaseHelper.COL_DOCTOR_ID+" = "+drInfo.getDoctorId(); // where commend

        long tmp = db.update(DatabaseHelper.TABLE_DOCTOR_INFORMATION,values,WHERE,null); //update doctor info where doctor id match
        this.close();

        if(tmp>0) return true;
        else return false;
    }

    public void DeleteDoctorInfo(DoctorInformation drInfo){
        this.open();

        final String WHERE = DatabaseHelper.COL_DOCTOR_ID+" = "+drInfo.getDoctorId();
        db.delete(DatabaseHelper.TABLE_DOCTOR_INFORMATION,WHERE,null);
        this.close();
    }


}
