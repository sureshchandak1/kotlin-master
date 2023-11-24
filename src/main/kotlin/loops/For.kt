package loops

fun main() {
    println("-------------------- Increase --------------------")
    for (i in 1..5) {
        println(i)
    }
    println("----------------------------")
    for (i in 1..5 step 2) {
        println(i)
    }
    println("---------------------------- Until")
    for (i in 1 until  5) { // not include upper bound (5)
        println(i)
    }
    println("----------------------------")
    for (i in 1 until  5 step 2) {
        println(i)
    }

    println("-------------------- Decrease --------------------")
    for (i in 5 downTo 1) {
        println(i)
    }
    println("----------------------------")
    for (i in 5 downTo 1 step 2) {
        println(i)
    }
    println("----------------------------")

    val number = 2
    for (i in 1..10) {
        //println(number.toString() + " x " + i + " = " + (number * i))
        // String Templating
        println("$number x $i = ${ number * i }")
    }
}