fun main() {
    var arr = intArrayOf(3, 1, -2, -5, 2, -4)
    printArray(rearrangeArray(arr))
    arr = intArrayOf(-1, 1)
    printArray(rearrangeArray(arr))
}

private fun rearrangeArray(nums: IntArray): IntArray {

    val size = nums.size

    val result = IntArray(size)

    var i = 0 // for positive value
    var j = 1 // for negative value

    for (element in nums) {
        if (i < size && element > 0) {
            result[i] = element
            i += 2
        } else if (j < size && element < 0) {
            result[j] = element
            j += 2
        }
    }

    return result

}