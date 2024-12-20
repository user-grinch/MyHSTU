package com.enan.myhstu.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "faculty")
data class FacultyDE(
    @ColumnInfo(name = "f_id") @PrimaryKey(autoGenerate = true) val facultyID: Int = 0,
    @ColumnInfo(name = "f_name") val name: String,
    @ColumnInfo(name = "f_short") val shortName: String,
)