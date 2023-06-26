package com.example.placar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.placar.model.Record

class GameActivity : AppCompatActivity() {
    lateinit var record: Record

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        record = getIntent().getExtras()?.getSerializable("RECORD") as Record

        Log.i("GameActivity", "onCreate: $record")

        val matchNameField = findViewById<TextView>(R.id.activity_game_match_name)
        matchNameField.text = record.matchName

        val teamName1Field = findViewById<TextView>(R.id.activity_game_team_name_1)
        teamName1Field.text = record.teamName1

        val teamName2Field = findViewById<TextView>(R.id.activity_game_team_name_2)
        teamName2Field.text = record.teamName2

        val buttonAddTeam1 = findViewById<Button>(R.id.activity_game_btn_add_point_team_1)
        buttonAddTeam1.setOnClickListener {
            Log.i("GameActivity", "onCreate: Clicked 1")

            var pointsTeam1 = record.pointsTeam1.toInt() + 1
            var pointsTeam2 = record.pointsTeam2

            record.pointsTeam1 = pointsTeam1

            Log.i("GameActivity", "onCreate: $record")

            val scoreboard = findViewById<TextView>(R.id.activity_game_scoreboard)
            scoreboard.text = "$pointsTeam1 x $pointsTeam2"
        }

        val buttonAddTeam2 = findViewById<Button>(R.id.activity_game_btn_add_point_team_2)
        buttonAddTeam2.setOnClickListener {
            Log.i("GameActivity", "onCreate: Clicked 2")

            var pointsTeam1 = record.pointsTeam1
            var pointsTeam2 = record.pointsTeam2.toInt() + 1

            record.pointsTeam2 = pointsTeam2
            Log.i("GameActivity", "onCreate: $record")

            val scoreboard = findViewById<TextView>(R.id.activity_game_scoreboard)
            scoreboard.text = "$pointsTeam1 x $pointsTeam2"
        }
    }
}