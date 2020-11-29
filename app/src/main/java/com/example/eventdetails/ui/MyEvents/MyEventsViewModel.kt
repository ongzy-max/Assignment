package com.example.eventdetails.ui.MyEvents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyEventsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is myEvent Fragment"
    }
    val text: LiveData<String> = _text
}