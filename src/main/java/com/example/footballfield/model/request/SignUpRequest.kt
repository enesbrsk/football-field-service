package com.example.footballfield.model.request

data class SignUpRequest @JvmOverloads constructor(

    val username:String,
    val password:String,
    val role:String

)
