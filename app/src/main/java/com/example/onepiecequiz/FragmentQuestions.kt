package com.example.onepiecequiz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.onepiecequiz.databinding.FragmentQuestionsBinding


class FragmentQuestions : Fragment() {
    lateinit var binding: FragmentQuestionsBinding
    lateinit var currentQuestion: Questions
    private var questionIndex = 0
    private val maxNumberOfQuestions = 6
    lateinit var answers: ArrayList<String>
    private var score = 0
    lateinit var selectedAnswer: String


    private var questions = arrayListOf(
        Questions(
            "Who was the former king of pirates ?",
            arrayListOf("Roger", "White beard", "Xebec")
        ),
        Questions(
            "What is known to be the symbol of the ancient kingdom ?",
            arrayListOf("The sun", "The moon", "The bell")
        ),
        Questions(
            "When where we introduced to conquerors haki ?",
            arrayListOf("Foosha Village", "Marine Ford", "Amazon lily")
        ),
        Questions(
            "What character do we know used observation haki first ?",
            arrayListOf("Zoro", "Ussop", "Enel")
        ),
        Questions(
            "What are the winged people in Skypie called ?",
            arrayListOf("Birkas", "Sky people", "Angels")
        ),
        Questions(
            "What was joy boys promise to the fishemen ?",
            arrayListOf("To bring the to the surface", "To show them the forrest", "To destroy there home"
            )
        ),
        Questions(
            "How many kingdoms banded together to declare war to the ancient kingdom ?",
            arrayListOf("20", "40", "50")
        ),
        Questions(
            "What 3 weapons did the ancient kingdom create to battle there enemy's ?",
            arrayListOf("Poseidon,Pluton,Uranos", "Zeus,Pluton,Poseidon", "Armes,Zeus,Pluton")
        ),
        Questions(
            "Who stopped the marine ford war ?",
            arrayListOf("Shanks", "Black Beard", "Kaido")
        ),
        Questions(
            "What arc did we see zoro accidentally use conquerors haki ?",
            arrayListOf("Whisky Peak", "Sabaody", "Punk Hazard")
        ),
        Questions(
            "What fictional comic book is beating One piece for number one spot ?",
            arrayListOf("Super Man", "Demon Slayer", "Attack on titan")
        ),
        Questions(
            "Where did sanji learn to create fire from his leg ?",
            arrayListOf("Wanze", "Bon Kurei", "Kuroobi")
        ),
        Questions(
            "How many one piece movies have been released do far ?",
            arrayListOf("17", "20", "10")
        ),
        Questions(
            "How many people know what happen to Zoro after the kuma situation ?",
            arrayListOf("4", "2", "3")
        ),
        Questions(
            "How many islands have the strawHats been to ?",
            arrayListOf("20+", "10+", "15+")
        ),
        Questions(
            "What is the name of the man that trained ussop during the 2 year time skip ?",
            arrayListOf("Heracles", "Loki", "Moses")
        ),
        Questions(
            "How many shichibukai are there in one piece ?",
            arrayListOf("0", "7", "12")
        ),
        Questions(
            "What did white Beard say to the world, before he died ?",
            arrayListOf("one peice is real", "Roger wasnt waiting for you", "its a sin to die before me")
        ),
        Questions(
            "What character sacrificed them selfs so luffy could save his brother ?",
            arrayListOf("Bon Kurei", "White Beard", "Little oars")
        ),
        Questions(
            "Who is the weakest pirate in the new world ? ",
            arrayListOf("Buggy", "Ussop", "Chopper")
        )


    )



    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        answers = ArrayList(currentQuestion.theAnswer)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", currentQuestion.theAnswer[0])
    }

    private fun randomQuestion() {
        questions.shuffle()
        questions.random()
        setQuestion()
    }

    //When the answer is checked from the quiz, the score will increase independently.
    //Next question will com up
    private fun checkTheAnswer(answers: String) {
        if (answers == currentQuestion.theAnswer[0]) {
           score += 1
        }
        questionIndex++
        if (questionIndex<maxNumberOfQuestions) {
            setQuestion()
            binding.invalidateAll()
        } else {
            getTheScore()
        }
    }

    // adds up my score in the end through the toast method
    private fun getTheScore() = if (score >= 3){
        Navigation.findNavController(requireView()).navigate(R.id.action_fragmentQuestions_to_fragmentWon)
    }else {
        Navigation.findNavController(requireView()).navigate(R.id.action_fragmentQuestions_to_fragmentLost)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_questions, container, false)
        randomQuestion()
        binding.quiz = this
        return binding.root
    }

    // Buttons for the texViews in the XML
    override fun onActivityCreated( savedInstanceState: Bundle?) {
        super.onActivityCreated( savedInstanceState)
        binding.Answer1.setOnClickListener {
            checkTheAnswer(answers[0])
        }

        binding.Answer2.setOnClickListener {
            checkTheAnswer(answers[1])
        }

        binding.Answer3.setOnClickListener {
            checkTheAnswer(answers[2])
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }

}


