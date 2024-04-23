package array

import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/common-elements1132/1
 *    Time Complexity: O(n1 + n2 + n3)
 *    Space Complexity: O(n1 + n2 + n3)
 */
fun main() {
    var arr1 = intArrayOf(1, 5, 10, 20, 40, 80)
    var arr2 = intArrayOf(6, 7, 20, 80, 100)
    var arr3 = intArrayOf(3, 4, 15, 20, 30, 70, 80, 120)
    println(findCommonElements(arr1, arr2, arr3, arr1.size, arr2.size, arr3.size))
    println(findCommonElements2(arr1, arr2, arr3, arr1.size, arr2.size, arr3.size))

    arr1 = intArrayOf(3, 3, 3)
    arr2 = intArrayOf(3, 3, 3)
    arr3 = intArrayOf(3, 3, 3)
    println(findCommonElements(arr1, arr2, arr3, arr1.size, arr2.size, arr3.size))
    println(findCommonElements2(arr1, arr2, arr3, arr1.size, arr2.size, arr3.size))

}

private fun findCommonElements(arr1: IntArray, arr2: IntArray, arr3: IntArray, n1: Int, n2: Int, n3: Int): ArrayList<Int> {

    val map: MutableMap<Int, Int> = TreeMap()

    for (i in 0..< n1) {
        if (!map.containsKey(arr1[i])) {
            map.merge(arr1[i], 1) { a: Int?, b: Int? ->
                Integer.sum(a!!, b!!)
            }
        }
    }

    for (i in 0..< n2) {
        if (map.getOrDefault(arr2[i], 0) == 1) {
            map.merge(arr2[i], 1) { a: Int?, b: Int? ->
                Integer.sum(a!!, b!!)
            }
        }
    }

    for (i in 0..< n3) {
        if (map.getOrDefault(arr3[i], 0) == 2) {
            map.merge(arr3[i], 1) { a: Int?, b: Int? ->
                Integer.sum(a!!, b!!)
            }
        }
    }

    val result = ArrayList<Int>()

    for ((key, value) in map) {
        if (value == 3) {
            result.add(key)
        }
    }

    return result
}

private fun findCommonElements2(arr1: IntArray, arr2: IntArray, arr3: IntArray, n1: Int, n2: Int, n3: Int): ArrayList<Int> {

    var i = 0
    var j = 0
    var k = 0

    val ans: MutableSet<Int> = TreeSet()

    while (i < n1 && j < n2 && k < n3) {
        if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
            ans.add(arr1[i])
            i++
            j++
            k++
        } else if (arr1[i] < arr2[j]) {
            i++
        } else if (arr2[j] < arr3[k]) {
            j++
        } else {
            k++
        }
    }

    return ArrayList(ans)
}






