package com.example.eventdetails.ui.LoginUser

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.example.eventdetails.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase


class ProfileFragment : Fragment() {
    private var db = FirebaseDatabase.getInstance().reference
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        val buttonEditProfile : Button = root.findViewById(R.id.buttonEditProfile)
        val buttonSignout : Button = root.findViewById(R.id.buttonSignout)
        val textViewName: TextView = root.findViewById(R.id.textViewName)
        val textViewBirthday:TextView = root.findViewById(R.id.textViewBirthday)
        val textViewContact:TextView = root.findViewById(R.id.textViewContact)
        val textViewEmail:TextView = root.findViewById(R.id.textViewEmail)

        buttonEditProfile.setOnClickListener {
            requireView().findNavController().navigate(R.id.navigation_editProfile)
        }

        buttonSignout.setOnClickListener{
            auth.signOut()
            Toast.makeText(getActivity(), "User signed out", Toast.LENGTH_SHORT).show()
            requireView().findNavController().navigate(R.id.navigation_login)
        }

        val user = auth.currentUser
        if (user != null) {
            val model= ViewModelProviders.of(requireActivity()).get(Communicator2::class.java)

            model.email.observe(viewLifecycleOwner,
                { o -> textViewEmail.setText(o!!.toString()) })

            //var email = model.email.toString()
            //textViewEmail.text = email

            /*db.child("User").child(email).addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val textViewName: TextView = root.findViewById(R.id.textViewName)
                    val textViewBirthday: TextView = root.findViewById(R.id.textViewBirthday)
                    val textViewContact: TextView = root.findViewById(R.id.textViewContact)


                    val name = dataSnapshot.child("Name").getValue(String::class.java)
                    val birthday = dataSnapshot.child("Birthday").getValue(String::class.java)
                    val contact = dataSnapshot.child("Contact").getValue(String::class.java)

                    textViewName.text = name
                    textViewBirthday.text = birthday
                    textViewContact.text = contact

                    Log.d("Get data", "Get value")
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w("Get data", "Failed to read value.", error.toException())
                }
            })*/
        }
        setHasOptionsMenu(true)
        return root
    }
    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if(user == null){
            Toast.makeText(getActivity(), "User not logged in", Toast.LENGTH_SHORT).show()
            requireView().findNavController().navigate(R.id.navigation_login)
        }
    }

}