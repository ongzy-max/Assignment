package com.example.eventdetails.ui.LoginUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.example.eventdetails.R


class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        val buttonEditProfile : Button = root.findViewById(R.id.buttonEditProfile)
        val textViewName: TextView = root.findViewById(R.id.textViewName)
        val textViewBirthday:TextView = root.findViewById(R.id.textViewBirthday)
        val textViewContact:TextView = root.findViewById(R.id.textViewContact)
        val textViewEmail:TextView = root.findViewById(R.id.textViewEmail)

        val model= ViewModelProviders.of(requireActivity()).get(EditProfileViewModel::class.java)

        model.name.observe(viewLifecycleOwner,
                { o -> textViewName.setText(o!!.toString()) })

        model.birthday.observe(viewLifecycleOwner,
                { o -> textViewBirthday.setText(o!!.toString())  })

        model.contact.observe(viewLifecycleOwner,
                { o -> textViewContact.setText(o!!.toString()) })

        model.email.observe(viewLifecycleOwner,
                { o -> textViewEmail.setText(o!!.toString()) })

        buttonEditProfile.setOnClickListener {
            requireView().findNavController().navigate(R.id.navigation_editProfile)
        }
        setHasOptionsMenu(true)
        return root
    }

}