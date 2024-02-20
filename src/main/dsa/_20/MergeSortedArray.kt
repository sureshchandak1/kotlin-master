package _20

import printArray

fun main() {
    val arr1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val arr2 = intArrayOf(2, 5, 6)

    val arr3 = mergeSortedArray(arr1, 3, arr2, 3)
    printArray(arr3)
    merge(arr1, 3, arr2, 3)
}

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

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

    printArray(nums1)

}

fun mergeSortedArray(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {

    val newArr = IntArray(m + n) { 0 }

    var i = 0
    var j = 0
    var k = 0

    while (i < m && i < n) {

        if (nums1[i] < nums2[j]) {
            newArr[k++] = nums1[i++]
        } else {
            newArr[k++] = nums2[j++]
        }

    }

    while (i < m) {
        newArr[k++] = nums1[i++]
    }

    while (j < n) {
        newArr[k++] = nums2[j++]
    }

    return newArr
}