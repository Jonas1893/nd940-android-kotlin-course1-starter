package com.udacity.shoestore.ui.shoelist

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes

    init {
        var shoeList = ArrayList<Shoe>(0)
        val shoe1Images = ArrayList<Image>(0)

        val shoe1 = Shoe("Air",
            42.0,
            "Nike",
            "Die Nike Air Technologie besteht aus komprimierter Luft in einer robusten " +
                    "und doch flexiblen Kammer. Sie bietet mehr Flexibilität und Sprungkraft, " +
                    "ohne dabei auf Halt zu verzichten. Die Air-Sole-Elemente behalten dank ihrer " +
                    "Elastizität ihre Form und reduzieren Stöße. Der Schuh bleibt leicht " +
                    "und umschließt den Fuß.")

        shoeList.add(shoe1)

        _shoes.value = shoeList
    }
}