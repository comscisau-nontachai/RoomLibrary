package com.example.room

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.room.Entity.StudentEntity
import kotlinx.android.synthetic.main.activity_insert.*

class InsertActivity : AppCompatActivity() {

    lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        appDatabase = AppDatabase.getAppDatabase(this)

        btn_insert.setOnClickListener {
            val code = edt_code.text.toString()
            val email = edt_email.text.toString()
            val firstName = edt_firstname.text.toString()
            val lastName = edt_lastname.text.toString()
            val address = edt_address.text.toString()


            val dataStudentEntity = StudentEntity().apply {
                this.code = code
                this.email = email
                this.firstName = firstName
                this.lastName = lastName
                this.address = address
            }

            if (validateInsertData())
                InsertAsyn(dataStudentEntity).execute()
        }
    }

    inner class InsertAsyn(val data: StudentEntity) : AsyncTask<Void, Void, String>() {
        override fun doInBackground(vararg p0: Void?): String {
            appDatabase.StudentDao().insertStudent(data)
            return ""
        }

        override fun onPostExecute(result: String?) {
            finish()
            super.onPostExecute(result)
        }
    }

    private fun validateInsertData(): Boolean {
        if (edt_code.text.toString() != "" && edt_firstname.text.toString() != "" && edt_lastname.text.toString() != ""
            && edt_email.text.toString() != "" && edt_address.text.toString() != ""
        ) {
            return true
        }
        return false
    }
}
