package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * this activity allows user to roll a dice and view the result on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        rollDice()
    }

    /**
     * roll and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)

        // Update view with correct dice
        val firstDiceImage: ImageView = findViewById(R.id.dice1)
        val secondDiceImage: ImageView = findViewById(R.id.dice2)

        val firstDiceRoll = dice.roll()
        val secondDiceRoll = dice.roll()

        firstDiceImage.setImageResource(selectDice(firstDiceRoll))
        firstDiceImage.contentDescription = firstDiceRoll.toString()

        secondDiceImage.setImageResource(selectDice(secondDiceRoll))
        secondDiceImage.contentDescription = secondDiceRoll.toString()
    }

    private fun selectDice(diceNumber: Int): Int {
        return when (diceNumber){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}