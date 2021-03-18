package com.udacity.shoestore.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.shoelist.ShoeListViewModel
import timber.log.Timber

class ShoeDetailsFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()
    private var newShoe: Shoe = Shoe("", 0.0, "", description = "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater,
            R.layout.fragment_shoe_details, container, false
        )

        Timber.d(viewModel.shoes.value?.count().toString())

        binding.saveButton.setOnClickListener {
            if (newShoe.name.isNotEmpty() &&
                newShoe.company.isNotEmpty() &&
                newShoe.size > 0 &&
                newShoe.description.isNotEmpty()) {

                Timber.d("Adding shoe" + newShoe)
                viewModel.addShoe(newShoe)

                Timber.d(viewModel.shoes.value?.count().toString())
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
            } else {
                Timber.e("Validation failed" + newShoe.name + newShoe.description + newShoe.company)
                sendValidationToast()
            }
        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }

        binding.shoe = newShoe

        return binding.root
    }

    private fun sendValidationToast() {
        Toast.makeText(requireView().context, "Please fill out all forms to add a new Shoe", Toast.LENGTH_LONG).show()
    }
}