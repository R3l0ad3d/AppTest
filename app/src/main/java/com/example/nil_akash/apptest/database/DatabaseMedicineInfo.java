package com.example.nil_akash.apptest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.nil_akash.apptest.modelclass.MedicineInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NiL-AkAsH on 4/10/2017.
 */

public class DatabaseMedicineInfo {
    private Context context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase db;


    public DatabaseMedicineInfo(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
    }

    private void open(){
        db = dbHelper.getWritableDatabase();
    }
    private void close(){
        db.close();
    }

    public boolean InsertMedicineInfo(MedicineInformation mInfo){
        this.open();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_DOCTOR_ID,mInfo.getDoctorID());
        values.put(DatabaseHelper.COL_PRESCRIPTION_DATE,mInfo.getPrecsiptionDate().toString());
        values.put(DatabaseHelper.COL_PRESCRIPTION_DETAILS,mInfo.getPrecsiptionDetails());
        values.put(DatabaseHelper.COL_PRESCRIPTION_IMAGE,mInfo.getPrecsiptionImage());

        long tmp = db.insert(DatabaseHelper.TABLE_MEDICINE_INFORMATION,null,values);
        this.close();

        if(tmp>0) return true;
        else return false;

    }
    public boolean UpdateMedicineInfo(MedicineInformation mInfo){
        this.open();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COL_DOCTOR_ID,mInfo.getDoctorID());
        values.put(DatabaseHelper.COL_PRESCRIPTION_DATE,mInfo.getPrecsiptionDate().toString());
        values.put(DatabaseHelper.COL_PRESCRIPTION_DETAILS,mInfo.getPrecsiptionDetails());
        values.put(DatabaseHelper.COL_PRESCRIPTION_IMAGE,mInfo.getPrecsiptionImage());

        final String WHERE = DatabaseHelper.COL_MEDICINE_ID+" = "+mInfo.getPrecsiptionId();

        long tmp = db.update(DatabaseHelper.TABLE_MEDICINE_INFORMATION,values,WHERE,null);
        this.close();

        if(tmp>0) return true;
        else return false;
    }

    public void DeleteMedicineInfo(MedicineInformation mInfo){
        this.open();

        final String WHERE = DatabaseHelper.COL_MEDICINE_ID+" = "+mInfo.getPrecsiptionId();

        db.delete(DatabaseHelper.TABLE_MEDICINE_INFORMATION,WHERE,null);

        this.close();
    }

    public List<MedicineInformation> GetMedicineData(int drId){
        this.open();
        Cursor cursor;
        List<MedicineInformation> mInfoList = new ArrayList<>();
        MedicineInformation mInfo = new MedicineInformation();
        final String WHERE = DatabaseHelper.COL_DOCTOR_ID+" = "+drId;
        if(drId>0){
            cursor = db.query(DatabaseHelper.TABLE_MEDICINE_INFORMATION,null,WHERE,null,null,null,null);
        }else{
            cursor = db.query(DatabaseHelper.TABLE_MEDICINE_INFORMATION,null,null,null,null,null,null);
        }

        cursor.moveToFirst();

        for (int i=0;i<cursor.getCount();i++){
            mInfo.setPrecsiptionId(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_MEDICINE_ID)));
            mInfo.setDoctorID(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_DOCTOR_ID)));
            mInfo.setPrecsiptionDetails(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PRESCRIPTION_DETAILS)));
            mInfo.setPrecsiptionDate(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PRESCRIPTION_DATE)));
            mInfo.setPrecsiptionImage(cursor.getBlob(cursor.getColumnIndex(DatabaseHelper.COL_PRESCRIPTION_IMAGE)));

            mInfoList.add(mInfo);
            cursor.moveToFirst();
        }

        return mInfoList;
    }
}
