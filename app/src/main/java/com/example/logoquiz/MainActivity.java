package com.example.logoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");
    }

    public void onSubmit(View view) {
        EditText e = (EditText) findViewById(R.id.send);
        String s = e.getText().toString();
        if (!s.matches("")) {
            Intent i = new Intent(this, quiz.class);
            i.putExtra("name", s);
            startActivity(i);
        } else
            Toast.makeText(getApplicationContext(), "Invalid Name!!!", Toast.LENGTH_LONG).show();
    }

    public void goToAdmin(View view) {
        Intent i = new Intent(this,login.class);
        startActivity(i);
    }
}