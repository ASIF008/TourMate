package com.example.alasif.tourmate.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.alasif.tourmate.Fragments.AddBudgetFragment;
import com.example.alasif.tourmate.Fragments.PlacesNearbyFragment;
import com.example.alasif.tourmate.Fragments.ShowbudgetFragment;
import com.example.alasif.tourmate.Fragments.TodaysWeatherFragment;
import com.example.alasif.tourmate.Fragments.WeatherForecastFragment;
import com.example.alasif.tourmate.R;

public class Budget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AddBudgetFragment addBudgetFragment = new AddBudgetFragment();
        fragmentTransaction.add(R.id.showbudgetFragment, addBudgetFragment);
        fragmentTransaction.commit();
    }

    public void move(View view) {
        Fragment fragment;
        if(view.getId()==R.id.addBudgetButton){
            fragment = new AddBudgetFragment();
        }
        else{
            fragment = new ShowbudgetFragment();
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.showbudgetFragment, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
}
