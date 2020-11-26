package com.example.eventdetails.ui.LoginUser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class EditProfileViewModel : ViewModel(){
    val name = MutableLiveData<Any>()
    val birthday = MutableLiveData<Any>()
    val contact = MutableLiveData<Any>()
    val email = MutableLiveData<Any>()

    fun setMsgCommunicator(msg1:String, msg2:String, msg3:String, msg4:String){
        name.value = msg1
        birthday.value = msg2
        contact.value = msg3
        email.value = msg4
    }
}

