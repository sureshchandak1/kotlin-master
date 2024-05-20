package bit_manipulation.basics

fun main() {
    println("Enter Number: ")
    val n: Int = readln().toInt()
    println(n.to32bitString())

    println(setBits(n))
}

private fun setBits(n:Int):Int {

    // Kernighan's Algorithm

    var value = n
    var count = 0

    while (value != 0) {
        // Right most set bit mask
        // -value = 2's complement
        val rsbMask = (value and -value)
        value -= rsbMask
        count++
    }

    return count

}








