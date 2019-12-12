package com.example.timelyearth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long offsetPause;
    private boolean running;
    private Button button;
<<<<<<< HEAD
   // public int elapsedMillis;
    public long elapsedMillis;
    public long elapsedSec;
    public long elapsedMin;
    public long elapsedHour;
=======

    public long saveTime;

>>>>>>> master


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change gif name
        com.android.animatedgif.Utils.GifImageView gifImageView = (com.android.animatedgif.Utils.GifImageView) findViewById(R.id.GifImageView);
        gifImageView.setGifImageResource(R.drawable.earthspinning);

        button = (Button)findViewById(R.id.id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listprojectsActivity();
            }

        });
        chronometer = findViewById(R.id.chronometer);
    }
    private void listprojectsActivity() {
        Intent intent = new Intent(this, listprojectsActivity.class);
        startActivity(intent);
    }
    public void startChronometer(View v){
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - offsetPause);
            chronometer.start();
            running = true;
        }
    }

    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(saveTime),
            TimeUnit.MILLISECONDS.toMinutes(saveTime) % TimeUnit.HOURS.toMinutes(1),
            TimeUnit.MILLISECONDS.toSeconds(saveTime) % TimeUnit.MINUTES.toSeconds(1));

    public void pauseChronometer(View v){
        if(running){
            chronometer.stop();
            offsetPause = SystemClock.elapsedRealtime() - chronometer.getBase();
<<<<<<< HEAD
            if (elapsedMillis > 60000) {

            }
             elapsedMillis = (int) (SystemClock.elapsedRealtime() - chronometer.getBase());
            elapsedSec = elapsedMillis / 1000;
            elapsedMin = elapsedSec / 60;
            elapsedHour = elapsedMin / 60;

          // elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
=======
            saveTime = SystemClock.elapsedRealtime() - chronometer.getBase();
>>>>>>> master
            running = false;

            hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(saveTime),
                    TimeUnit.MILLISECONDS.toMinutes(saveTime) % TimeUnit.HOURS.toMinutes(1),
                    TimeUnit.MILLISECONDS.toSeconds(saveTime) % TimeUnit.MINUTES.toSeconds(1));
        }
    }



    public void resetChronometer(View v){
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());
        offsetPause = 0;
        running = false;

    }


<<<<<<< HEAD

   // int elapsedMillis = 30;
=======
//    public long elapsedMillis = saveTime;
>>>>>>> master

    //Export to CSV
    public void export(View view){
        StringBuilder data = new StringBuilder();
        data.append("Time Spent Working");
//        for(int i = 0; i < 5; i++) {
//            data.append("\n" + String.valueOf(i) + "." + String.valueOf(i * i));
//        }
<<<<<<< HEAD
    data.append("\n" + String.valueOf(elapsedMin + ":" + elapsedSec + ":" + elapsedMillis) );
        //data.append("\n" + elapsedMillis);

=======
        data.append("\n" + hms);
>>>>>>> master
        try{
            FileOutputStream out = openFileOutput("data.csv", Context.MODE_PRIVATE);
            out.write((data.toString()).getBytes());
            out.close();

            Context context = getApplicationContext();
            File filelocation = new File(getFilesDir(), "data.csv");
            Uri path = FileProvider.getUriForFile(context, "com.example.exportcsv.fileprovider", filelocation);
            Intent fileIntent = new Intent(Intent.ACTION_SEND);
            fileIntent.setType("text/csv");
            fileIntent.putExtra(Intent.EXTRA_SUBJECT, "DATA");
            fileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            fileIntent.putExtra(Intent.EXTRA_STREAM, path);
            startActivity(Intent.createChooser(fileIntent, "Send mail"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
