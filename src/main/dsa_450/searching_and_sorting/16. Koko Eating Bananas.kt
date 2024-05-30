package searching_and_sorting

/**
 *   https://leetcode.com/problems/koko-eating-bananas/solutions/5231558/binary-search-solution/
 *   Time complexity: O(N log(max(arr)))
 *   Space complexity: O(1)
 */
fun main() {
    var piles = intArrayOf(3, 6, 7, 11)
    println(minimumRateToEatBananas(piles, 8))

    piles = intArrayOf(30, 11, 23, 4, 20)
    println(minimumRateToEatBananas(piles, 5))
    println(minimumRateToEatBananas(piles, 6))
}

private fun minimumRateToEatBananas(piles: IntArray, h: Int): Int {

    var start = 1
    var end = findMax(piles)
    var mid = start + (end - start) / 2

    while (start <= end) {

        val totalHour = calculateHours(piles, mid)

        if (totalHour <= h) {
            end = mid - 1
        } else {
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return start
}

/**
 *  @param hourly = how many eats bananas in 1 hour
 */
private fun calculateHours(piles: IntArray, hourly: Int): Int {

    var totalHour: Double = 0.0

    for (value in piles) {
        totalHour += Math.ceil(value.toDouble() / hourly.toDouble())
    }

    return totalHour.toInt()
}

private fun findMax(piles: IntArray): Int {
    var maxi = Int.MIN_VALUE

    for (value in piles) {
        maxi = Math.max(maxi, value)
    }

    return maxi
}














