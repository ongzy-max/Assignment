package com.android.example.eventactivity.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.eventdetails.R

class RecyclerAdapter(private var eventTitle: List<String>, private var eventDate: List<String>,
                      private var eventDuration: List<String>, private var eventLocation: List<String>,
                      private var eventContact: List<String>) :
        RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.textView10)
        val itemDate: TextView = itemView.findViewById(R.id.textView6)
        val itemDuration: TextView = itemView.findViewById(R.id.textView7)
        val itemLocation: TextView = itemView.findViewById(R.id.textView8)
        val itemContact: TextView = itemView.findViewById(R.id.textView9)

        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You click on item # ${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycle_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = eventTitle[position]
        holder.itemDate.text = eventDate[position]
        holder.itemDuration.text = eventDuration[position]
        holder.itemLocation.text = eventLocation[position]
        holder.itemContact.text = eventContact[position]
    }

    override fun getItemCount(): Int {
        return eventTitle.size
    }
}
