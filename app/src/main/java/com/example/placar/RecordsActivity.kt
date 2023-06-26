package com.example.placar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.placar.model.Record
import java.math.BigDecimal

class RecordsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        recyclerView.adapter = RecordListAdapter(context = this, records = listOf(
//            Record(
//                dateTime = "25/06 22:05",
//                name = "Amistoso",
//                result = "Time A 2 x 3 Time B"
//            ),
//            Record(
//                dateTime = "25/06 22:20",
//                name = "Clássico",
//                result = "Fortaleza 5 x 0 Ceará"
//            ),
//            Record(
//                dateTime = "25/06 23:35",
//                name = "Entre Amigos",
//                result = "Time Breno 4 x 1 Time Inácio"
//            )
//        ))
    }
}