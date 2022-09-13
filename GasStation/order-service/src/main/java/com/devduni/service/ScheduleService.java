package com.devduni.service;

import com.devduni.model.Order;
import com.devduni.model.Schedule;
import com.devduni.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        List<Schedule> schedule= (List<Schedule>) scheduleRepository.findAll();
        return schedule;
    }

    public Schedule findById(int id) {
        List<Schedule> list=scheduleRepository.findAll();
        Schedule schedule=new Schedule();
        for(Schedule schdl:list){
            if(schdl.getOrderId()==id){
                schedule.setScheduleId(schdl.getScheduleId());
                schedule.setOrderId(schdl.getOrderId());
                schedule.setDate(schdl.getDate());
            }
        }
        return schedule;
    }


}
