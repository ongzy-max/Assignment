package com.android.example.eventactivity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import com.example.eventdetails.R

class CalendarFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater!!.inflate(R.layout.fragment_calendar, container, false)
        val calendarView: CalendarView = view.findViewById(R.id.calendarView)
        val myDate: TextView = view.findViewById(R.id.myDate)
        

//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()){
//            public void onSelectedDayChnage(CalendarView calenderView, int i, int i1, int i2){
//                String date = (i1 + 1) + "/" + i2 + "/" + i;
//                myDate.setText(date);
//            }
//        }

        calendarView.setOnDateChangeListener {calenderView, i, i2, i3 ->
            val pickData: String = "$i3/$i2/$i"
            myDate.setText(pickData)
        }

        return view
    }



}