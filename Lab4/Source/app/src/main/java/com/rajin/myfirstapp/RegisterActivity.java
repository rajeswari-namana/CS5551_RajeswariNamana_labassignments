package com.rajin.myfirstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

Button btnRegister2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister2= (Button) findViewById(R.id.button);
        btnRegister2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent register2intent = new Intent(this,MainActivity.class );
        startActivity(register2intent);
    }
}
