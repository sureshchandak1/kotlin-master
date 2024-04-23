package array

/**
 *   https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
 */
fun main() {
    var arr = intArrayOf(1, 5, 7, 1)
    println(getPairsCounts(arr, arr.size, 6))

    arr = intArrayOf(1, 5, 7, 1, 5, 1, 5, 1)
    println(getPairsCounts(arr, arr.size, 6))

    arr = intArrayOf(1, 1, 1, 1)
    println(getPairsCounts(arr, arr.size, 2))
}

/**
 *          ***** Count pairs with given sum using Hashing *****
 *   Time Complexity: O(n), to iterate over the array
 *   Space Complexity: O(n), to make a map of size n
 */
private fun getPairsCounts(arr: IntArray, n: Int, k: Int): Int {

    val map: MutableMap<Int, Int> = HashMap()

    var count = 0

    for (i in 0..< n) {
        if (map.containsKey(k - arr[i])) {
            count += map[k - arr[i]]!!
        }

        map.merge(arr[i], 1) { a: Int?, b: Int? ->
            Integer.sum(a!!, b!!)
        }
    }

    return count
}

/**
 *    ***** Naive Approach *****
 *    Time Complexity: O(n2), traversing the array for each element
 *    Space Complexity: O(1)
 */
private fun getCount(arr: IntArray, n: Int, k: Int): Int {

    var count = 0

    for (i in 0..< n) {
        for (j in i + 1..< n) {
            if (arr[i] + arr[j] == k) {
                count++
            }
        }
    }

    return count
}



