package arrays

import printArray

/*
*  You are given a sorted array ‘arr’ of ‘n’ numbers such that every number
*  occurred twice in the array except one, which appears only once.
*
* */

fun main() {
    val arr1 = intArrayOf(3, 3, 7, 7, 10, 11, 11)
    printArray(arr1)
    println(singleNonDuplicate(arr1))
}

private fun singleNonDuplicate(nums: IntArray): Int {
    var ans = 0;

    for (value in nums) {
        print("Ans = $ans, value = $value = ")
        ans = ans xor value
        print(ans)
        println()
    }

    return ans
}