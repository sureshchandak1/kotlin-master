package condition

fun main() {
    val animal = "Dog"

    if (animal == "Horse") {
        println("Animal is Horse")
    } else if (animal == "Cat") {
        println("Animal is Cat")
    } else if (animal == "Dog") {
        println("Animal is Dog")
    } else {
        println("Animal not Found")
    }

    when (animal) {
        "Horse" -> {
            println("Animal is Horse")
        }
        "Cat" -> {
            println("Animal is Cat")
        }
        "Dog" -> {
            println("Animal is Dog")
        }
        else -> {
            println("Animal not Found")
        }
    }

    var result = when (animal) {
        "Horse" -> "Animal is Horse"
        "Cat" -> "Animal is Cat"
        "Dog" -> "Animal is Dog"
        else -> "Animal not Found"
    }
    println(result)

    val number = 13
    result = when(number) {
        11 -> "Eleven"
        12 -> "Twelve"
        in 13..19 -> "Teen"
        else -> "Not in range"
    }
    println(result)
}