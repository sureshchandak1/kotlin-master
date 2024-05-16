package bit_manipulation

import printArray

/**
 *    https://leetcode.com/problems/single-number-iii/description/
 *    Time complexity: O(N)
 *    Space complexity: O(1)
 */
fun main() {
    printArray(singleNumber(intArrayOf(1, 2, 1, 3, 2, 5)))
    //printArray(singleNumber(intArrayOf(-1, 0)))
    //printArray(singleNumber(intArrayOf(0, 1)))
}

private fun singleNumber(nums: IntArray): IntArray {
    // Initial bitmask value which will eventually contain the XOR of all numbers in the array
    var xorResult = 0
    // Perform XOR across all elements in the array to find the XOR of the two unique numbers
    for (num in nums) {
        xorResult = xorResult xor num
    }
    println("xorResult = $xorResult")

    // Get the rightmost set bit in xorResult which will differentiate the two unique numbers
    // Negating xorResult gives its two's complement, and bitwise AND with original number
    // isolates the rightmost set bit
    val rightmostSetBit = xorResult and -xorResult
    println("rightmostSetBit = $rightmostSetBit")

    var firstUniqueNumber = 0
    // XOR the numbers that have the set bit (same as in rightmostSetBit)
    // to find one of the unique numbers
    for (num in nums) {
        // Check if the bit is set
        if ((num and rightmostSetBit) != 0) {
            firstUniqueNumber = firstUniqueNumber xor num
        }
    }

    // XOR the found unique number with xorResult to find the second unique number since
    // xorResult is a XOR of both unique numbers
    val secondUniqueNumber = xorResult xor firstUniqueNumber

    // Return an array containing both unique numbers
    return intArrayOf(firstUniqueNumber, secondUniqueNumber)
}


