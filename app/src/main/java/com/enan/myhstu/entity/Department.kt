package com.enan.myhstu.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "department")
data class DepartmentDE(
    @PrimaryKey
    @ColumnInfo(name = "d_id")
    var dId: Int? = 0,

    @ColumnInfo(name = "d_short")
    var dShort: String? = "",

    @ColumnInfo(name = "d_name")
    var dName: String? = "",

    @ColumnInfo(name = "dpt_order")
    var dptOrder: Int? = 0,

    @ColumnInfo(name = "f_id")
    var fId: Int? = 0
)
