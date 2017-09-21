package com.rajin.myfirstapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Document;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity{
    TextView textView;
    EditText editText;
    Button button;
    String sentiment;

    private class AskWatsonTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... textsToAnalyse){
            System.out.println(editText.getText());

            runOnUiThread(new Runnable(){
                @Override
                public void run(){
                    textView.setText("Joy & sadness values are:");
                }
            });

            NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                    NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27,
                    "827ce652-f2f3-46fa-917d-5e1272f9a497",
                    "zvy2gDT0XIny"
            );

            EntitiesOptions entities = new EntitiesOptions.Builder().sentiment(true).limit(1).build();
            Features features = new Features.Builder().entities(entities).build();
            AnalyzeOptions parameters = new AnalyzeOptions.Builder().text("Roller coasters are terrifying").features(features).build();
            AnalysisResults sentiment = service.analyze(parameters).execute();
            System.out.println(sentiment);
            return sentiment.getAnalyzedText();
        }

        protected void onPostExcecute(String result){
            textView.setText("the message sentiment is:"+result);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initialize UI parameters
        textView= (TextView) findViewById(R.id.textView);
        editText= (EditText) findViewById(R.id.editText);
        button= (Button) findViewById(R.id.button);

        //fire action when button is pressed
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.out.println("loggin to console: " +editText.getText());
                textView.setText("Displaying at UI: "+editText.getText());

                AskWatsonTask task=new AskWatsonTask();
                AsyncTask<String, Void, String> execute = task.execute(new String[]{});
            }
        });


    }


}
