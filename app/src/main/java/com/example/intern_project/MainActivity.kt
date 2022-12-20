package com.example.intern_project

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    //all questions list
    private var Name:String?=null
    private var score:Int=0

    private var currentPosition:Int=1
    private var questionList:ArrayList<QuestionData> ? = null
    private var selecedOption:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val handler=Handler()

        //set questions that are designed in other class
        Name=intent.getStringExtra(setData.name)

        questionList=setData.getQuestion()

        setQuestion()

        opt_1.setOnClickListener{

            selectedOptionStyle(opt_1,1)
        }
        opt_2.setOnClickListener{

            selectedOptionStyle(opt_2,2)
        }
        opt_3.setOnClickListener{

            selectedOptionStyle(opt_3,3)
        }
        opt_4.setOnClickListener{

            selectedOptionStyle(opt_4,4)
        }

        submit.setOnClickListener {
            if(selecedOption!=0)
            {
                val question=questionList!![currentPosition-1]
                if(selecedOption!=question.correct_ans)
                {
                    setColor(selecedOption,R.drawable.wrong_question_option)
                }else{
                    score++;
                }
                setColor(question.correct_ans,R.drawable.correct_question_option)

                handler.postDelayed({
                    if(currentPosition==questionList!!.size) {
                        submit.text = "FINISH"
                        opt_1.visibility=View.GONE
                        opt_2.visibility=View.GONE
                        opt_3.visibility=View.GONE
                        opt_4.visibility=View.GONE
                        imageView.setImageResource(R.drawable.congo)
                        question_text.text="congratulation You have completed your quiz successfully  \nPress Finish to watch your score "
                    }
                    else {
                        currentPosition++
                        when{
                            currentPosition<=questionList!!.size->{
                                setQuestion()
                            }
                            else->{
                                var intent= Intent(this,result::class.java)
                                intent.putExtra(setData.name,Name.toString())
                                intent.putExtra(setData.score,score.toString())
                                intent.putExtra("total size",questionList!!.size.toString())

                                startActivity(intent)
                                finish()
                            }
                        }
                    }
                },200)

            }else{
                currentPosition++
                when{
                    currentPosition<questionList!!.size ->{
                        setQuestion()
                    }
                    else->{
                        var intent= Intent(this,result::class.java)
                        intent.putExtra(setData.name,Name.toString())
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())

                        startActivity(intent)
                        finish()
                    }
                }
            }
            selecedOption=0
        }

    }

    fun setColor(opt:Int,color:Int){
        when(opt){
            1->{
                opt_1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt_2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt_3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                opt_4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }


    fun setQuestion(){

        val question = questionList!![currentPosition-1]
        setOptionStyle()


        progress_bar.progress=currentPosition
        progress_bar.max=questionList!!.size
        progress_text.text="${currentPosition}"+"/"+"${questionList!!.size}"
        question_text.text=question.question
        imageView.setImageResource(question.image)
        opt_1.text=question.option_one
        opt_2.text=question.option_tw0
        opt_3.text=question.option_three
        opt_4.text=question.option_four

    }

    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt_1)
        optionList.add(1,opt_2)
        optionList.add(2,opt_3)
        optionList.add(3,opt_4)

        for(op in optionList)
        {
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface= Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view:TextView,opt:Int){

        setOptionStyle()
        selecedOption=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_question_option)
        view.typeface= Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))

    }
}