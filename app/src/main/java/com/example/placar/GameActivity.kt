package com.example.placar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.placar.dao.RecordDao
import com.example.placar.model.Record
import com.google.android.material.snackbar.Snackbar

class GameActivity : AppCompatActivity() {
    private var totalSet = 0
    private var win = false
    lateinit var record: Record
    private val dao = RecordDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        record = getIntent().getExtras()?.getSerializable("RECORD") as Record

        val matchNameField = findViewById<TextView>(R.id.activity_game_match_name)
        matchNameField.text = record.matchName

        val teamNameField = findViewById<TextView>(R.id.activity_game_team_name)
        teamNameField.text = "${record.teamName1} x ${record.teamName2}"

        val buttonAddTeam1 = findViewById<Button>(R.id.activity_game_btn_add_point_team_1)
        buttonAddTeam1.setOnClickListener {
            record.pointsTeam1 = record.pointsTeam1.toInt() + 1

            // Atualiza scoreboard
            updateScoreboard()

            // Verifica se há vitoria de set
            if (record.pointsTeam1 == record.pointsPerSet) {
                record.setsTeam1 = record.setsTeam1.toInt() + 1
                totalSet++

                updateSetboard()

                // Verifica se alcançou o número de sets definido
                if (totalSet == record.sets) {
                    Log.i("GameActivity", "onCreate: Team 1 Win")
                } else {
                    // Zera a pontuação
                    resetScore()
                }
            }
        }

        val buttonRemoveTeam1 = findViewById<Button>(R.id.activity_game_btn_remove_point_team_1)
        buttonRemoveTeam1.setOnClickListener {
            if (record.pointsTeam1.toInt() > 0) {
                record.pointsTeam1 = record.pointsTeam1.toInt() - 1
            }

            // Atualiza scoreboard
            updateScoreboard()
        }

        val buttonAddTeam2 = findViewById<Button>(R.id.activity_game_btn_add_point_team_2)
        buttonAddTeam2.setOnClickListener {
            record.pointsTeam2 = record.pointsTeam2.toInt() + 1

            // Atualiza scoreboard
            updateScoreboard()

            // Verifica se há vitoria de set
            if (record.pointsTeam2 == record.pointsPerSet) {
                record.setsTeam2 = record.setsTeam2.toInt() + 1
                totalSet++

                updateSetboard()

                // Verifica se alcançou o número de sets definido
                if (totalSet == record.sets) {
                    Log.i("GameActivity", "onCreate: Team 2 Win")
                } else {
                    // Zera a pontuação
                    resetScore()
                }
            }
        }

        val buttonRemoveTeam2 = findViewById<Button>(R.id.activity_game_btn_remove_point_team_2)
        buttonRemoveTeam2.setOnClickListener {
            if (record.pointsTeam2.toInt() > 0) {
                record.pointsTeam2 = record.pointsTeam2.toInt() - 1
            }

            // Atualiza scoreboard
            updateScoreboard()
        }

        val buttonFinish = findViewById<Button>(R.id.activity_game_btn_finish)
        buttonFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onPause() {
        super.onPause()

        dao.add(record)
        Log.i("GameActivity", "onPause: ${dao.getAll()}")
    }
    private fun updateSetboard() {
        val setboard = findViewById<TextView>(R.id.activity_game_sets)
        setboard.text = "${record.setsTeam1} | ${record.setsTeam2}"
    }

    private fun resetScore() {
        record.pointsTeam1 = 0
        record.pointsTeam2 = 0

        updateScoreboard()
    }

    private fun updateScoreboard(): TextView? {
        val scoreboard = findViewById<TextView>(R.id.activity_game_scoreboard)
        scoreboard.text = "${record.pointsTeam1} x ${record.pointsTeam2}"
        return scoreboard
    }
}