package com.example.thequiz

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    var quizList = ArrayList<Question>()
    var numCorrectAns: Int = 0
    var currentQuizIndex: Int = 1
    var nickname: String? = null
    var SelectedAnsPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        nickname = intent.getStringExtra(GetQuiz.name)

        quizList = GetQuiz.getQuestions()

        setQuestion()

        //answer1.setOnClickListener(this)
        //answer2.setOnClickListener(this)
        //answer3.setOnClickListener(this)
        //submit.setOnClickListener(this)
    }
    
    
    fun setQuestion() {
        // Getting the question from the list with the help of current position.
        val question = quizList.get(currentQuizIndex - 1)
        if (currentQuizIndex == quizList.size) {
            submit.text = "FINISH"
        } else {
            submit.text = "SUBMIT"
        }

        progressBar.progress = currentQuizIndex
        progress.text = "$currentQuizIndex" + "/" + progressBar.getMax()

        txtQuestion.text = question.ques
        answer1.text = question.ans1
        answer2.text = question.ans2
        answer3.text = question.ans3
    }



    private fun defaultAnswerView() {
        val ans = ArrayList<TextView>()
        ans.add(0, answer1)
        ans.add(1, answer2)
        ans.add(2, answer3)

        for (option in ans) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this@QuizActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    //A function to set the view of selected answer view.
    private fun selectedAnswerView(tv: TextView, selectedAnsNum: Int) {
        defaultAnswerView()
        SelectedAnsPosition = selectedAnsNum

        tv.setTextColor(
            Color.parseColor("#000000")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this@QuizActivity,
            R.drawable.selected_option_border_bg
        )
    }


    fun onClick(v: View?) {

        when (v?.id) {
            R.id.answer1 -> {
                selectedAnswerView(answer1, 1)
            }
            R.id.answer2 -> {
                selectedAnswerView(answer2, 2)
            }
            R.id.answer3 -> {
                selectedAnswerView(answer3, 3)
            }
            R.id.submit -> {
                if (SelectedAnsPosition == 0) {
                    currentQuizIndex++

                    if (currentQuizIndex <= quizList.size) {
                        setQuestion()
                    }else {
                        val intent = Intent(this@QuizActivity, ResultActivity::class.java)
                        intent.putExtra(GetQuiz.name, nickname)
                        intent.putExtra(GetQuiz.CorrectAns, numCorrectAns)
                        intent.putExtra(GetQuiz.totalQues, quizList.size)
                        startActivity(intent)
                        finish()
                    }
                }else {
                    val question = quizList.get(currentQuizIndex - 1)
                    // This is to check if the answer is right or wrong
                    if ( SelectedAnsPosition != question.correctAnsNum) {
                        Toast.makeText(this, "YOU CHOSE POORLY", Toast.LENGTH_SHORT).show()
                    }else if (SelectedAnsPosition == question.correctAnsNum){
                        Toast.makeText(this, "YOU CHOSE WISELY", Toast.LENGTH_SHORT).show()
                        numCorrectAns++
                    }

                    if (currentQuizIndex == quizList.size) {
                        submit.text = "TO RESULT"
                    }else {
                        submit.text = "GO TO NEXT QUESTION"
                    }
                    SelectedAnsPosition = 0
                }
            }
        }
    }
}





