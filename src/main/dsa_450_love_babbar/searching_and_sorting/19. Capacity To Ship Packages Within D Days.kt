package searching_and_sorting

/**
 *    https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 *    Time complexity: O(n log(n))
 *    Space complexity: O(1)
 */
fun main() {
    var weights = intArrayOf(1,2,3,4,5,6,7,8,9,10)
    println(shipWithinDays(weights, 5))
    weights = intArrayOf(3,2,2,4,1,4)
    println(shipWithinDays(weights, 3))
    weights = intArrayOf(1,2,3,1,1)
    println(shipWithinDays(weights, 4))
}

private fun shipWithinDays(weights: IntArray, days: Int): Int {

    var maxi = Int.MIN_VALUE
    var sum = 0
    for (weight in weights) {
        sum += weight
        maxi = Math.max(maxi, weight)
    }

    // start binary search
    var start = maxi
    var end = sum
    var mid = start + (end - start) / 2

    while (start <= end) {

        val noOfDays = findDays(weights, mid)

        if (noOfDays <= days) {
            end = mid - 1
        }
        else {
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return start
}

/**
 *   @return: total required days
 */
private fun findDays(weights: IntArray, capacity: Int): Int {

    var days = 1 // start from 1 day
    var load = 0

    for (weight in weights) {
        if (load + weight > capacity) { // increase load then move to next day
            days += 1 // move to next day
            load = weight // load weight on next day
        }
        else {
            // load the weight on the same day
            load += weight
        }
    }

    return days
}













