package com.enan.myhstu.dao

import androidx.room.Dao
import androidx.room.Query
import com.enan.myhstu.data.ShortNameWithID
import com.enan.myhstu.entity.FacultyDE
import kotlinx.coroutines.flow.Flow

@Dao
interface FacultyDAO {
    @Query("SELECT * FROM faculty")
    fun getAll(): Flow<List<FacultyDE>>

    @Query("SELECT DISTINCT f_short FROM faculty")
    fun getAllShortNames(): Flow<List<String>>

    @Query("SELECT DISTINCT REPLACE(f_short, 'Faculty of ', '') AS shortName, f_id AS id FROM faculty")
    fun getAllShortNamesWithID(): Flow<List<ShortNameWithID>>

    @Query("SELECT DISTINCT REPLACE(f_name, 'Faculty of ', '') FROM faculty")
    fun getFullNames(): Flow<List<String>>
//
//    @Query("SELECT * FROM faculty WHERE f_id = :id")
//    fun getByID(id: Int): Flow<List<FacultyDE>>
}