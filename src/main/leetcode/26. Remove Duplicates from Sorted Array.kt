fun main() {
    val arr1 = intArrayOf(1, 3, 3, 3, 4, 5)
    printArray(arr1)
    println(removeDuplicates(arr1))
}

private fun removeDuplicates(nums: IntArray): Int {

    var count = 0

    for (element in nums) {
        if (count == 0 || element != nums[count - 1]) {
            nums[count] = element
            ++count
        }
    }

    return count

}