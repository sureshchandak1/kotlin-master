package bit_manipulation

/**
 *    https://leetcode.com/problems/single-number/description/
 *    Time Complexity: O(N)
 *    Space Complexity: O(1)
 */
fun main() {
    println(singleNumber(intArrayOf(2, 2, 1)))
    println(singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    println(singleNumber(intArrayOf(1)))
}

// Function to find the single number in an array where every element appears twice except for one
private fun singleNumber(nums: IntArray): Int {

    var answer = 0

    for (value in nums) {
        // Apply XOR operation between the 'answer' and the 'value'
        // Since XOR of a number with itself is 0 and with 0 is the number itself,
        // this will cancel out all pairs leaving the single number alone
        answer = answer xor value
    }

    // Return the single number that doesn’t have a pair
    return answer
}









