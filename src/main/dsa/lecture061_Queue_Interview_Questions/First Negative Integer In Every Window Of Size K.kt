package lecture061_Queue_Interview_Questions

import printArray
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList


fun main() {
    var arr = arrayListOf(-10, 20, -30, -40, 50, 60, -70, 80, 90)
    printArray(firstNegativeInteger(arr, 3, 9))

    arr = arrayListOf(-10, 20, 30, -40, -50, 60)
    printArray(firstNegativeInteger(arr, 2, 6))

}

private fun firstNegativeInteger(arr: ArrayList<Int>, k: Int, n: Int): ArrayList<Int> {
    return negIntInWindow(arr, k, n)
}

private fun negIntInWindow(arr: ArrayList<Int>, k: Int, n: Int): ArrayList<Int> {

    val ans = ArrayList<Int>()

    val q: ArrayDeque<Int> = ArrayDeque()

    for (i in 0..< k) {
        if (arr[i] < 0) {
            q.addLast(i)
        }
    }

    if (!q.isEmpty()) {
        ans.add(arr[q.first()])
    } else {
        ans.add(0)
    }

    for (i in k..< n) {

        // removeal
        if (!q.isEmpty() && i - q.first() >= k) {
            q.removeFirst()
        }

        // addition
        if (arr[i] < 0) {
            q.addLast(i)
        }

        // ans store
        if (!q.isEmpty()) {
            ans.add(arr[q.first()])
        } else {
            ans.add(0)
        }
    }

    return ans
}