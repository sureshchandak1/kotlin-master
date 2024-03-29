import java.util.*
import kotlin.collections.ArrayList

/*
*   https://leetcode.com/problems/minimum-absolute-difference/description/
* */
fun main() {

    var arr = intArrayOf(4,2,1,3)
    println(minimumAbsDifference(arr).joinToString())

    arr = intArrayOf(1,3,6,10,15)
    println(minimumAbsDifference(arr).joinToString())

    arr = intArrayOf(3,8,-10,23,19,-4,-14,27)
    println(minimumAbsDifference(arr).joinToString())
}

private fun minimumAbsDifference(arr: IntArray): List<List<Int>> {

    var ans: MutableList<MutableList<Int>> = ArrayList()
    Arrays.sort(arr)

    val size = arr.size
    var minDiff = Int.MAX_VALUE

    for (i in 0 ..< size - 1) {
        val diff = arr[i + 1] - arr[i]
        if (diff < minDiff) {
            minDiff = diff
            ans = ArrayList()
        }
        if (diff == minDiff) {
            val list: MutableList<Int> = ArrayList()
            list.add(arr[i])
            list.add(arr[i + 1])
            ans.add(list)
        }
    }

    return ans

}