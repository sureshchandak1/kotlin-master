fun main() {
    var nums1 = intArrayOf(1, 2, 3)
    var nums2 = intArrayOf(2, 5, 6)
    printArray(mergeSortedArrays(nums1, nums1.size, nums2, nums2.size))

    nums1 = intArrayOf(2, 4, 6, 7, 9)
    nums2 = intArrayOf(2, 4, 7, 8)
    printArray(mergeSortedArrays(nums1, nums1.size, nums2, nums2.size))

}

private fun mergeSortedArrays(arr1: IntArray, m: Int, arr2: IntArray, n: Int): IntArray {

    val ans = IntArray(m + n)
    val len1 = m
    val len2 = n

    var index1 = 0
    var index2 = 0
    var mainIndex = 0

    while (index1 < len1 && index2 < len2) {
        if (arr1[index1] < arr2[index2]) {
            ans[mainIndex++] = arr1[index1++]
        } else {
            ans[mainIndex++] = arr2[index2++]
        }
    }

    while (index1 < len1) {
        ans[mainIndex++] = arr1[index1++]
    }

    while (index2 < len2) {
        ans[mainIndex++] = arr2[index2++]
    }

    return ans
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

}