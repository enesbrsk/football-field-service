package com.example.footballfield.model.response

import com.example.footballfield.entity.Area
import com.example.footballfield.model.AddressDto

data class AreaResponse @JvmOverloads constructor(

    val id: String?,
    val areaName:String,
    val averangePlayer:Int,
    val averangeAudience:Int,
    var addressDto: AddressDto,
    val responseMessage: ResponseMessage

){
    companion object{

        @JvmStatic
        fun convertToAreaResponse(from:Area): AreaResponse {
            return AreaResponse(
                from.id,
                from.areaName,
                from.averangePlayer,
                from.averangeAudience,
                AddressDto.convertToAddressDto(from.address),
                ResponseMessage()
            )
        }

    }

}
