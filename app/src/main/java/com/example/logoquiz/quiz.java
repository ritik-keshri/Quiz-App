package com.example.logoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class quiz extends AppCompatActivity {
    int id = 1;
    DBstorage db;
    ImageView img;
    Button opt1, opt2, opt3, opt4, prev, next, sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent i = getIntent();
        setTitle("Hi, " + i.getStringExtra("name"));

        init();
    }

    public void init(){
        img = findViewById(R.id.img);
        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        sub = findViewById(R.id.submit);
    }

    public void onPrev(View view) {
        if(id <= 1)
            Toast.makeText(this, "First Question", Toast.LENGTH_SHORT).show();
        else {
            id--;
            showData(id);
        }
    }

    public void submit(View view){
    }

    public void onNext(View view) {
        if(id > db.totalQuestions())
            Toast.makeText(this, "Max Questions Reached", Toast.LENGTH_SHORT).show();
        else{
            id++;
            showData(id);
        }
    }

    public void showData(int id){
//        img.setImageBitmap(db.getImage(id));

    }
}