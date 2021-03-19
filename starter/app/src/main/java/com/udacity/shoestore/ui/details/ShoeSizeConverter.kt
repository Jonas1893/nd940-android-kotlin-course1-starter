package com.udacity.shoestore.ui.details

import android.widget.EditText
import androidx.databinding.InverseMethod

object ShoeSizeConverter {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(
        value: Double
    ): String {
        // Converts Double to String.
        return value.toString()
    }

    @JvmStatic fun stringToDouble(
        value: String
    ): Double {
        // Converts String to Double.
        if (value.isNullOrEmpty()) {
            return 0.0
        }

        return value.toDouble()
    }
}