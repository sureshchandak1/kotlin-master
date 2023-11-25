package lateinit

/*
*  - initialized in the future
*  - not allow with primitive data types (e.g., Int, Double)
*  - nullable properties, can’t be declared
* */
fun main() {
    val cal = Calculator()
    cal.message1 = "Hello Calculator"
    println(cal.message1)
    println(cal.message2) // Exception = UninitializedPropertyAccessException: lateinit property message2 has not been initialized
}

class Calculator {

    lateinit var message1: String
    lateinit var message2: String

//    lateinit var message2: String? = null // not allow
//    lateinit var message2: Int // not allow

}