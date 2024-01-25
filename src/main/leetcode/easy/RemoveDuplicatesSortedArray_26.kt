package easy

fun main() {
    println(removeDuplicates(intArrayOf(1, 1, 2, 2, 3)))
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