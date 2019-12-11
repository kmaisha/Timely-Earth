package com.example.timelyearth;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.FileProvider;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;


public class listprojectsActivity extends Activity implements AdapterView.OnItemClickListener {
    //List array strings and view adapter
    ArrayList<String> listItems=new ArrayList<String>();
    Hashtable<String, Project> h = new Hashtable<String, Project>();
    ArrayAdapter<String> adapter;
    int clickCounter=0;

//    @Override
//    public void onCreate(Bundle icicle) {
//        super.onCreate(icicle);
//        setContentView(R.layout.activity_listprojects);
//        adapter=new ArrayAdapter<String>(this,
//               android.R.layout.simple_list_item_1,
//                listItems);
//        setListAdapter(adapter);
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_listprojects);

        //* *EDIT* *
        ListView listview = (ListView) findViewById(R.id.listView1);
        listview.setOnItemClickListener(this);
    }

//    public void addItems(View v) {
//        listItems.add("Project "+clickCounter++);
//        String projectName = "Project "+clickCounter++;
//        Project p = new Project(projectName);
//        h.put(projectName, p);
//        adapter.notifyDataSetChanged();
//    }

//    //Export to CSV
//    public void export(View view){
//        StringBuilder data = new StringBuilder();
//        data.append("Time.Distance");
//        for(int i = 0; i<5; i++) {
//            data.append("\n" + String.valueOf(i) + "." + String.valueOf(i * i));
//        }
//        try{
//            FileOutputStream out = openFileOutput("data.csv", Context.MODE_PRIVATE);
//            out.write((data.toString()).getBytes());
//            out.close();
//
//            Context context = getApplicationContext();
//            File filelocation = new File(getFilesDir(), "data.csv");
//            Uri path = FileProvider.getUriForFile(context, "com.example.exportcsv.fileprovider", filelocation);
//            Intent fileIntent = new Intent(Intent.ACTION_SEND);
//            fileIntent.setType("text/csv");
//            fileIntent.putExtra(Intent.EXTRA_SUBJECT, "DATA");
//            fileIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            fileIntent.putExtra(Intent.EXTRA_STREAM, path);
//            startActivity(Intent.createChooser(fileIntent, "Send mail"));
//        }
//         catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int id, long position) {
        Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
        // Then you start a new Activity via Intent
        Intent intent = new Intent();
        intent.setClass(this, ListItemDetail.class);
        intent.putExtra("position", position);
        // Or / And
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
