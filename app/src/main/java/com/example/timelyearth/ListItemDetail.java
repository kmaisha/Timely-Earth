package com.example.timelyearth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ListItemDetail extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Clicking on list item takes to main activiy for time tracking
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        int position = intent.getIntExtra("position", 0);

        //Test array for listview
       String[] myKeys = getResources().getStringArray(R.array.sections);
       TextView myTextView = (TextView) findViewById(R.id.id);
       myTextView.setText(myKeys[position]);


    }

}