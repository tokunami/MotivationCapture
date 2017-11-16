package com.example.motivationcapture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.motivationcapture.utils.Const;

/**
 * Created by tokunaga on 11/9/17.
 */

public class ShowOverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

//        display settings
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setText(Const.BACKBTNTXT);
        TextView dateTxt = (TextView) findViewById(R.id.datetxt);

        TextView[] titles = {(TextView) findViewById(R.id.g1Title), (TextView) findViewById(R.id.g2Title)};
        for (int i = 0; i < titles.length; i++){
            titles[i].setText(Const.TITLES[i]);
        }
        dateTxt.setText(Const.TODAY);

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //open sub-category
                Intent intent = new Intent();
                intent.setClassName("com.example.motivationcapture", "com.example.motivationcapture.MainActivity");
                startActivity(intent);
            }
        });

    }

}
