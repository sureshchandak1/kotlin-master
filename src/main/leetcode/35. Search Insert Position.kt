
/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 **/
fun main() {

    println(searchInsert(intArrayOf(1, 3, 5, 6), 5))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 4))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 0))
    println(searchInsert(intArrayOf(1), 0))
}

private fun searchInsert(nums: IntArray, target: Int): Int {

    var start = 0
    var end = nums.size
    var mid = start + (end - start) / 2

    while (start < end) {

        if (nums[mid] >= target) {
            end = mid
        } else {
            start = mid + 1
        }

        mid = start + (end - start) / 2

    }

    return start

}