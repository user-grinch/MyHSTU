package com.enan.myhstu.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.enan.myhstu.entity.FacultyDE
import com.enan.myhstu.entity.TeacherDE
import kotlinx.coroutines.flow.Flow

@Dao
interface FacultyDAO {
    @Query("SELECT * FROM faculty")
    fun getAll(): Flow<List<FacultyDE>>
//
//    @Query("SELECT * FROM faculty WHERE f_id = :id")
//    fun getByID(id: Int): Flow<List<FacultyDE>>
}