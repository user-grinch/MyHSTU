package com.enan.myhstu.dao

import androidx.room.Dao
import androidx.room.Query
import com.enan.myhstu.entity.TeacherDE
import kotlinx.coroutines.flow.Flow

@Dao
interface TeacherDAO {
    @Query("SELECT * FROM teachers")
    fun getAll(): Flow<List<TeacherDE>>

    @Query("SELECT * FROM teachers WHERE f_id IN (:fIds)")
    fun getByFIds(fIds: List<Int>): Flow<List<TeacherDE>>

    fun getAllInIDs(fIds: List<Int>): Flow<List<TeacherDE>> {
        return if (fIds.isEmpty()) {
            getAll()
        } else {
            getByFIds(fIds)
        }
    }

    @Query("SELECT desig FROM teachers")
    fun getDesignations(): Flow<List<String>>

    @Query("SELECT * FROM teachers WHERE f_id = :id")
    fun getFaculties(id: Int): Flow<List<TeacherDE>>

    @Query("SELECT * FROM teachers WHERE d_id = :id")
    fun getDepartments(id: Int): Flow<List<TeacherDE>>
}