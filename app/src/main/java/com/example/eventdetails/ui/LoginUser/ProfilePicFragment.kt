package com.example.eventdetails.ui.LoginUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.eventdetails.R

class ProfilePicFragment : Fragment() {

    private lateinit var profilePicViewModel: ProfilePicViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(false);
        profilePicViewModel =
            ViewModelProvider(this).get(ProfilePicViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profilepic, container, false)
        return root
    }
}