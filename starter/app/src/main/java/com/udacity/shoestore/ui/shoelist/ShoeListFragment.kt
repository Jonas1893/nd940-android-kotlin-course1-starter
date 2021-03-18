package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeInfoBinding

class ShoeListFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,
            R.layout.fragment_shoe_list, container, false
        )

        setHasOptionsMenu(true)

        binding.shoeListViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.shoes.observe(viewLifecycleOwner, Observer { listShoes ->
            binding.linearLayout.removeAllViews()

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
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return if (item.itemId == R.id.logoutMenuItem) {
            viewModel.onLogoutButtonTapped()
            super.onOptionsItemSelected(item)
        } else {
            (NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                    || super.onOptionsItemSelected(item))
        }
    }
}