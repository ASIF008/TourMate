package com.example.alasif.tourmate.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    //SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loggedinTv = (TextView) findViewById(R.id.loggedInTextView);
        logoutBtn = (Button) findViewById(R.id.logoutButton);
        previousEventsLv = (ListView) findViewById(R.id.previousEventsListView);
        previousEventsBtn = (Button) findViewById(R.id.previousEventsButton);

        session = new Session(MainActivity.this);

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

                eventDatabaseSource = new EventDatabaseSource(MainActivity.this);
                //SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("TourMate",getApplicationContext().MODE_PRIVATE);
//                int a = 0;
//                a = sharedPreferences.getInt("userId",1);
                int a = getIntent().getIntExtra("userId", 0);
                String currentUserId = String.valueOf(a);
                events = eventDatabaseSource.getAllEvents(currentUserId);
                previousEventsAdapter = new PreviousEventsAdapter(MainActivity.this, events);
                previousEventsLv.setAdapter(previousEventsAdapter);
                Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_LONG).show();
            }
        });

//        int userId = sharedPreferences.getInt("userId", -1);
//        Toast.makeText(this,String.valueOf(userId),Toast.LENGTH_LONG).show();

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
