package condition

fun main() {
    var isRaining = true

    if (isRaining) {
        println("Take Umbrella")
    } else {
        println("No Rains - Enjoy your day")
    }

    isRaining = false

    if (isRaining) {
        println("Take Umbrella")
    } else {
        println("No Rains - Enjoy your day")
    }

    val x = 10
    var y = 11

    if (x > y) {
        println("X is greater than Y")
    } else if (x < y) {
        println("X is less than Y")
    } else {
        println("X is equal to Y")
    }

    // as Expression
    y = 10
    var result = if (x > y) {
        "X is greater than Y"
    } else if (x < y) {
        "X is less than Y"
    } else {
        "X is equal to Y"
    }
    println(result)

    var number = 20
    result = if (number % 2 == 0) {
        "Even"
    } else {
        "Odd"
    }
    println(result)

    number = 21
    result = if (number % 2 == 0) "Even" else "Odd"
    println(result)
}