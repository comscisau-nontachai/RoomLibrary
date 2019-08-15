package com.example.room

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room.Entity.StudentEntity
import com.example.room.Entity.StudentScoreEntity
import kotlinx.android.synthetic.main.activity_main.*
const val TAG = "TAG"
class MainActivity : AppCompatActivity() {

    lateinit var appDatabase: AppDatabase
    var studentAdapter : StudentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_student.layoutManager = LinearLayoutManager(applicationContext)
        studentAdapter = StudentAdapter(this)
        rv_student.adapter = studentAdapter

        appDatabase = AppDatabase.getAppDatabase(this)

        btn_delete_data.setOnClickListener { deleteAllStudent().execute() }

        btn_insert_activity.setOnClickListener {
            startActivity(Intent(this,InsertActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

        backgroundTask().execute()
    }

    inner class backgroundTask : AsyncTask<Void, Void, List<StudentEntity>>() {
        private var list: List<StudentEntity> = listOf()

        override fun doInBackground(vararg p0: Void?): List<StudentEntity> {
            list = appDatabase.StudentDao().getStudentAll()
            return list
        }

        override fun onPostExecute(result: List<StudentEntity>) {
            studentAdapter?.updateStudent(result)
            super.onPostExecute(result)
        }
    }

    inner class deleteAllStudent : AsyncTask<Void,Void,String>(){

        override fun doInBackground(vararg p0: Void?): String? {
            appDatabase.StudentDao().deleteTable()
            return ""
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }

    }


}
