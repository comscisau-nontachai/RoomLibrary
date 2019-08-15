package com.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.room.Dao.StudentDao
import com.example.room.Entity.StudentEntity

@Database (entities = [StudentEntity::class],version = 2)
abstract class AppDatabase : RoomDatabase(){

    companion object{
//        private val MIGRATE1_2 : Migration = object : Migration(1,2){
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE student ALTER COLUMN student_code STRING")
//            }
//        }

        fun getAppDatabase(context:Context) : AppDatabase =
            Room.databaseBuilder(context,AppDatabase::class.java,"student").build()
    }

    abstract fun StudentDao() : StudentDao

}