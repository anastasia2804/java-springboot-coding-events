package com.example.codingevents.data;

import com.example.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//we created a class of static members
//example of encapsulation - changing this class will have minimum impact on other classes
public class EventData {

    //need a place to put event
    private static final Map<Integer, Event> events = new HashMap<>();
    //get all events
    //Collection is a Java interface that has its specific behavior
    public static Collection<Event> getAll() {
        return events.values();
    }
    //get a single event
    public static Event getById(int id) {
        return events.get(id);
    }
    //add an event
    public static void add(Event event) {
        events.put(event.getId(), event);
    }
    //remove an event
    public static void remove(int id) {
        events.remove(id);
    }
}
