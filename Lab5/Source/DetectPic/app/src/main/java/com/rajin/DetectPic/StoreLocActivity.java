package com.rajin.DetectPic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.clarifai.android.starter.api.v2.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StoreLocActivity extends AppCompatActivity {
    View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    public List<StoreDetails> cc;
    public Stores(Activity a, List<StoreDetails> cc) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        this.cc=cc;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.result);
        yes = (Button) findViewById(R.id.gotit);

        yes.setOnClickListener(this);

        ArrayList<TextView> textViewList =new ArrayList<TextView>();
        textViewList.add((TextView)findViewById(R.id.add1));
        textViewList.add((TextView)findViewById(R.id.add2));
        textViewList.get(0).setText("StoreName"+" - "+"Address");
        int i=1;
        Collections.shuffle(cc);
        for(StoreDetails concept:cc){
            if(i>4)break;
            textViewList.get(i).setText(concept.getName()+"\t"+"--"+concept.getAddress());

            i++;
        }
        // no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gotit:
                this.dismiss();
                break;

            default:
                break;
        }

    }
}