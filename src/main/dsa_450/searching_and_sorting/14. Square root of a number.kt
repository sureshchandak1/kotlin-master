package searching_and_sorting

/**
 *   https://leetcode.com/problems/sqrtx/solutions/5226625/square-root-binary-search-o-log-n-solution/
 *   Time complexity: O(log n)
 *   Space complexity: O(1)
 */
fun main() {
    println(floorSqrt1(4))
    println(floorSqrt1(8))
    println(floorSqrt1(144))
}

private fun floorSqrt1(x: Long): Long {
    var start: Long = 0
    var end = x
    var mid = start + (end - start) / 2

    var ans: Long = -1

    while (start <= end) {
        val sqrt = mid * mid

        if (sqrt == x) {
            return mid
        }

        if (sqrt > x) {
            end = mid - 1
        } else {
            ans = mid
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return ans
}

private fun floorSqrt2(x: Long): Long {
    var start: Long = 0
    var end = x
    var mid = start + (end - start) / 2

    while (start <= end) {

        val sqrt = mid * mid

        if (sqrt > x) {
            end = mid - 1
        } else {
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return end
}




















