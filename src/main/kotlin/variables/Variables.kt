package variables

fun main(args: Array<String>) {
    var score = 5 // value reassigned (changed)
    score = 10
    println(score)

    val message = "Hello variables" // the value cannot be reassigned (changed)
//    message = "World" // Error
    println(message)

    val b: Byte = 100 // -128 to 127
    val s: Short = 5000 // -32768 to 32767
    val i: Int = 100000 // -2147483648 to 2147483647
    val l: Long = 15000000000L // -9223372036854775807 to 9223372036854775807
    val f: Float = 5.75F
    val d: Double = 19.99
    val isKotlinFun: Boolean = true
    val myGrade: Char = 'B'
    val myText: String = "Hello World"


}