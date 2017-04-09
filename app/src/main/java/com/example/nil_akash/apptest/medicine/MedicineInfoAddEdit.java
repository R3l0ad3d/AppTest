package com.example.nil_akash.apptest.medicine;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageButton;

import com.example.nil_akash.apptest.R;

import java.io.ByteArrayOutputStream;

public class MedicineInfoAddEdit extends AppCompatActivity {

    private ImageButton ibtnPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_info_add_edit);

        ibtnPic = (ImageButton) findViewById(R.id.ibprecsiptionImage);
    }

    public void addPrecsiption(View view) {
        Intent in = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //in.putExtra("crop", "true");
        //in.putExtra("outputX", 100);
        //in.putExtra("outputY", 100);
        in.putExtra("scale", true);
        in.putExtra("return-data", true);

        startActivityForResult(in, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {

            Bitmap bmp = (Bitmap) data.getExtras().get("data");

            ibtnPic.setImageBitmap(bmp);
            ibtnPic.requestFocus();

        }
    }
}
