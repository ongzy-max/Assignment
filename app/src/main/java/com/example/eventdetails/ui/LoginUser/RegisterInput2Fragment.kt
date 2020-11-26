package com.example.eventdetails.ui.LoginUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.eventdetails.R

class RegisterInput2 : Fragment() {

    private lateinit var registerInput2ViewModel: RegisterInput2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(false);
        registerInput2ViewModel =
            ViewModelProvider(this).get(RegisterInput2ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_registerinput2, container, false)
        val buttonProfileNext : Button = root.findViewById(R.id.buttonProfileNext)
        buttonProfileNext.setOnClickListener {
            requireView().findNavController().navigate(R.id.navigation_profilePic)
        }
        return root
    }
}