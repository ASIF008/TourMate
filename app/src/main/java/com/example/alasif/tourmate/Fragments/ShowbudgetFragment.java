package com.example.alasif.tourmate.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.alasif.tourmate.CustomAdapters.PreviousEventsAdapter;
import com.example.alasif.tourmate.CustomAdapters.ShowBudgetAdapter;
import com.example.alasif.tourmate.Database.BudgetDatabaseSource;
import com.example.alasif.tourmate.Database.EventDatabaseSource;
import com.example.alasif.tourmate.Model.BudgetModel;
import com.example.alasif.tourmate.Model.EventModel;
import com.example.alasif.tourmate.R;

import java.util.ArrayList;

/**
 * Created by asif on 9/18/16.
 */
public class ShowbudgetFragment extends Fragment {


    private BudgetDatabaseSource budgetDatabaseSource;
    private ShowBudgetAdapter showBudgetAdapter;
    private ListView allBudgetsLv;
    private int loggedInUserId;
    private ArrayList<BudgetModel> budgets;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show_budget_fragment, container, false);


        allBudgetsLv = (ListView) view.findViewById(R.id.allBudgetsListView);
        return view;
    }

}
