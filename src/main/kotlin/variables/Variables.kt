package variables

fun main(args: Array<String>) {
    var score = 5 // value reassigned (changed)
    score = 10
    println(score)

    val message = "Hello variables" // the value cannot be reassigned (changed)
//    message = "World" // Error
    println(message)

    val b: Byte = 100 // 8 bits             -128 to 127
    val s: Short = 5000 // 16 bits          -32768 to 32767
    val i: Int = 100000 // 32 bits          -2147483648 to 2147483647
    val l: Long = 15000000000L // 64 bits   -9223372036854775807 to 9223372036854775807
    val f: Float = 5.75F // 32 bits         -1.40129846432481707e-45 to 3.40282346638528860e+38
    val d: Double = 19.99 // 64 bits        -4.94065645841246544e-324 to 1.79769313486231570e+308
    val isKotlinFun: Boolean = true // 1 bit    true or false
    val myGrade: Char = 'B' // 16 bits

    charPosition('a', 'A', '6')
}

private fun charPosition(vararg chs: Char) {

    chs.forEach { ch ->
        when (ch) {
            in 'a'..'z' -> {
                println("This is small case")
            }
            in 'A'..'Z' -> {
                println("This is upper case")
            }
            in '0'..'9' -> {
                println("This is numeric")
            }
        }
    }

}