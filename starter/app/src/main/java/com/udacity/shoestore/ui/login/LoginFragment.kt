package com.udacity.shoestore.ui.login

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)

        setupButtonOnClickListeners(binding)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupButtonOnClickListeners(binding: FragmentLoginBinding) {
        binding.signinButton.setOnClickListener { view: View ->
            navigateToWelcomeScreen(view)
        }

        binding.registerButton.setOnClickListener { view: View ->
            navigateToWelcomeScreen(view)
        }
    }

    private fun navigateToWelcomeScreen(view: View) {
        view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment3)
    }
}