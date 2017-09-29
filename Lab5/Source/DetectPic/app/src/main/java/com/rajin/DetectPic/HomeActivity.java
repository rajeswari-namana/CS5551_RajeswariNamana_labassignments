package com.rajin.DetectPic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_map, button_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button_map = (Button) findViewById(R.id.main_btn_maps);
        button_photo = (Button) findViewById(R.id.main_btn_photo);

    }

    public void onPhotoClick(View v) {
        //This code redirects the from main page to the maps page.
        Intent redirect = new Intent(MainActivity.this, CameraActivity.class);
        startActivity(redirect);
    }

    public void onLocationClick(View v) {
        //This code redirects to the photo activity.
        Intent redirect = new Intent(MainActivity.this, PredictActivity.class);
        startActivity(redirect);
    }


    public void storageClick(View v){
        Intent redirect = new Intent(MainActivity.this, StoreActivity.class);
        startActivity(redirect);
    }
}

