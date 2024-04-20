/**
 *   https://leetcode.com/problems/jump-game-ii/
 */
fun main() {
    println(jump(intArrayOf(0)))
    println(jump(intArrayOf(2, 3, 1, 1, 4)))
    println(jump(intArrayOf(3, 2, 1, 0, 4)))
    println(jump(intArrayOf(0, 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)))
    println(jump(intArrayOf(1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9)))
}

private fun jump(nums: IntArray): Int {

    var max = 0
    var jump = 0
    var halt = 0
    val size = nums.size

    if (size == 1 && nums[0] == 0) {
        return 0
    }
    if (nums[0] == 0) {
        return -1
    }

    for (i in 0 ..< size - 1) {

        max = Math.max(max, i + nums[i])

        if (i == halt) {
            halt = max
            jump++
        }
    }

    if (halt >= size - 1) {
        return jump
    }

    return -1
}