package lecture034_Recursion_Day4

fun main() {
    println(power(2, 10))
    println(power(3, 10))
    println(power(3, 11))
}

/*
*  a = number
*  b = power
* */
fun power(a: Int, b: Int): Int {

    // Base case
    if (b == 0) {
        return 1
    }
    if (b == 1) {
        return a
    }

    val ans = power(a, b / 2) // half power result

    return if (b % 2 == 0) {
        ans * ans
    } else {
        a * ans * ans
    }
}