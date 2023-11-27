package com.example.testapp.data.repository

import com.example.testapp.data.api.HotelsApi
import com.example.testapp.data.api.Retrofit
import com.example.testapp.data.model.HotelModel
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

object HotelsRepository {

    private val hotelsService: HotelsApi
        get() = Retrofit.getClient().create(HotelsApi::class.java)

    fun successfulHotelsResponse(): HotelModel {
        val hotelsResponse = hotelsService.getHotels()
            .execute()
        val successful = hotelsResponse.isSuccessful
        val objectMapper = ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)

        return hotelsResponse.body()!![0]
    }
}