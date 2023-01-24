package com.example.footballfield.entity

import com.example.footballfield.enums.Country
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.annotation.Nullable
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator


@Entity
data class Address @JvmOverloads constructor(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",

    @Enumerated(EnumType.STRING)
    val country: Country,
    val city: String,
    val district: String,
    val fullAddress: String,

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    val area:Area?

){
}