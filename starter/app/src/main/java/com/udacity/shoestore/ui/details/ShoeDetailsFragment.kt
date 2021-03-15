package com.udacity.shoestore.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.ui.shoelist.ShoeListViewModel

class ShoeDetailsFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater,
            R.layout.fragment_shoe_details, container, false
        )

        return binding.root
    }
}