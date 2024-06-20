package array

import printArray
import kotlin.math.max

fun main() {
    var arr1 = intArrayOf(1, 2, 4, 5, 6)
    var arr2 = intArrayOf(2, 3, 5, 7)
    doUnion1(arr1, arr1.size, arr2, arr2.size)
    doUnion2(arr1, arr1.size, arr2, arr2.size)
}

/**
 *    Time Complexity : O(m + n)
 *    Auxiliary Space: O(1)   if not consider ans
 */
private fun doUnion1(a: IntArray, n: Int, b: IntArray, m: Int): MutableList<Int> {

    val ans: MutableList<Int> = ArrayList()

    var i = 0; var j = 0

    while (i < n && j < m) {
        if (a[i] < b[j]) {
            ans.add(a[i])
            i++
        } else if (b[j] < a[i]) {
            ans.add(b[j])
            j++
        } else {
            ans.add(b[j])
            i++
            j++
        }
    }

    while (i < n) {
        ans.add(a[i])
        i++
    }

    while (j < m) {
        ans.add(b[j])
        j++
    }

    printArray(ans)
    return ans
}

/**
 *   Time Complexity: O(m*log(m) + n*log(n))
 *   Auxiliary Space: O(m + n)
 */
private fun doUnion2(a: IntArray, n: Int, b: IntArray, m: Int): Int {

    val set: MutableSet<Int> = HashSet()

    val size = max(n.toDouble(), m.toDouble()).toInt()
    var i = 0

    while (i < size) {
        if (i < n) {
            set.add(a[i])
        }
        if (i < m) {
            set.add(b[i])
        }

        i++
    }

    printArray(set)
    return set.size
}


