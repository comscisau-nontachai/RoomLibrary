package com.example.room.Dao

import androidx.room.*
import com.example.room.Entity.StudentEntity

@Dao

interface StudentDao {

    @Insert
    fun insertStudent(studentEntity: StudentEntity)

    @Update
    fun updateStudent(studentEntity: StudentEntity)

    @Delete
    fun deleteStudent(studentEntity: StudentEntity)

    @Query("SELECT * FROM student")
    fun getStudentAll() : List<StudentEntity>

    @Query("SELECT * FROM student WHERE student.student_code = :studentCode")
    fun getStudentByCode(studentCode : Int) : List<StudentEntity>

    @Query("SELECT * FROM student WHERE email = :email")
    fun getStudentByEmail(email:String) : List<StudentEntity>

    @Query("DELETE FROM student")
    fun deleteTable()



}
