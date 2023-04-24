package com.example.gif;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class activity_setname extends AppCompatActivity {

    MaterialButton setUsername;
    EditText username;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setname);

        username = (EditText) findViewById(R.id.set_username);
        setUsername = (MaterialButton) findViewById(R.id.set_username_btn);
        DB = new DBHelper(this);
        setUsername.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

    }
}