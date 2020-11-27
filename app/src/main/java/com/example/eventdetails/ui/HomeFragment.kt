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
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.eventdetails.R.id.navigation_eventMain

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val buttonVolunteer : Button = root.findViewById(R.id.buttonVolunteer)
        buttonVolunteer.setOnClickListener {
            findNavController().navigate(navigation_eventMain)
        }
/*        requireView().findViewById<Button>(R.id.buttonOrganize).setOnClickListener {
            requireView().findNavController().navigate(R.id.fragment_create_event)
        }*/
        return root
    }

}