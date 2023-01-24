package com.example.footballfield.model

import com.example.footballfield.entity.Address
import com.example.footballfield.enums.Country

data class AddressDto @JvmOverloads constructor(
    val country: Country,
    val city: String,
    val district: String,
    val fullAddress: String,
)
{
    companion object{

        @JvmStatic
        fun convertToAddress(from:AddressDto): Address {
            return Address(
                null,
                from.country,
                from.city,
                from.district,
                from.fullAddress,
                null
            )
        }

        @JvmStatic
        fun convertToAddressDto(from:Address): AddressDto {
            return AddressDto(
                from.country,
                from.city,
                from.district,
                from.fullAddress,
                )
        }
    }
}