package com.example.quiztime

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String="total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,"What Country this flag belongs to?",
            R.drawable.ic_flag_of_fiji,"Turkey","Fiji","Mongolia","GreenLand",
            2
        )
        questionList.add(que1)
        val que2 = Question(
            1,"What Country this flag belongs to?",
            R.drawable.ic_flag_of_kuwait,"Kuwait","East Africa","Ireland","Turkey",
            1
        )
        questionList.add(que2)
        val que3 = Question(
            1,"What Country this flag belongs to?",
            R.drawable.ic_flag_of_germany,"Netherlands","Germany","Belgium","Japan",
            2
        )
        questionList.add(que3)
        val que4 = Question(
            1,"What Country this flag belongs to?",
            R.drawable.ic_flag_of_india,"Ireland","Burma","India","Ethiopia",
            3
        )
        questionList.add(que4)
        val que5 = Question(
            1,"What Country this flag belongs to?",
            R.drawable.ic_flag_of_argentina,"Scotland","Mexico","Argentina","Japan",
            3
        )
        questionList.add(que5)
        val que6 = Question(
            1,"What Country this flag belongs to?",
            R.drawable.ic_flag_of_new_zealand,"Iceland","Korea","Australia","New Zealand",
            4
        )
        questionList.add(que6)
        val que7 = Question(
            1,"What Country this flag belongs to?",
            R.drawable.ic_flag_of_brazil,"Spain","Portugal","Brazil","Sri Lanka",
            3
        )
        questionList.add(que7)
        val que8 = Question(
            1,"What Country this flag belongs to?",
            R.drawable.ic_flag_of_belgium,"Bali","Belgium","Morocco","Rio",
            2
        )
        questionList.add(que8)
        val que9 = Question(
            1,"What Country this flag belongs to?",
            R.drawable.ic_flag_of_australia,"New Zealand","United Kingdom","Canada","Australia",
            4
        )
        questionList.add(que9)

        return questionList
    }
}