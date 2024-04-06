package mathematical

import printArray

/*
*    https://www.geeksforgeeks.org/problems/print-first-n-fibonacci-numbers1002/1
* */
fun main() {
    printArray(printFibonacci(5))
    printArray(printFibonacci(7))
    printArray(printFibonacci(13))
}

private fun printFibonacci(n: Int): LongArray {

    val ans = LongArray(n)
    ans[0] = 1

    var a: Long = 0
    var b: Long = 1

    for (i in 1..< n) {
        val next = a + b
        a = b
        b = next

        ans[i] = next
    }

    return ans
}


