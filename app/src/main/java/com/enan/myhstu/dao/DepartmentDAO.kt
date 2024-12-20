package com.enan.myhstu.dao

import androidx.room.Dao
import androidx.room.Query
import com.enan.myhstu.data.ShortNameWithID
import com.enan.myhstu.entity.DepartmentDE
import kotlinx.coroutines.flow.Flow

@Dao
interface DepartmentDAO {
    @Query("SELECT * FROM department")
    fun getAll(): Flow<List<DepartmentDE>>

    @Query("SELECT DISTINCT d_short FROM department")
    fun getAllShortNames(): Flow<List<String>>

//    @Query("SELECT DISTINCT REPLACE(d_name, 'Dept. of ', '') FROM department WHERE d_name LIKE 'Dept%'")
//    fun getFullNamesSTD(): Flow<List<String>>

    @Query("SELECT DISTINCT REPLACE(d_short, 'Dept. of ', '') AS shortName, d_id AS id FROM department")
    fun getAllShortNamesWithID(): Flow<List<ShortNameWithID>>

    fun getAllShortNamesWithIDOfFaculty(faculty: Int?): Flow<List<ShortNameWithID>> {
        return if (faculty == null) {
            getAllShortNamesWithID()
        } else {
            getAllShortNamesWithIDOfFacultyNonNull(faculty)
        }
    }


    @Query("SELECT DISTINCT REPLACE(d_short, 'Dept. of ', '') AS shortName, d_id AS id FROM department WHERE f_id = :faculty")
    fun getAllShortNamesWithIDOfFacultyNonNull(faculty: Int?): Flow<List<ShortNameWithID>>
//
//    @Query("SELECT * FROM department WHERE d_id = :id")
//    fun getByID(id: Int): Flow<List<DepartmentDE>>
}