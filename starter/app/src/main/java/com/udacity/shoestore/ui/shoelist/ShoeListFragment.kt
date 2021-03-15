package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var viewModelFactory: ShoeListViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(inflater,
            R.layout.fragment_shoe_list, container, false)

        viewModelFactory = ShoeListViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoeListViewModel::class.java)

        val allShoes: List<Shoe>? = viewModel.shoes.value
        if (allShoes != null) {
            for (shoe in allShoes) {
                
            }
        }

        binding.linearLayout.addView(Button(this.context))

        return binding.root
    }
}