package com.example.testapp.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class HotelDescription(
    @JsonProperty("description")    val description: String,
    @JsonProperty("peculiarities")  val peculiarities: ArrayList<String>
)
