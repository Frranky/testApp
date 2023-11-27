package com.example.testapp.ui.hotel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.testapp.data.model.HotelModel
import com.example.testapp.data.repository.HotelsRepository
import com.example.testapp.databinding.FragmentHotelBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HotelViewModel(
    private val binding: FragmentHotelBinding
) : ViewModel() {

    private lateinit var hotelData: HotelModel

    init {
        GlobalScope.launch {
            hotelData = HotelsRepository.successfulHotelsResponse()
            val imageList = ArrayList<SlideModel>().apply {
                for (img in hotelData.image_urls)
                    this.add(SlideModel(img))
            }

            launch(Dispatchers.Main) {
                binding.imageSlider.setImageList(imageList, ScaleTypes.FIT)
                binding.rating.text = "  ★ ${hotelData.rating} ${hotelData.rating_name}  "
                binding.name.text = hotelData.name
                binding.address.text = hotelData.address
                binding.price.text = "от ${hotelData.minimal_price}"
                binding.priceDescription.text = hotelData.price_for_it
            }
        }
    }
}