package lecture106_House_Robbery_Problem

/**
 *    https://leetcode.com/problems/house-robber-ii/description/
 *    T.C = O(n)
 *    S.C = O(n)
 */
fun main() {
    var arr = intArrayOf(1, 2, 3, 1)
    println(rob(arr))
    arr = intArrayOf(2, 3, 2)
    println(rob(arr))
    arr = intArrayOf(1, 2, 3)
    println(rob(arr))
}

private fun rob(nums: IntArray): Int {
    val n = nums.size

    if (n == 1) return nums[0]

    val first: MutableList<Int> = ArrayList()
    val second: MutableList<Int> = ArrayList()

    for (i in 0..<n) {
        if (i != n - 1) {
            first.add(nums[i])
        }
        if (i != 0) {
            second.add(nums[i])
        }
    }

    return Math.max(solve(first), solve(second))
}

private fun solve(nums: MutableList<Int>): Int {

    val n = nums.size

    var prev1 = nums[0]
    var prev2 = 0

    for (i in 1..<n) {
        val include = prev2 + nums[i]
        val exclude = prev1

        val ans = Math.max(include, exclude)
        prev2 = prev1
        prev1 = ans
    }

    return prev1
}















