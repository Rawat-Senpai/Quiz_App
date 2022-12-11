package com.example.intern_project

object setData {

    const val name:String="name"
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()

        var question2 = QuestionData(
            2,
            "What is the name of this shape ",
            R.drawable.circle,
            "circle",
            "square ",
            "rectangle",
            "None of the above",
            1
        )

        var question1 = QuestionData(
            1,
            "which county's flag is this ",
            R.drawable.india,
            "Bangla Desh ",

            "Nepal",
            "India",
            "Bhutan",
            3
        )
        var question3 = QuestionData(
            3,
            "which shape is this",
            R.drawable.square,
            "circle",
            "square ",
            "rectangle",
            "None of the above",
            2
        )
        var question4 = QuestionData(
            4,
            "what is the name of this sport  ?",
            R.drawable.football,
            "cricket",
            "badminton",
            "football",
            "non of the above",
            3
        )

        var question5 = QuestionData(
            5,
            "what is the name of this sport ",
            R.drawable.cricket,
            "football",
            "cricket",
            "badminton",
            "none of the above",
            2
        )

        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que
    }
}