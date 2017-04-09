package com.example.nil_akash.apptest.userAuthentication;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by NiL-AkAsH on 4/10/2017.
 */

public class Authontication {
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static String USERINFO_DB;
    private static String USERKEY;
    public static UserInformation USERINFO;
    public static boolean FLAG;

    public Authontication(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(USERINFO_DB,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void addUser(UserInformation userInfo){      //user Add Method
        Gson gson = new Gson();
        String user = gson.toJson(userInfo);            //convert UserInformation Object to String
        editor.putString(USERKEY,user);
        editor.commit();
    }

    public boolean getUser(){                           //user Get Method
        Gson gson = new Gson();
        String json = sharedPreferences.getString(USERKEY,""); //get object as a string
        if(json.equals(null)){
            FLAG = false;
            return false;
        }else{
            USERINFO = gson.fromJson(json,UserInformation.class); //convert String to Object
            FLAG = true;
            return true;
        }
    }


    public boolean isUser(String userId,String userPass){           //user Verification Method
        if(FLAG){
            if(this.USERINFO.getUserId().equals(userId)&&this.USERINFO.getPassword().equals(userPass)){
                return true;
            }else{
                return false;
            }
        }else return false;
    }
}
