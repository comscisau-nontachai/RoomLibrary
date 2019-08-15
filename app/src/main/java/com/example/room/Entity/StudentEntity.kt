package com.example.room.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "student")
data class StudentEntity(@PrimaryKey(autoGenerate = true) var id : Int? = null,
                         @ColumnInfo(name = "student_code") var code:String ? =null,
                         @ColumnInfo(name = "first_name") var firstName : String? = null,
                         @ColumnInfo(name = "last_name") var lastName:String? = null,
                         var email : String? = null,
                         var gender : String? =null,
                         var address : String? =null)

@Entity (tableName = "student_score")
data class StudentScoreEntity(@PrimaryKey(autoGenerate = true) var id : Int? =null,
                              @ColumnInfo(name = "keep_score") var KeepScore : Int? = null,
                              @ColumnInfo(name = "mid_score") var MidScore : Int? = null,
                              @ColumnInfo(name = "final_score") var FinalScore : Int? = null,
                              @ColumnInfo(name = "student_code") var studentCode : Long? = null

)

