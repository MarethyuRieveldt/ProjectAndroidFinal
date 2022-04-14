package com.example.thequiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.thequiz.GetQuiz
import com.example.thequiz.MainActivity
import com.example.thequiz.QuizActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val userName = intent.getStringExtra(GetQuiz.name)
        name.text = userName

        val totalQuestions = intent.getIntExtra(GetQuiz.totalQues, 0)
        val correctAnswers = intent.getIntExtra(GetQuiz.CorrectAns, 0)

        score.text = "Your Score is $correctAnswers/$totalQuestions."
    }

    fun finishButton (View:View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

