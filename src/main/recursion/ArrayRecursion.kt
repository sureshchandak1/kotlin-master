fun main() {
    val arr = arrayOf(1, 3, 5)
    println(isSorted(arr))
}



private fun isSorted(arr: Array<Int>, index: Int = 0) : Boolean {

    if ((arr.size - 1) == index) {
        return true
    }

    return if (arr[index] < arr[index + 1]) {
        isSorted(arr, index + 1)
    } else {
        false
    }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    for ((index, element) in nums.withIndex()) {
        val innerIndex = index + 1
        for (iIndex in innerIndex..<nums.size) {
            if (nums[iIndex] == target - element) {
                return intArrayOf(index, iIndex)
            }
        }
    }

    return intArrayOf()
}