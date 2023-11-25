package constructors

fun main() {
    val cal = Calculator() // Create object by using default constructor
    println(cal.add(2, 3))
}

class Calculator { // Create default constructor with empty parameters

    fun add(a: Int, b: Int) = a + b
    fun multiply(a: Int, b: Int) = a * b
}