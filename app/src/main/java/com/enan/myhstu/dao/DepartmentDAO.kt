package com.enan.myhstu.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.enan.myhstu.entity.DepartmentDE
import com.enan.myhstu.entity.TeacherDE
import kotlinx.coroutines.flow.Flow

@Dao
interface DepartmentDAO {
    @Query("SELECT * FROM department")
    fun getAll(): Flow<List<DepartmentDE>>

    @Query("SELECT DISTINCT d_short FROM department WHERE d_short LIKE 'Dept%'")
    fun getAllShortNames(): Flow<List<String>>
//
//    @Query("SELECT * FROM department WHERE d_id = :id")
//    fun getByID(id: Int): Flow<List<DepartmentDE>>
}