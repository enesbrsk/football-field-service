package com.example.footballfield.controller;

import com.example.footballfield.entity.Appointment;
import com.example.footballfield.model.request.AppointmentRequest;
import com.example.footballfield.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody AppointmentRequest appointmentRequest){
        return appointmentService.create(appointmentRequest);
    }

    @GetMapping
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAllAppointment();
    }
}
