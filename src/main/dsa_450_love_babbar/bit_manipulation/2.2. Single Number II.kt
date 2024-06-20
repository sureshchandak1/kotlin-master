package bit_manipulation

/**
 *    https://leetcode.com/problems/single-number-ii/description/
 *    Time complexity: O(N)
 *    Space complexity: O(1)
 */
fun main() {
    println(singleNumber(intArrayOf(2,2,3,2)))
    println(singleNumber(intArrayOf(0,1,0,1,0,1,99)))
}

private fun singleNumber(nums: IntArray): Int {

    var bit1 = 0 // This will hold the XOR of all the elements which appear exactly once
    var bit2 = 0 // This will hold the XOR of all the elements which appear exactly twice

    for (num in nums) {

        val b1 = bit1.inv() and bit2 and num
        val b2 = bit1 and bit2.inv() and num.inv()

        val newBit1 = b1 or b2
        val newBit2 = bit1.inv() and (bit2 xor num)

        bit1 = newBit1
        bit2 = newBit2
    }

    return bit2
}

