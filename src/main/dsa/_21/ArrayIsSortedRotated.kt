package _21

fun main() {
    println(check(intArrayOf(3, 4, 5, 1, 2)))
}

private fun check(nums: IntArray): Boolean {

    var count = 0
    val size = nums.size

    for (i in 1..<size) {
        if (nums[i - 1] > nums[i]) {
            count++
        }
    }

    if (nums[size - 1] > nums[0]) {
        count++
    }

    return count <= 1

}