package com.devduni.controller;

import com.devduni.model.Schedule;
import com.devduni.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderStatus")
public class OrderStatusController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/allId")
    public Schedule getAllSchedulesById(@RequestParam int id){
        return scheduleService.findById(id);

    }

    @GetMapping("/all")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }






}
