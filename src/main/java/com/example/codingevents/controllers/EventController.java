package com.example.codingevents.controllers;

import com.example.codingevents.data.EventData;
import com.example.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", EventData.getAll()); //EventData.getAll is calling a method on the class
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription) {
        EventData.add(new Event(eventName, eventDescription));
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required =false) int[] eventIds) {
        if (eventIds !=null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:/events";
    }

}