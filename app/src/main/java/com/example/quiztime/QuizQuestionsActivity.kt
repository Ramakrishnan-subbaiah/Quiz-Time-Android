package com.example.quiztime

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList:ArrayList<Question>? = null
    private var mSelectedOption: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int =  0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName= intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progressBar)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.flag)
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)
        btnSubmit = findViewById(R.id.btnSubmit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)

        btnSubmit?.setOnClickListener(this)
        mQuestionsList = Constants.getQuestions()

        setQuestion()

    }

    private fun setQuestion() {

        defaultOptionsView()

        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if (mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text ="FINISH"
        }else{
            btnSubmit?.text="SUBMIT"
        }
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.tv_background)
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum: Int){

        mSelectedOption = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOptionOne ->{
                tvOptionOne?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.tvOptionTwo ->{
                tvOptionTwo?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.tvOptionThree ->{
                tvOptionThree?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.tvOptionFour ->{
                tvOptionFour?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.btnSubmit ->{
               if (mSelectedOption == 0){
                   mCurrentPosition++
                   when{
                       mCurrentPosition <= mQuestionsList!!.size ->{
                           setQuestion()
                       }
                       else->{
                           val intent = Intent(this,ResultActivity::class.java)
                           intent.putExtra(Constants.USER_NAME,mUserName)
                           intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                           intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                           startActivity(intent)
                           finish()

                       }
                   }

               }else{
                   val question = mQuestionsList?.get(mCurrentPosition -1)
                   if (question!!.correctOption != mSelectedOption){
                       answerView(mSelectedOption,R.drawable.wrong_option)
                   }else{
                       mCorrectAnswers++
                   }
                   answerView(question.correctOption,R.drawable.correct_option)

                   if (mCurrentPosition == mQuestionsList!!.size){
                       btnSubmit?.text="FINISH"
                   }
                   else{
                       btnSubmit?.text ="GO TO NEXT QUESTION"
                   }
                   mSelectedOption=0
               }
            }
        }
    }
    private fun answerView(answer: Int,drawableView: Int){
        when(answer){
            1->{
                tvOptionOne?.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tvOptionTwo?.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                tvOptionThree?.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                tvOptionFour?.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}