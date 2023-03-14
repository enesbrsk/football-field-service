package com.example.footballfield.entity

import com.example.footballfield.enums.Country
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.Check
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime

@Entity
data class Appointment @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime

){
    @Check(constraints = "EXTRACT(MINUTE FROM startTime) = 0")
    fun checkStartMinute(): Boolean = true

    @Check(constraints = "EXTRACT(MINUTE FROM endTime) = 0")
    fun checkEndMinute(): Boolean = true

}