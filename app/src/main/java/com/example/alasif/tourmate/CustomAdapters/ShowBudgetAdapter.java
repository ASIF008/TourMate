package com.example.alasif.tourmate.CustomAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alasif.tourmate.Model.BudgetModel;
import com.example.alasif.tourmate.R;

import java.util.ArrayList;

/**
 * Created by asif on 10/15/16.
 */

public class ShowBudgetAdapter extends ArrayAdapter<BudgetModel> {
    private Context context;
    private ArrayList<BudgetModel> budgets;


    private class ViewHolder{
        TextView costDescriptionTv,amountTv;
    }


    public ShowBudgetAdapter(Context context, ArrayList<BudgetModel> budgets) {
        super(context, R.layout.custom_layout_for_budgets,budgets);
        this.context = context;
        this.budgets = budgets;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.custom_layout_for_budgets,null,true);
            viewHolder=new ViewHolder();
            viewHolder.costDescriptionTv = (TextView) convertView.findViewById(R.id.budgetDescriptionTextView);
            viewHolder.amountTv = (TextView) convertView.findViewById(R.id.amountTextView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.costDescriptionTv.setText(budgets.get(position).getCostDescription());
        viewHolder.amountTv.setText(budgets.get(position).getAmount());
        return convertView;
    }
}
