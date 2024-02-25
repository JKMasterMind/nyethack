package org.example.fx
var heroName = " "
fun main() {
    //changeNarratorMode
    heroName = promptHeroName()
    narrate("$heroName, ${createTitle(heroName)}, heads to the town square")
    visitTavern()
}

private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What's their name") { message ->
        "\u001b[33;1m$message\u001b[0m"
    }
    /*val input = readln()
    require(input != null && input.isNotEmpty()){
        "The hero must have the name
    }
     return input*/
    println("Madrid")
    return "Madrid"

}

/*
private fun makeYellow(message: String) =
"\u001b[33;1m$message\u001b[0m"
*/

private fun createTitle(name: String): String {
    return when{
        name.all{it.isDigit()} -> "The identifiable"
        name.none{it.isLetter()} -> "The Witness Protection Member"
        name.count{it.lowercase() in "aeiou"} > 4 -> "The Master of Vowel"
        name.all{it.isUpperCase()} -> "Выдающийся"
        isPalindrome(name) -> "Носитель палиндрома"
        name.count() > 7 -> "Пространный"
        else -> "The Renowned hero"
    }
}



private fun isPalindrome(name: String): Boolean {
    val namePalindrome = name.reversed()
    return name.equals(namePalindrome, ignoreCase = true)
}