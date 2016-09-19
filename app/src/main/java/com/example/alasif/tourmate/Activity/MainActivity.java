package com.example.alasif.tourmate.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alasif.tourmate.CustomAdapters.PreviousEventsAdapter;
import com.example.alasif.tourmate.Database.EventDatabaseSource;
import com.example.alasif.tourmate.Model.EventModel;
import com.example.alasif.tourmate.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView loggedinTv;
    Button logoutBtn;
    Session session;
    ListView previousEventsLv;
    ArrayList<EventModel> events;
    PreviousEventsAdapter previousEventsAdapter;
    EventDatabaseSource eventDatabaseSource;
    Button previousEventsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loggedinTv = (TextView) findViewById(R.id.loggedInTextView);
        logoutBtn = (Button) findViewById(R.id.logoutButton);
        previousEventsLv = (ListView) findViewById(R.id.previousEventsListView);
        previousEventsBtn = (Button) findViewById(R.id.previousEventsButton);
        session = new Session(this);

        if (!session.loggedin()) {
            logout();
        }

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        previousEventsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EventModel eventModel = new EventModel();
                eventDatabaseSource = new EventDatabaseSource(MainActivity.this);
                events = eventDatabaseSource.getAllEvents();
                previousEventsAdapter = new PreviousEventsAdapter(MainActivity.this, events);
                previousEventsLv.setAdapter(previousEventsAdapter);
            }
        });



    }

    private void logout() {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this, Login.class));
    }

    public void creatingNewEvent(View view) {
        startActivity(new Intent(MainActivity.this, NewEvent.class));
    }

}
