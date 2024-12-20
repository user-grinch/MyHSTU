package com.enan.myhstu.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.enan.myhstu.dao.DepartmentDAO
import com.enan.myhstu.dao.FacultyDAO
import com.enan.myhstu.dao.TeacherDAO
import com.enan.myhstu.entity.DepartmentDE
import com.enan.myhstu.entity.FacultyDE
import com.enan.myhstu.entity.TeacherDE


@Database(entities = [TeacherDE::class, DepartmentDE::class, FacultyDE::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teacherDao(): TeacherDAO
    abstract fun facultyDao(): FacultyDAO
    abstract fun departmentDAO(): DepartmentDAO

    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "hstu.sqlite")
                    .createFromAsset("hstu.sqlite")
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }
    }
}