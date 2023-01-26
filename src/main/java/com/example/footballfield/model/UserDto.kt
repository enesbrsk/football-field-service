package com.example.footballfield.model

import com.example.footballfield.entity.Address
import com.example.footballfield.entity.User
import com.example.footballfield.enums.Role

data class UserDto @JvmOverloads constructor(

    val id:String?,
    val username:String?,
    val role:Role?
) {

    companion object{
        @JvmStatic
        fun converToUserDto(from:User): UserDto {
            return UserDto(
                from.id,
                from.username,
                from.role
            )
        }

    }
}
