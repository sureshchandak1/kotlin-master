package function

// video 12
fun main() {
    println(add(5, 7)) // 5 and 7 is called argument
    evenOdd(20)
    evenOdd(13)
    println(sub(20, 10))
    println(multiply(20, 10))
    printMessage(3)
    printMessage()
}

fun add(num1: Int, num2: Int) : Int { // num1 and num2 is called parameter
    // num1 and num2 is val type. not allow to re-assigned
//    num1 = 5
//    num2 = 10
    return num1 + num2
}

fun evenOdd(num: Int) : Unit { // by default function return type is Unit in kotlin
    val result = if (num % 2 == 0) "Even" else "Odd"
    println(result)
}

// Inline function
fun sub(num1: Int, num2: Int) : Int = num1 - num2
fun multiply(num1: Int, num2: Int) = num1 * num2

// Default Arguments
fun printMessage(count: Int = 2) {
    for (i in 1..count) {
        println("Hello $i")
    }
}