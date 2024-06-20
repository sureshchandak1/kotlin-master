package bit_manipulation.basics

fun main() {
    println("Enter Number: ")
    val n: Int = readln().toInt()
    println(n.to32bitString())

    // (n.inv() + 1) 2's complement
    val mask = -n // 2's complement

    // right most set bit mast
    val rsbMask = n and mask

    println(rsbMask.to32bitString())
}
