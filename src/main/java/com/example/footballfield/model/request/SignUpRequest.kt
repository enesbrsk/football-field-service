package com.example.footballfield.model.request

import com.example.footballfield.enums.Role

data class SignUpRequest @JvmOverloads constructor(

    val username:String,
    val password:String,
    val role:Role

)
