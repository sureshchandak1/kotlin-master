package array

import printArray

/**
 *   https://leetcode.com/problems/rearrange-array-elements-by-sign/
 *   https://www.geeksforgeeks.org/rearrange-array-in-alternating-positive-negative-items-with-o1-extra-space-set-2/
 */
fun main() {
    var arr = intArrayOf(1, 2, 3, -4, -1, 4)
    printArray(arr)
    printArray(rearrangeArray(arr))
    println("---------------------------------------")
    arr = intArrayOf(-5, -2, 5, 2, 4, 7, 1, 8, 0, -8)
    printArray(arr)
    printArray(rearrangeArray(arr))
    println("---------------------------------------")
    arr = intArrayOf(1, 2, 3, -4, -1, 4)
    printArray(arr)
    rearrangeArray(arr, arr.size)
    println("---------------------------------------")
    arr = intArrayOf(-5, -2, 5, 2, 4, 7, 1, 8, 0, -8)
    printArray(arr)
    rearrangeArray(arr, arr.size)
}

/**
 *    Time Complexity : O(N), where N in size of array
 *    Space Complexity : O(N)
 */
private fun rearrangeArray(nums: IntArray): IntArray {

    val size = nums.size

    val result = IntArray(size)

    var i = 0 // for positive value (even position)
    var j = 1 // for negative value (odd position)

    for (element in nums) {
        if (i < size && element > 0) {
            result[i] = element
            i += 2 // i = 0, 2, 4, 6, 8
        } else if (j < size && element < 0) {
            result[j] = element // //add negative number at odd position
            j += 2 // j = 1, 3, 5, 7, 9
        }
    }

    return result

}

/**
 *    Time Complexity : O(N), where N in size of array
 *    Space Complexity : O(1)
 */
private fun rearrangeArray(arr: IntArray, n: Int) {

    var i = 0; var j = n - 1

    // shift all negative values to the end
    while (i < j) {
        while (i < n && arr[i] >= 0) {
            i += 1
        }

        while (j >= 0 && arr[j] < 0) {
            j -= 1
        }

        if (i < j) {
            swap(arr, i, j)
        }
    }

    printArray(arr)

    if (i == 0 || i == n) {
        return
    }

    // i is negative number starting index
    var k = 0
    while (k < n && i < n) {
        swap(arr, k , i)
        k += 2
        i += 1
    }

    printArray(arr)

}

private fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}




