package com.example.testapp.data.api

import com.example.testapp.data.model.HotelModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HTTP

interface HotelsApi {
    @HTTP(method = "GET", path = "d144777c-a67f-4e35-867a-cacc3b827473")
    fun getHotels(): Call<ArrayList<HotelModel>>
}