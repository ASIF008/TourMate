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

    private TextView loggedinTv;
    private Button logoutBtn;
    private Session session;
    private int currentLoggedInUserId;
    private String lastNameOfLoggedInUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loggedinTv = (TextView) findViewById(R.id.loggedInTextView);
        logoutBtn = (Button) findViewById(R.id.logoutButton);
        currentLoggedInUserId =getIntent().getIntExtra("userId", 0);
        lastNameOfLoggedInUser = getIntent().getStringExtra("userLastName");

        loggedinTv.setText("Welcome "+lastNameOfLoggedInUser);
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

    public void previousEvents(View view) {
        Intent intent = new Intent(MainActivity.this, PreviousEvents.class);
        intent.putExtra("loggedInUser",currentLoggedInUserId);
        startActivity(intent);
    }
}
