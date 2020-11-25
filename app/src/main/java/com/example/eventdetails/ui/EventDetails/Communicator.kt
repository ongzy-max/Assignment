package com.example.eventdetails.ui.EventDetails


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Communicator : ViewModel(){


    val title = MutableLiveData<Any>()
    val date = MutableLiveData<Any>()
    val time = MutableLiveData<Any>()
    val location = MutableLiveData<Any>()
    val phoneNum = MutableLiveData<Any>()
    val desc = MutableLiveData<Any>()


    fun setMsgCommunicator(msg1:String, msg2:String, msg3:String, msg4:String, msg5:String, msg6:String){
        title.value = msg1
        date.value = msg2
        time.value = msg3
        location.value = msg4
        phoneNum.value = msg5
        desc.value = msg6
    }
}