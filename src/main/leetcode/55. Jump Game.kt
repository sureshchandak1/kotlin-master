import kotlin.math.max

/**
 *    https://leetcode.com/problems/jump-game/description/
 */
fun main() {
    println(canJump(intArrayOf(0)))
    println(canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(canJump(intArrayOf(3, 2, 1, 0, 4)))
    println(canJump(intArrayOf(0, 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)))
    println(canJump(intArrayOf(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)))
}

private fun canJump(nums: IntArray): Boolean {

    var max = 0
    var jump = 0
    var halt = 0
    val length = nums.size

    if (length == 1 && nums[0] == 0) {
        return true
    }
    if (nums[0] == 0) {
        return false
    }

    for (i in 0..<length - 1) {
        max = max(max, i + nums[i])

        /*if (max >= length - 1) {
            jump++
            return true
        }*/

        if (i == halt) {
            halt = max
            jump++
        }
    }

    return halt >= length - 1
}