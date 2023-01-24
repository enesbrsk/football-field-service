package com.example.footballfield.model

import com.example.footballfield.entity.Area
import java.time.LocalDateTime

data class AreaRequest @JvmOverloads constructor(

    val areaName:String,
    val averangePlayer:Int,
    val averangeAudience:Int,
    var addressDto: AddressDto

){
    companion object{

        @JvmStatic
        fun convertToArea(from:AreaRequest):Area{
            return Area(
                null,
                from.areaName,
                from.averangePlayer,
                from.averangeAudience,
                LocalDateTime.now(),
                AddressDto.convertToAddress(from.addressDto)
            )
        }

    }

}
