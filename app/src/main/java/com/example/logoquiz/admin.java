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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class admin extends AppCompatActivity {

    EditText o1,o2,o3,o4,ans;
    ImageView img;
    Button ins, add;
    DBstorage d;
    private final int REQUEST_CODE_GALLERY=999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setTitle("Welcome RK");
        init();
        d = new DBstorage(this,"quiz.db",null,1);

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(admin.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_GALLERY);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( o1.getText().toString().trim().equals("") || o2.getText().toString().trim().equals("") || o3.getText().toString().trim().equals("") || o4.getText().toString().trim().equals("") || ans.getText().toString().trim().equals(""))
                    Toast.makeText(admin.this, "Fields can't be empty", Toast.LENGTH_SHORT).show();
                else{
                    d.insertData(imageViewToByte(img), o1.getText().toString().trim(), o2.getText().toString().trim(), o3.getText().toString().trim(), o4.getText().toString().trim(), ans.getText().toString().trim());
                    Toast.makeText(getApplicationContext(), "Added Succesfully", Toast.LENGTH_SHORT).show();
                    o1.setText("");
                    o2.setText("");
                    o3.setText("");
                    o4.setText("");
                    ans.setText("");
                    img.setImageResource(R.mipmap.ic_launcher);
                }
            }
        });
    }

    private void init() {
        o1 = findViewById(R.id.opt1);
        o2 = findViewById(R.id.opt2);
        o3 = findViewById(R.id.opt3);
        o4 = findViewById(R.id.opt4);
        ans = findViewById(R.id.ans);
        img = findViewById(R.id.img);
        ins = findViewById(R.id.ins);
        add = findViewById(R.id.add);
    }

    //For selecting the image when permission in allowed
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i, REQUEST_CODE_GALLERY);
            }
            else
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    //For displaying the image when image is choosen
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //Converting image in bytes when add is clicked
    public byte[] imageViewToByte(ImageView img) {
        Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}