package com.example.quiztime

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.btnStart)
        val name : EditText = findViewById(R.id.Name)
        btnStart.setOnClickListener{

            if (name.text.isEmpty()){
                Toast.makeText(this,"Please enter your Name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this,QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,name.text.toString())
                startActivity(intent)
                finish()
            }
        }


    }
}