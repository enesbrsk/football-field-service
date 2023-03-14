package com.example.footballfield.model.request

import com.example.footballfield.entity.Appointment
import com.example.footballfield.entity.User
import java.time.LocalDateTime

data class AppointmentRequest @JvmOverloads constructor(
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
){
    companion object{

        @JvmStatic
        fun convertToAppointment(from: AppointmentRequest,user: User):Appointment{
            return Appointment(
                null,
                user,
                from.startDate,
                from.endDate
            )
        }

    }
}