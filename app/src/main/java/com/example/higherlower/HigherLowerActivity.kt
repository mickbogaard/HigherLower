package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    private fun initViews() {
        btnLower.setOnClickListener {
            onLowerClick()
        }
        btnEqual.setOnClickListener{
            onEqualClick()
        }
        btnHigher.setOnClickListener {
            onHigherClick()
        }

        updateUI()
    }

    private fun updateUI() {
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> diceImg.setImageResource(R.drawable.dice1)
            2 -> diceImg.setImageResource(R.drawable.dice2)
            3 -> diceImg.setImageResource(R.drawable.dice3)
            4 -> diceImg.setImageResource(R.drawable.dice4)
            5 -> diceImg.setImageResource(R.drawable.dice5)
            6 -> diceImg.setImageResource(R.drawable.dice6)
        }
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow){
            onAnswerCorrect()
        }
        else {
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow){
            onAnswerCorrect()
        }
        else {
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow){
            onAnswerCorrect()
        }
        else {
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect(){
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect(){
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }



}
