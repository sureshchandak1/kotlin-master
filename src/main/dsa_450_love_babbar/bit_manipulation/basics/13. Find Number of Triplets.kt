package bit_manipulation.basics

/**
 *    https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/
 */
fun main() {
    var arr = intArrayOf(2, 3, 1, 6, 7)
    println(countTriplets(arr))

    arr = intArrayOf(1, 1, 1, 1, 1)
    println(countTriplets(arr))
}

private fun countTriplets(arr: IntArray): Int {

    var count = 0

    for (i in arr.indices) {

        var value = arr[i]

        for (k in i + 1..<arr.size) {
            value = value xor arr[k]

            if (value == 0) {
                count += k - i
            }
        }
    }

    return count
}








