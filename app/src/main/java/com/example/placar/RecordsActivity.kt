package com.example.placar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.placar.dao.RecordDao
import com.example.placar.model.Record
import java.math.BigDecimal

class RecordsActivity : AppCompatActivity() {

    private val dao = RecordDao()
    private val adapter = RecordListAdapter(context = this, records = dao.getAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)
        settingsRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.getAll())
    }

    private fun settingsRecyclerView() {
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }
}