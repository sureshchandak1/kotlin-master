package array

import printArray
import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
 *    Time Complexity:  O((n+m) log(n+m))
 *    Space Complexity: O(1)
 */
fun main() {
    var arr1 = longArrayOf(1, 3, 5, 7)
    var arr2 = longArrayOf(0, 2, 6, 8, 9)
    merge(arr1, arr2, arr1.size, arr2.size)
    print(arr1, arr2, arr1.size, arr2.size)

    arr1 = longArrayOf(1, 1, 1, 1, 2)
    arr2 = longArrayOf(0, 1, 2, 2, 3, 3, 5)
    merge(arr1, arr2, arr1.size, arr2.size)
    print(arr1, arr2, arr1.size, arr2.size)

    arr1 = longArrayOf(1, 2, 3, 0, 0, 0)
    arr2 = longArrayOf(2, 5, 6)
    mergeInSingleArray(arr1, 3, arr2, 3)
    printArray(arr1)

    arr1 = longArrayOf(1, 3, 5, 7, 0, 0, 0, 0, 0)
    arr2 = longArrayOf(0, 2, 6, 8, 9)
    mergeInSingleArray(arr1, 4, arr2, 5)
    printArray(arr1)
}

private fun merge(arr1: LongArray, arr2: LongArray, n: Int, m: Int) {

    var left = n - 1
    var right = 0

    while (left >= 0 && right < m) {
        if (arr1[left] > arr2[right]) {
            val temp = arr1[left]
            arr1[left] = arr2[right]
            arr2[right] = temp

            left--
            right++

        } else {
            break
        }
    }

    Arrays.sort(arr1)
    Arrays.sort(arr2)
}

/**
 *    O(m + n)
 */
private fun mergeInSingleArray(nums1: LongArray, m: Int, nums2: LongArray, n: Int) {

    var i = m - 1
    var j = n - 1
    var k = (m + n) - 1

    while (j >= 0) {
        if (i < 0 || nums1[i] <= nums2[j]) {
            nums1[k] = nums2[j--]
        } else {
            nums1[k] = nums1[i--]
        }

        k--
    }

}

private fun print(arr1: LongArray, arr2: LongArray, n: Int, m: Int) {

    print("[ ")
    for (i in 0..<n + m) {
        if (i < n) {
            print("${arr1[i]} ")
        } else if (i - n < m) {
            print("${arr2[i - n]} ")
        }
    }
    print("]")
    println()
}





