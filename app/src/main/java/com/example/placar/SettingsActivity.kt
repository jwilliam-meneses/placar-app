package com.example.placar

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.placar.dao.RecordDao
import com.example.placar.model.Record
import java.text.SimpleDateFormat
import java.util.Date

class SettingsActivity : AppCompatActivity() {

    //private val dao = RecordDao()
    lateinit var record: Record

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btnSave = findViewById<Button>(R.id.save)
        btnSave.setOnClickListener {
            record = createRecord()

            Log.i("SettingsActivity", "onCreate: $record")

            val intent = Intent(this, GameActivity::class.java).apply {
                putExtra("RECORD", record)
            }

            startActivity(intent)
        }
    }

    private fun createRecord(): Record {
        val matchNameField = findViewById<EditText>(R.id.match_name)
        val matchName = matchNameField.text.toString()

        val teamName1Field = findViewById<EditText>(R.id.team_name_1)
        val teamName1 = teamName1Field.text.toString()

        val teamName2Field = findViewById<EditText>(R.id.team_name_2)
        val teamName2 = teamName2Field.text.toString()

        val setsField = findViewById<EditText>(R.id.sets)
        val sets = setsField.text.toString().toInt()

        val pointsPerSetField = findViewById<EditText>(R.id.points_per_set)
        val pointsPerSet = pointsPerSetField.text.toString().toInt()

        val sdf = SimpleDateFormat( "dd/MM/yyyy 'at' HH:mm:ss")
        val currentDateTime: String = sdf.format(Date())

        return Record(
            matchName = matchName,
            teamName1 = teamName1,
            teamName2 = teamName2,
            sets = sets,
            pointsPerSet = pointsPerSet,
            dateTime = currentDateTime
        )
    }

}