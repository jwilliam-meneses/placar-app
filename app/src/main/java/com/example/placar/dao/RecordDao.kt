package com.example.placar.dao

import com.example.placar.model.Record

class RecordDao {
    fun add(record: Record) {
        records.add(record)
    }

    fun getAll(): List<Record> {
        return records.toList()
    }

    companion object {
        private val records = mutableListOf<Record>()
    }
}