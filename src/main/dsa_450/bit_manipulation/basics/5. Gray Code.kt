package bit_manipulation.basics

import printArray

/**
 *    https://leetcode.com/problems/gray-code/description/
 */
fun main() {
    printArray(grayCode(2))
    printArray(grayCode(4))
}

private fun grayCode(n: Int): MutableList<Int> {

    val result = ArrayList<Int>()

    val ans: MutableList<String> = grayCodeSolution(n)

    for (item in ans) {
        result.add(toDecimal(item))
    }

    return result
}

private fun grayCodeSolution(n: Int): MutableList<String> {

    // Base case
    if (n == 1) {
        val result = ArrayList<String>()
        result.add("0")
        result.add("1")
        return result
    }

    val ans: MutableList<String> = grayCodeSolution(n - 1)

    val result: ArrayList<String> = ArrayList()

    for (item in ans) {
        result.add("0${item}")
    }

    for (i in ans.size - 1 downTo 0) {
        result.add("1${ans[i]}")
    }

    return result
}

private fun toDecimal(binaryNumber : String) : Int {

    var sum: Double = 0.0

    binaryNumber.reversed().forEachIndexed {
            k, v -> sum += v.toString().toInt() * Math.pow(2.0, k.toDouble())
    }

    return sum.toInt()
}













