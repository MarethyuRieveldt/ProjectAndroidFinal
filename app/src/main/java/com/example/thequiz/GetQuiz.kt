package com.example.thequiz

import com.example.thequiz.Question

object GetQuiz {

    val name: String = "user_name"
    val totalQues: String = "total_questions"
    val CorrectAns: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "Which animal can be seen on the Porsche logo?",
            "Horse",
            "Lion",
            "Aligator",
            1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            1, "Who was the first woman to win both Nobel Prize of Chemistry and Physics?",
            "Mary Anning",
            "Marie Curie",
            "Barbara McClintock",
            2
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            1, "What is the name of the largest ocean on earth?",
            "Atlantic",
            "Arctic",
            "Pacific",
            3
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            1, "What country win the most World Cup up to 2018?",
            "Argentina",
            "Brazil",
            "Germany",
            2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            1, "The 'Twenty Rules for Writing Detective Stories' belongs to who?",
            "Ronald Knox",
            "Agatha Christie",
            "S.S Van Dine",
            3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            1, "What is Earth's largest continent?",
            "Europe",
            "Antarctica",
            "Asia",
            3
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            1, "How many states does USA have?",
            "50",
            "51",
            "52",
            1
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            1, "The statement 'While substantial evidence may prove the devil's existence, " +
                    "there is no evidence that denies the devil's existence; " +
                    "therefore, one cannot deny the devil's existence' is called?",
            "There is no such thing!",
            "Devil's Dilemma",
            "Devil's proof",
            3
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            1, "In what type of matter are atoms most tightly packed?",
            "Liquid",
            "Solid",
            "Armenia",
            2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            1, "The franchise Final Fantasy belongs to what company?",
            "Capcom",
            "Bandai Namco",
            "Square Enix",
            3
        )

        questionsList.add(que10)

        return questionsList
    }
}
