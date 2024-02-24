fun main() {
    val arr1 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    printArray(arr1)
    rotate(arr1, 3)
    printArray(arr1)
}

private fun rotate(nums: IntArray, k: Int): Unit {

    val size = nums.size
    val temp = IntArray(size) { 0 }

    for (i in nums.indices) {
        temp[(i + k) % size] = nums[i]
    }

    for (i in 0..<size) {
        nums[i] = temp[i]
    }

}