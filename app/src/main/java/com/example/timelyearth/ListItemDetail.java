package com.example.timelyearth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;

public class ListItemDetail extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_listitem);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


      // Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        // Here we turn your string.xml in an array
       String[] myKeys = getResources().getStringArray(R.array.sections);
       TextView myTextView = (TextView) findViewById(R.id.id);
       myTextView.setText(myKeys[position]);

//
//        ArrayList<String> ar = new ArrayList<String>();
//        String s1 ="Test1";
//        String s2 ="Test2";
//        String s3 ="Test3";
//        ar.add(s1);
//        ar.add(s2);
//        ar.add(s3);
//        myTextView.setText(ar.get(0));

    }

}