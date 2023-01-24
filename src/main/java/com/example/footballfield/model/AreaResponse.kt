package com.example.footballfield.model

import com.example.footballfield.entity.Area

data class AreaResponse @JvmOverloads constructor(

    val id: String?,
    val areaName:String,
    val averangePlayer:Int,
    val averangeAudience:Int,
    var addressDto: AddressDto

){
    companion object{

        @JvmStatic
        fun convertToAreaResponse(from:Area): AreaResponse {
            return AreaResponse(
                from.id,
                from.areaName,
                from.averangePlayer,
                from.averangeAudience,
                AddressDto.convertToAddressDto(from.address)
            )
        }

    }

}
