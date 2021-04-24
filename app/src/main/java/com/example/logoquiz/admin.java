package com.example.logoquiz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class admin extends AppCompatActivity {

    EditText o1,o2,o3,o4,ans;
    ImageView img;
    Button ins, ad;
    DBstorage d;
    private final int IMAGE_PICK_CODE=1000,PERMISSION_CODE=1001;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        setTitle("Welcome RK");

        o1 = findViewById(R.id.opt1);
        o2 = findViewById(R.id.opt2);
        o3 = findViewById(R.id.opt3);
        o4 = findViewById(R.id.opt4);
        ans = findViewById(R.id.ans);
        img = findViewById(R.id.img);
        ins = findViewById(R.id.ins);
        ad = findViewById(R.id.add);

//        d = new DBstorage(this,"quiz.db",null,1);
//        sqLiteDatabase = d.getWritableDatabase();

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i,IMAGE_PICK_CODE);
                Uri uri ;
            }
        });
    }

    //For Displaying the Image
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE)
            img.setImageURI(data.getData());
    }

    public void add(View view) {
        Toast.makeText(this, "Question Added", Toast.LENGTH_SHORT).show();
    }
}