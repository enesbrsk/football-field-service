package com.example.footballfield.service;

import com.example.footballfield.entity.Appointment;
import com.example.footballfield.entity.User;
import com.example.footballfield.exception.GenericException;
import com.example.footballfield.model.UserDto;
import com.example.footballfield.model.request.AppointmentRequest;
import com.example.footballfield.repository.AppointmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final UserService userService;

    public AppointmentService(AppointmentRepository appointmentRepository, UserService userService) {
        this.appointmentRepository = appointmentRepository;
        this.userService = userService;
    }

    public Appointment create(AppointmentRequest appointmentRequest){

        var startHour = appointmentRequest.getStartDate().toLocalTime().getHour();
        var endHour = appointmentRequest.getEndDate().toLocalTime().getHour();

        if (startHour < endHour && appointmentRequest.getStartDate().getMinute() == 0 && appointmentRequest.getEndDate().getMinute() == 0) {
            final String userName = userService.findUserInContext().getUsername();
            User user = userService.findUserByUsername(userName);
            return appointmentRepository.save(AppointmentRequest.convertToAppointment(appointmentRequest,user));
        }
        throw new GenericException("Girmiş olduğunuz saat aralığı hatalı", HttpStatus.BAD_REQUEST);
    }

    public List<Appointment> getAllAppointment(){
        return appointmentRepository.findAll();
    }
}
