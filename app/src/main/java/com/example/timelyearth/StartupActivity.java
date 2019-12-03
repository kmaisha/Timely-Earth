package com.example.timelyearth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;



public class StartupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);



      //Generate random number between 1 and 5
        final int min = 1;
        final int max = 5;
        final int random = new Random().nextInt((max - min) + 1) + min;

        //Select quote
        String randomQuote = "";

       switch (random)
       {
           case 1 :
               randomQuote = "Let's make great designs today.";
               break;

           case 2 :
               randomQuote = "The public is more familiar with bad design than good design.";
               break;

           case 3 :
               randomQuote = "Design is everywhere. Good design is not.";
               break;

           case 4 :
               randomQuote = "Design won't save the world, but it can make it look good.";
               break;

           case 5 :
               randomQuote = "Good design is simple, that's why it's so complicated.";
               break;

        }

        //Set quote
        TextView quote = findViewById(R.id.quote);
        quote.setText("''" + randomQuote + "''");
    }

    public void whenButtonClicked(View view) {
        //Transition to Main Activity
        Intent my_intent = new Intent(getBaseContext(), listprojectsActivity.class);
        startActivity(my_intent);
    }

}
