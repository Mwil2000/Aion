package com.example.gif;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.*;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class activity_login extends Activity {

    private static DBHelper DB = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.login);
        MaterialButton createbtn = (MaterialButton) findViewById(R.id.create_Acount);

        DB = new DBHelper(this);


        //admin admin
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupActivity();
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")|| pass.equals("")){
                    //openMainActivity();
                    Toast.makeText(activity_login.this,"Wszystkie pola muszą być wypełnione",Toast.LENGTH_SHORT).show();
                }else{
                   Boolean checkuserpass = DB.checkUsernamePasssword(user,pass);
                   if(checkuserpass==true)
                   {
                       Toast.makeText(activity_login.this,"Logowanie...",Toast.LENGTH_SHORT).show();
                       openMainActivity();
                   } else
                   {
                       Toast.makeText(activity_login.this,"Login lub hasło zostały źle wpisane ",Toast.LENGTH_SHORT).show();
                   }

                }
            }
        });


    }

    public void openSignupActivity()
    {
        Intent intent = new Intent(this,activity_signup.class);
        startActivity(intent);

    }
    public void openMainActivity()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}