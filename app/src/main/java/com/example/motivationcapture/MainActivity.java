package com.example.motivationcapture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.motivationcapture.utils.Const;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        display settings
        Button sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setText(Const.SENDBTNTXT);
        TextView dateTxt = (TextView) findViewById(R.id.datetxt);
        dateTxt.setText(Const.TODAY);

        TextView[] questions = {(TextView) findViewById(R.id.question1txt), (TextView) findViewById(R.id.question2txt),(TextView) findViewById(R.id.commentTitle)};
        TextView[] captions = {(TextView) findViewById(R.id.cap5), (TextView) findViewById(R.id.cap4), (TextView) findViewById(R.id.cap3), (TextView) findViewById(R.id.cap2), (TextView) findViewById(R.id.cap1)};
        for (int i = 0; i < questions.length; i++){
            questions[i].setText(Const.QUESTIONS[i]);
        }
        for (int j = 0; j < captions.length; j++){
            captions[j].setText(Const.Q2_ANSWERS[j]);
        }

//        q1 feeling selector
        final boolean[] chekedStat = new boolean[5];
        final ImageView[] stIndicator = {(ImageView) findViewById(R.id.s1), (ImageView) findViewById(R.id.s2), (ImageView) findViewById(R.id.s3), (ImageView) findViewById(R.id.s4), (ImageView) findViewById(R.id.s5)};
        final ImageView[] activeStIndicator = {(ImageView) findViewById(R.id.s1_active), (ImageView) findViewById(R.id.s2_active), (ImageView) findViewById(R.id.s3_active), (ImageView) findViewById(R.id.s4_active), (ImageView) findViewById(R.id.s5_active)};

        for (int i=0; i < chekedStat.length; i++){
            final int finalInt = i;
            stIndicator[finalInt].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    resetIndicator(chekedStat, stIndicator, activeStIndicator);
                    stIndicator[finalInt].setVisibility(View.GONE);
                    activeStIndicator[finalInt].setVisibility(View.VISIBLE);
                    chekedStat[finalInt] = true;
                }
            });
            activeStIndicator[finalInt].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    stIndicator[finalInt].setVisibility(View.VISIBLE);
                    activeStIndicator[finalInt].setVisibility(View.GONE);
                    chekedStat[finalInt] = false;
                }
            });

        }

//        q2 confidence selector
        NumberPicker np = (NumberPicker) findViewById(R.id.numberPicker);
        np.setMaxValue(4);
        np.setMinValue(0);
        np.setValue(2);
        np.setDisplayedValues(Const.Q2_ANSWERS);

//        sendButton settings
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //open nextview
                Intent intent = new Intent();
                intent.setClassName("com.example.motivationcapture", "com.example.motivationcapture.ShowOverviewActivity");
                startActivity(intent);
            }
        });

    }

    private void resetIndicator (boolean[] checkedStat, ImageView[] imgViewArray, ImageView[] ActiveImgViewArray) {
        for (int i=0; i < checkedStat.length; i++){
            if (checkedStat[i]){
                ActiveImgViewArray[i].setVisibility(View.GONE);
                imgViewArray[i].setVisibility(View.VISIBLE);
            }
        }

    }

}

