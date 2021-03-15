package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var viewModelFactory: ShoeListViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,
            R.layout.fragment_shoe_list, container, false
        )

        viewModelFactory = ShoeListViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = viewModel
        binding.lifecycleOwner = this

        val allShoes: List<Shoe>? = viewModel.shoes.value
        if (allShoes != null) {
            for (shoe in allShoes) {
                val valueTV = TextView(this.context)
                valueTV.text = "hallo hallo"
                binding.linearLayout.addView(valueTV)
            }
        }

        viewModel.eventAddShoe.observe(viewLifecycleOwner, Observer { newEventAddShoe ->
            if (newEventAddShoe) {
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
                viewModel.onAddShoeComplete()
            }
        })

        return binding.root
    }
}