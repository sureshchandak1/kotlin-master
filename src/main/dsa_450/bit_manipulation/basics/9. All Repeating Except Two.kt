package bit_manipulation.basics

import printArray

fun main() {
    var arr = intArrayOf(23, 27, 23, 17, 17, 37)
    printArray(findUnique(arr))

    arr = intArrayOf(36, 50, 24, 56, 36, 24, 42, 50)
    printArray(findUnique(arr))
}

private fun findUnique(arr: IntArray): IntArray {

    val result = IntArray(2)

    var ans = 0
    for (value in arr) {
        ans = ans xor value
    }

    // (n.inv() + 1) 2's complement
    val mask = -ans // 2's complement

    // right most set bit mast
    val rsbMask = ans and mask

    var ans1 = 0
    var ans2 = 0
    for (value in arr) {
        if ((value and rsbMask) == 0) {
            ans1 = ans1 xor value
        } else {
            ans2 = ans2 xor value
        }
    }

    if (ans1 < ans2) {
        result[0] = ans1
        result[1] = ans2
    } else {
        result[0] = ans2
        result[1] = ans1
    }

    return result
}














