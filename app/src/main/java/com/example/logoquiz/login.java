package com.example.logoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Admin Login");
    }

    String i="rk", p ="1234";

    public void submit(View view) {
        EditText e = (EditText)findViewById(R.id.id);
        String id = e.getText().toString();
        EditText e2 = (EditText)findViewById(R.id.pass);
        String pass = e2.getText().toString();
        if(id.equals("") || pass.equals(""))
            Toast.makeText(this, "Invalid id or password", Toast.LENGTH_SHORT).show();
        else {
            if (id.equals(i) && pass.equals(p)) {
                Intent i = new Intent(this, admin.class);
                startActivity(i);
            } else
                Toast.makeText(getApplicationContext(), "Invalid Admin", Toast.LENGTH_SHORT).show();
        }
    }
}