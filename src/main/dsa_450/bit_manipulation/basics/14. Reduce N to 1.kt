package bit_manipulation.basics

/**
 *    https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
 */
fun main() {
    println(numberOfSteps(14))
    println(numberOfSteps(8))
    println(numberOfSteps(123))
}

private fun numberOfSteps(num: Int): Int {

    var value = num
    var count = 0

    while (value != 1) {
        if (value % 2 == 0) {
            value /= 2
        } else if (value == 3) {
            value -= 1
        } else if ((value and 3) == 1) {
            value -= 1
        } else if ((value and 3) == 3) {
            value += 1
        }

        count++
    }

    return count
}

private fun stepsToZero(num: Int): Int {
    var value = num
    var count = 0

    while (value != 0) {
        if ((value xor 1) == (value + 1)) {
            value /= 2
        } else {
            value -= 1
        }

        count++
    }

    return count
}


