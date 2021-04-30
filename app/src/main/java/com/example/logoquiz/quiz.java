package com.example.logoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class quiz extends AppCompatActivity {
    int id = 1;
    DBstorage db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent i = getIntent();
        setTitle("Hi, " + i.getStringExtra("name"));
    }

    public void onPrev(View view) {
        if(id <= 1)
            Toast.makeText(this, "First Question", Toast.LENGTH_SHORT).show();
//        else{
//            id--;
//        }
    }

    public void submit(View view){
    }

    public void onNext(View view) {
        if(id > db.totalQuestions())
            Toast.makeText(this, "Max Questions Reached", Toast.LENGTH_SHORT).show();
//        else{
//            id++;

        }
    }
}