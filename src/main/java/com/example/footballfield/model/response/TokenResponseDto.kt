package com.example.footballfield.model.response

import com.example.footballfield.model.UserDto

data class TokenResponseDto @JvmOverloads constructor(

    val accessToken:String?,
    val user:UserDto
){

}
