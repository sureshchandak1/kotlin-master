package array

/**
 *   https://leetcode.com/problems/find-the-duplicate-number/
 */
fun main() {
    println(findDuplicateNo(intArrayOf(1, 3, 4, 2, 2)))
    //println(findDuplicateNumber1(intArrayOf(1, 3, 4, 2, 2)))

    println(findDuplicateNo(intArrayOf(1, 3, 1, 3, 4, 2)))
    //println(findDuplicateNumber1(intArrayOf(1, 3, 1, 3, 4, 2)))

    println(findDuplicateNo(intArrayOf(3, 3, 3, 3, 3)))
    //println(findDuplicateNumber1(intArrayOf(3, 3, 3, 3, 3)))
}

/**
 *   Time Complexity: O(n)
 *   Auxiliary Space: O(n)
 */
private fun findDuplicateNo(nums: IntArray): Int {

    val countMap: MutableMap<Int, Int> = HashMap()

    for (num in nums) {
        countMap[num] = countMap.getOrDefault(num, 0) + 1
        if (countMap.getOrDefault(num, 0) > 1) {
            return num
        }
    }

    return -1
}

/**
 *   Time Complexity: O(n)
 *   Auxiliary Space: O(1)
 *   work on only single element 2 times in array like (1, 3, 4, 5, 5)
 */
private fun findDuplicateNumber1(nums: IntArray): Int {

    var ans = 0

    for (value in nums) {
        ans = ans xor value
    }

    for (index in nums.indices) {
        ans = ans xor index
    }

    return ans
}


