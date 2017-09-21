package com.rajin.myfirstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{
    Button btnRegister;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegister= (Button) findViewById(R.id.button4);
        btnLogin= (Button) findViewById(R.id.button3);

        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class );
                startActivity(registerIntent);
            }

        });


    btnLogin.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
        Intent homeIntent= new Intent(MainActivity.this, HomeActivity.class);
        startActivity(homeIntent);

    }
});


    }
    

    }
