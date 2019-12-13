package com.example.timelyearth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;


public class listprojectsActivity extends Activity implements AdapterView.OnItemClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_listprojects);

        //List projects in list view
        ListView listview = (ListView) findViewById(R.id.listView1);
        listview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int id, long position) {
        Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);

        Intent intent = new Intent();
        intent.setClass(this, ListItemDetail.class);
        intent.putExtra("position", position);

        intent.putExtra("id", id);
        startActivity(intent);
    }
}
