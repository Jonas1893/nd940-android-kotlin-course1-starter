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

    private val _eventAddShoe = MutableLiveData<Boolean>()
    val eventAddShoe: LiveData<Boolean>
        get() = _eventAddShoe

    private val _eventLogout = MutableLiveData<Boolean>()
    val eventLogout: LiveData<Boolean>
        get() = _eventLogout

    init {
        seedShoes()
    }

    fun onAddShoeButtonTapped() {
        _eventAddShoe.value = true
    }

    fun onAddShoeComplete() {
        _eventAddShoe.value = false
    }

    fun onLogoutButtonTapped() {
        _eventLogout.value = true
    }

    fun onLogoutComplete() {
        _eventLogout.value = false
    }

    private fun seedShoes() {
        var shoeList = ArrayList<Shoe>(0)

        val shoe1 = Shoe("Air",
            42.0,
            "Nike",
            "Die Nike Air Technologie besteht aus komprimierter Luft in einer robusten " +
                    "und doch flexiblen Kammer. Sie bietet mehr Flexibilität und Sprungkraft, " +
                    "ohne dabei auf Halt zu verzichten. Die Air-Sole-Elemente behalten dank ihrer " +
                    "Elastizität ihre Form und reduzieren Stöße. Der Schuh bleibt leicht " +
                    "und umschließt den Fuß.")

        val shoe2 = Shoe("Ultraboost",
            43.0,
            "Adidas",
            "Heute schon eine Legende. Als der adidas Ultraboost 2015 sein Debüt feierte, " +
                    "schlug sein innovatives Design auch jenseits der Running-Szene Wellen. Das " +
                    "weiche, gewirkte Obermaterial sorgt für ein atmungsaktives Tragegefühl. " +
                    "Natürlich darf auch die Boost Zwischensohle des Originals nicht fehlen.")

        val shoe3 = Shoe("Club C 85",
            43.0,
            "Reebok",
            "Für lässige Retro-Vibes sorgt der Club C Revenge von Reebok auf alle Fälle! " +
                    "Der Sneaker im angesagten Tennis-Style verfügt nicht nur eine Top-Qualität, " +
                    "sondern auch einen sensationellen Tragekomfort. Perforationslöcher an der " +
                    "Zehenkappe sorgen für eine super Atmungsaktivität, während die gestanzte " +
                    "EVA-Zwischensohle und die dämpfende Einlegesohle ein Garant für eine " +
                    "hervorragende Stoßabsorption sind. Ein echter Eyecatcher bei diesem Classic " +
                    "Modell sind die breiten, kontrastfarbenen Seitenstreifen.")

        val shoe4 = Shoe("Cilia",
            43.0,
            "Puma",
            "Voluminöse Proportionen und ein mit Overlays überzogenes Obermaterial " +
                    "lassen den Cilia wie frisch aus einem Industrial-Dance-Video entsprungen " +
                    "aussehen. Mit seinen zahlreichen Features ist der Cilia definitiv auch ein " +
                    "Schuh für die Tänzerin in dir. Die Kombination aus spritzgegossener " +
                    "EVA-Zwischensohle und SoftFoam+ Einlegesohle sorgt für überragende " +
                    "Dämpfungseigenschaften und weichsten Geh- und Tanzkomfort. Die Laufsohle aus " +
                    "Gummi ist besonders griffig und bietet Traktion auf jedem Untergrund.")

        shoeList.add(shoe1)
        shoeList.add(shoe2)
        shoeList.add(shoe3)
        shoeList.add(shoe4)

        _shoes.value = shoeList
    }
}