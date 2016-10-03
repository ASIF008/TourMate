package com.example.alasif.tourmate.Model;

/**
 * Created by asif on 9/16/16.
 */
public class EventModel {
    private int id;
    private String eventName, eventStartDate, eventEndDate;

    public EventModel(int id, String eventName, String eventStartDate, String eventEndDate) {
        this.id = id;
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
    }

    public EventModel(String eventName, String eventStartDate, String eventEndDate) {
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
    }

    public EventModel() {
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

/*    public ArrayList<EventModel> getAllEvent(){
        ArrayList<EventModel>teams=new ArrayList<>();
        teams.add(new EventModel("bandorban","10","12"));
        teams.add(new EventModel("chittagong","03","01"));
        return teams;

    }*/

}
