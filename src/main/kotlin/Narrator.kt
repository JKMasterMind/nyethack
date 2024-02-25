package org.example.fx
import kotlin.random.Random
import kotlin.random.nextInt

var narration: (String) -> String  = { it }

inline fun narrate(
    message: String,
    modifier: (String) -> String = { narration(it)}
) {
    val numExclamation = 3
    message.uppercase() + "!".repeat(numExclamation)
    println(modifier(message))

}

    fun changeNarratorMood(){
        val mood: String
        val modifier: (String) -> String
        when(Random.nextInt(1..6)){
            1 -> {
                mood = "loud"
                modifier = { message ->
                    val numExclamation = 3
                    message.uppercase() + "!".repeat(numExclamation)

                }
            }
            2 -> {
                mood = "tired"
                modifier = {
                        message ->
                    message.lowercase().replace(" ", "... ")
                }
            }
            3 -> {
                mood = "unsure"
                modifier = {
                        message ->
                    "$message?"
                }
            }
            4 ->
            {
                var narrationsGiven =0
                mood = "like sending an itemized bill"
                modifier = {
                        message ->
                    narrationsGiven++
                    "$message.\n(I have narrated $narrationsGiven things)"
                }
            }
            5 -> {
                mood = "поэтическое"
                modifier = {
                    message ->
                    message.lowercase().replace(" ", "\n")
                }
            }
            else -> {
                mood = "professional"
                modifier = {
                        message ->
                    "$message."
                }
            }


        }
        narration = modifier
        narrate("The narrator begins to feel $mood")
    }