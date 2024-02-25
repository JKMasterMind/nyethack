package org.example.fx
import java.io.File

private const val TAVERN_MASTER = "Tamerlan"
private const val TAVERN_NAME = "$TAVERN_MASTER's folly"
private val menuData = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")

private val menuItems = List(menuData.size) {
    index -> val(type, name, price) = menuData[index].split(",")
    name
}

fun visitTavern() {
    narrate("$heroName enters $TAVERN_NAME")
    narrate("There are several items for sale:")
    println(menuItems)
    val patrons = mutableListOf("Eli", "Mordoc", "Sophie")
    val readOnlyPatrons = patrons.toList()
    val eliMessage = if(patrons.contains("Eli")){
        "$TAVERN_MASTER says: Eli's in the back playing cards"

    }
    else{
        "$TAVERN_MASTER says: Eli isn't here"
    }
    println(eliMessage)

    val allMessage = if(patrons.containsAll(listOf("Eli", "Mordoc")))
        "$TAVERN_MASTER says: Eli and Mordoc are seated by the stew kettle"
    else
        "$TAVERN_MASTER says: Eli and Mordoc aren't with each other right now"
    println(allMessage)
    patrons.forEachIndexed(){index, patron -> println("Good evening, $patron - you're #${index + 1} in line")
        placeOrder(patron, "Dragon breath")
    }


}

private fun placeOrder(patronName: String, menuItemName: String){
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
}