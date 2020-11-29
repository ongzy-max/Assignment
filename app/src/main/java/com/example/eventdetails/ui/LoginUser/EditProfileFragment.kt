package com.example.eventdetails.ui.LoginUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.example.eventdetails.R
import com.google.firebase.database.FirebaseDatabase


class EditProfileFragment : Fragment() {
    private var db = FirebaseDatabase.getInstance().reference
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(false);

        val root = inflater.inflate(R.layout.fragment_edit_profile, container, false)
        val root2 = inflater.inflate(R.layout.fragment_profile, container, false)

        val model= ViewModelProviders.of(requireActivity()).get(Communicator2::class.java)

        val textViewName : TextView = root2.findViewById(R.id.textViewName)
        val textViewBirthday : TextView = root2.findViewById(R.id.textViewBirthday)
        val textViewContact : TextView = root2.findViewById(R.id.textViewContact)
        val textViewEmail : TextView = root2.findViewById(R.id.textViewEmail)

        val editTextName: EditText = root.findViewById(R.id.editTextName)
        val editTextBirthday: EditText = root.findViewById(R.id.editTextBirthday)
        val editTextPhone: EditText = root.findViewById(R.id.editTextPhone)
        val editTextProfileEmail: EditText = root.findViewById(R.id.editTextProfileEmail)

        model.name.observe(viewLifecycleOwner,
                { o -> editTextName.setText(o!!.toString()) })

        model.birthday.observe(viewLifecycleOwner,
                { o -> editTextBirthday.setText(o!!.toString())  })

        model.contact.observe(viewLifecycleOwner,
                { o -> editTextPhone.setText(o!!.toString()) })

        model.email.observe(viewLifecycleOwner,
                { o -> editTextProfileEmail.setText(o!!.toString()) })

        val buttonEditProfileDone : Button = root.findViewById(R.id.buttonEditProfileDone)

        buttonEditProfileDone.setOnClickListener {
            Toast.makeText(getActivity(), "Changes saved!", Toast.LENGTH_SHORT).show()
            model!!.setMsgCommunicator(editTextName.text.toString(),editTextBirthday.text.toString(),editTextPhone.text.toString(),editTextProfileEmail.text.toString())

            textViewName.text = editTextName.text
            textViewBirthday.text = editTextBirthday.text
            textViewContact.text = editTextPhone.text
            textViewEmail.text = editTextProfileEmail.text

            //db.setValue(editTextName.text)

            requireView().findNavController().navigate(R.id.navigation_profile)
        }
        return root
    }
}