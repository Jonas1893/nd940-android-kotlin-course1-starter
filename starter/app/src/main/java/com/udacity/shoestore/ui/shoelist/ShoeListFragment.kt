package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeInfoBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var viewModelFactory: ShoeListViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

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

        viewModel.shoes.observe(viewLifecycleOwner, Observer { listShoes ->
            if (listShoes != null) {
                for (shoe in listShoes) {
                    val shoeInfo = ItemShoeInfoBinding.inflate(layoutInflater)
                    shoeInfo.shoe = shoe

                    binding.linearLayout.addView(shoeInfo.root)
                }
            }
        })

        viewModel.eventAddShoe.observe(viewLifecycleOwner, Observer { newEventAddShoe ->
            if (newEventAddShoe) {
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
                viewModel.onAddShoeComplete()
            }
        })

        viewModel.eventLogout.observe(viewLifecycleOwner, Observer { newEventLogout ->
            if (newEventLogout) {
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                viewModel.onLogoutComplete()
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.onLogoutButtonTapped()
        return super.onOptionsItemSelected(item)
    }
}