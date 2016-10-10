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
import com.example.alasif.tourmate.Database.RegisterDatabaseSource;
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
    private int currentLoggedInUserId;
    private String lastNameOfLoggedInUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentLoggedInUserId =getIntent().getIntExtra("userId", 0);

        loggedinTv = (TextView) findViewById(R.id.loggedInTextView);
        logoutBtn = (Button) findViewById(R.id.logoutButton);
        previousEventsLv = (ListView) findViewById(R.id.previousEventsListView);
        previousEventsBtn = (Button) findViewById(R.id.previousEventsButton);

        session = new Session(MainActivity.this);

        if (!session.loggedin()) {
            logout();
        }

        lastNameOfLoggedInUser = getIntent().getStringExtra("userLastName");

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

                String currentUserId = String.valueOf(currentLoggedInUserId);
                events = eventDatabaseSource.getAllEvents(currentUserId);
                previousEventsAdapter = new PreviousEventsAdapter(MainActivity.this, events);
                previousEventsLv.setAdapter(previousEventsAdapter);
                Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_LONG).show();
            }
        });

       loggedinTv.setText("Welcome "+lastNameOfLoggedInUser);

    }


    private void logout() {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this, Login.class));
    }

    public void creatingNewEvent(View view) {
        Intent intent = new Intent(MainActivity.this, NewEvent.class);
        intent.putExtra("loggedInUser", currentLoggedInUserId);
        startActivity(intent);
    }


}
