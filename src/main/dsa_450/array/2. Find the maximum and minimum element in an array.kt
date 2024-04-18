package array

fun main() {
    var arr = intArrayOf(3, 5, 4, 1, 9)
    var result = findMinMax(arr)
    println("Min = ${result[0]}, Max = ${result[1]}")
    println("Sum = ${findSum(arr, arr.size)}")

    arr = intArrayOf(22, 14, 8, 17, 35, 3)
    result = findMinMax(arr)
    println("Min = ${result[0]}, Max = ${result[1]}")
    println("Sum = ${findSum(arr, arr.size)}")
}

/**
 *   Time Complexity: O(N)
 *   Auxiliary Space: O(1)
 */
private fun findMinMax(arr: IntArray) : IntArray {

    val size = arr.size

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE

    for (i in 0 ..< size) {
        if (min > arr[i]) {
            min = arr[i]
        }
        if (max < arr[i]) {
            max = arr[i]
        }
    }

    return intArrayOf(min, max)
}

/**
 *   https://www.geeksforgeeks.org/problems/max-min/1
 *   @param n = size of array
 */
private fun findSum(arr: IntArray, n: Int): Int {

    var maxi = Int.MIN_VALUE
    var mini = Int.MAX_VALUE

    for (i in 0..< n) {
        if (arr[i] > maxi) {
            maxi = arr[i]
        }
        if (arr[i] < mini) {
            mini = arr[i]
        }
    }

    return maxi + mini
}



