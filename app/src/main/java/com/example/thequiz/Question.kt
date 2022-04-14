package com.example.thequiz

data class Question(
    val index: Int,
    val ques: String,
    val ans1: String,
    val ans2: String,
    val ans3: String,
    val correctAnsNum: Int
)
