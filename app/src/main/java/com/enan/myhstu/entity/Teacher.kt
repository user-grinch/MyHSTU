package com.enan.myhstu.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teachers")
data class TeacherDE(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "t_id", defaultValue = "")
    var teacherID: Int? = 0,

    @ColumnInfo(name = "f_id", defaultValue = "")
    var facultyID: String? = "",

    @ColumnInfo(name = "d_id", defaultValue = "")
    var departmentID: String? = "",

    @ColumnInfo(name = "t_name", defaultValue = "")
    var name: String? = "",

    @ColumnInfo(name = "desig", defaultValue = "")
    var designation: String? = "",

    @ColumnInfo(name = "mobile", defaultValue = "")
    var mobile: String? = "",

    @ColumnInfo(name = "ophone", defaultValue = "")
    var ophone: String? = "",

    @ColumnInfo(name = "hphone", defaultValue = "")
    var hphone: String? = "",

    @ColumnInfo(name = "email", defaultValue = "")
    var email: String? = "",

    @ColumnInfo(name = "username", defaultValue = "")
    var username: String? = "",

    @ColumnInfo(name = "dr", defaultValue = "")
    var dr: String? = "",
)

