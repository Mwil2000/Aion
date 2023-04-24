package com.example.gif;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class activity_signup extends AppCompatActivity {

    EditText username,password,repassword;
    MaterialButton signup,login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.username_signin);
        password =(EditText) findViewById(R.id.password_signin);
        repassword =(EditText) findViewById(R.id.repassword_signin);
        signup = (MaterialButton) findViewById(R.id.signin_Button);
        login = (MaterialButton) findViewById(R.id.login_Button);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = password.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                {
                    Toast.makeText(activity_signup.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(repass))
                    {
                        Boolean checkUser = DB.checkUsername(user);
                        if(!checkUser) {
                            Boolean insert = DB.insertData(user,pass);
                            if(insert){
                                Toast.makeText(activity_signup.this, "Sign up successfully", Toast.LENGTH_SHORT).show();
                                openMainActivity();
                            }else{
                                Toast.makeText(activity_signup.this, "Użytkownik istnieje", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(activity_signup.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });

    }

    public void openLoginActivity()
    {
        Intent intent = new Intent(this,activity_login.class);
        startActivity(intent);
    }
    public void openMainActivity()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
