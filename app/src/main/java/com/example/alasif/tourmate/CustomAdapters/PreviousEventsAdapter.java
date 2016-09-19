package com.example.alasif.tourmate.CustomAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alasif.tourmate.Model.EventModel;
import com.example.alasif.tourmate.R;

import java.util.ArrayList;

/**
 * Created by asif on 9/18/16.
 */
public class PreviousEventsAdapter extends ArrayAdapter<EventModel> {
    private Context context;
    private ArrayList<EventModel>events;

    private class ViewHolder{
        TextView eventPlaceTv,eventStartDateTv,eventEndDateTv;
    }

    public PreviousEventsAdapter(Context context, ArrayList<EventModel> events) {
        super(context, R.layout.custom_layout_for_previous_events,events);
        this.context=context;
        this.events=events;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.custom_layout_for_previous_events,null,true);
            viewHolder=new ViewHolder();
            viewHolder.eventPlaceTv= (TextView) convertView.findViewById(R.id.placesOfPreviousEventsTextView);
            viewHolder.eventStartDateTv= (TextView) convertView.findViewById(R.id.startDateOfPreviousEventsTextView);
            viewHolder.eventEndDateTv= (TextView) convertView.findViewById(R.id.endDateOfPreviousEventsTextView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.eventPlaceTv.setText(events.get(position).getEventName());
        viewHolder.eventStartDateTv.setText(events.get(position).getEventStartDate());
        viewHolder.eventEndDateTv.setText(events.get(position).getEventEndDate());
        return convertView;
    }
}
