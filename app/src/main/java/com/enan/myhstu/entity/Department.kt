package com.enan.myhstu.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "department")
data class DepartmentDE(
    @ColumnInfo(name = "d_id") @PrimaryKey(autoGenerate = true) val departmentID: Int = 0,
    @ColumnInfo(name = "f_id") val facultyID: Int = 0,
    @ColumnInfo(name = "d_name") val name: String,
    @ColumnInfo(name = "d_short") val shortName: String,
    val dpt_order: Int
)

//{t_id=Column{name='t_id', type='INTEGER', affinity='3', notNull=true, primaryKeyPosition=1, defaultValue='undefined'}, desig=Column{name='desig', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, hphone=Column{name='hphone', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, t_name=Column{name='t_name', type='TEXT', affinity='2', notNull=false, primaryKeyPosition=0, defaultValue='undefined'}, d_id=Column{name='d_id', type='TEXT', affinity='2', notNull=false, primaryKeyPosition=0, defaultValue='undefined'}, mobile=Column{name='mobile', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, ophone=Column{name='ophone', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, f_id=Column{name='f_id', type='TEXT', affinity='2', notNull=false, primaryKeyPosition=0, defaultValue='undefined'}, email=Column{name='email', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, dr=Column{name='dr', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}, username=Column{name='username', type='TEXT', affinity='2', notNull=true, primaryKeyPosition=0, defaultValue='undefined'}}, foreignKeys=[], indices=[]}
