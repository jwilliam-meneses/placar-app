package com.example.placar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.placar.model.Record

class RecordListAdapter (
    private val context: Context,
    private val records: List<Record>
) : RecyclerView.Adapter<RecordListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(record: Record) {
            val dateTime = itemView.findViewById<TextView>(R.id.match_date_time)
            dateTime.text = record.dateTime
            val matchName = itemView.findViewById<TextView>(R.id.match_name)
            matchName.text = record.matchName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.record_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = records.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val record = records[position]
        holder.vincula(record)
    }
}