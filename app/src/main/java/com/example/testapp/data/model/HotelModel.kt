package com.example.testapp.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class HotelModel(
    @JsonProperty("id")                 val id: Int,
    @JsonProperty("name")               val name: String,
    @JsonProperty("adress")             val address: String,
    @JsonProperty("minimal_price")      val minimal_price: Int,
    @JsonProperty("price_for_it")       val price_for_it: String,
    @JsonProperty("rating")             val rating: Int,
    @JsonProperty("rating_name")        val rating_name: String,
    @JsonProperty("image_urls")         val image_urls: ArrayList<String>,
    @JsonProperty("about_the_hotel")    val about_the_hotel: HotelDescription
)




