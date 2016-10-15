package com.example.alasif.tourmate.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alasif.tourmate.CustomAdapters.PreviousEventsAdapter;
import com.example.alasif.tourmate.Database.EventDatabaseSource;
import com.example.alasif.tourmate.Model.EventModel;
import com.example.alasif.tourmate.R;

import java.util.ArrayList;

public class PreviousEvents extends AppCompatActivity {
    private EventDatabaseSource eventDatabaseSource;
    private PreviousEventsAdapter previousEventsAdapter;
    private ListView previousEventsLv;
    private int loggedInUserId;
    private ArrayList<EventModel> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_events);


        previousEventsLv = (ListView) findViewById(R.id.previousEventsListView);
        loggedInUserId = getIntent().getIntExtra("loggedInUser",0);


        eventDatabaseSource = new EventDatabaseSource(PreviousEvents.this);
        events = eventDatabaseSource.getAllEvents(String.valueOf(loggedInUserId));
        previousEventsAdapter = new PreviousEventsAdapter(PreviousEvents.this, events);
        previousEventsLv.setAdapter(previousEventsAdapter);
        Toast.makeText(PreviousEvents.this,"ok",Toast.LENGTH_LONG).show();
    }


}
