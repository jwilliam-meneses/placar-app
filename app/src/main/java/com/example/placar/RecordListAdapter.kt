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
    records: List<Record>
) : RecyclerView.Adapter<RecordListAdapter.ViewHolder>() {

    private val records = records.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun vincula(record: Record) {
            val dateTime = itemView.findViewById<TextView>(R.id.match_date_time)
            dateTime.text = "Data/Hora: ${record.dateTime}"
            val matchName = itemView.findViewById<TextView>(R.id.match_name)
            matchName.text = "Nome da Partida: ${record.matchName}"
            val matchNameResult = itemView.findViewById<TextView>(R.id.match_result)
            matchNameResult.text = "Sets: ${record.teamName1} ${record.pointsTeam1} x ${record.pointsTeam2} ${record.teamName2}"
            val matchSets = itemView.findViewById<TextView>(R.id.record_item_sets)
            matchSets.text = "Total de Sets: ${record.sets}"
            val matchPoints = itemView.findViewById<TextView>(R.id.record_item_points)
            matchPoints.text = "Pontos por Set: ${record.pointsPerSet}"
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

    fun update(records: List<Record>) {
        this.records.clear()
        this.records.addAll(records)
        notifyDataSetChanged()
    }
}