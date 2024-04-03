package lecture078_Hashmaps

import kotlin.math.max

/*
*   https://www.naukri.com/code360/problems/maximum-frequency-number_920319
* */
fun main() {
    var arr = intArrayOf(59, 52, 62, 55, 54, 57, 59, 50, 58, 64, 54, 59, 64, 55, 53, 56, 56, 59, 65, 51, 52, 50, 53, 57, 59)
    println(maxFrequencyNumber(arr.size, arr))

    arr = intArrayOf(-1, 0, 0, 5, 9, 8, 6, -2, 8, 2, 10, 0, 9, 6, 3)
    println(maxFrequencyNumber(arr.size, arr))

}

private fun maxFrequencyNumber(n: Int, arr: IntArray): Int {
    return maxFrequency1(n, arr)
}

private fun maxFrequency1(n: Int, arr: IntArray): Int {

    val count: MutableMap<Int, Int> = HashMap()

    var maxFreq = 0

    for (i in 0..< n) {
        count.merge(arr[i], 1) { a: Int?, b: Int? ->
            Integer.sum(
                a!!,
                b!!
            )
        }
        maxFreq = max(maxFreq.toDouble(), count[arr[i]]!!.toDouble()).toInt()
    }

    var ans = -1

    for (i in 0..< n) {
        if (maxFreq == count[arr[i]]) {
            ans = arr[i]
            break
        }
    }

    return ans
}

private fun maxFrequency2(n: Int, arr: IntArray): Int {
    val count: MutableMap<Int, Int> = LinkedHashMap()

    for (i in 0..< n) {
        count.merge(arr[i], 1) { a: Int?, b: Int? ->
            Integer.sum(
                a!!,
                b!!
            )
        }
    }

    var maxi = Int.MIN_VALUE
    var ans = -1

    for ((key, value) in count) {
        if (value > maxi) {
            maxi = value
            ans = key
        }
    }

    return ans
}






