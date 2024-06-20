package lecture061_Queue_Interview_Questions

import java.util.Deque
import java.util.LinkedList

/*
*   https://www.geeksforgeeks.org/sum-minimum-maximum-elements-subarrays-size-k/
*
* */
fun main() {
    val arr = intArrayOf(2, 5, -1, 7, -3, -1, -2)
    val k = 4
    println(solve(arr, arr.size, k))
}

fun solve(arr: IntArray, size: Int, k: Int): Int {

    val maxi: Deque<Int> = LinkedList()
    val mini: Deque<Int> = LinkedList()

    // Addition of first k size window
    for (i in 0 ..< k) {

        while (!maxi.isEmpty() && arr[maxi.last] <= arr[i]) {
            maxi.removeLast()
        }

        while (!mini.isEmpty() && arr[mini.last] >= arr[i]) {
            mini.removeLast()
        }

        maxi.addLast(i)
        mini.addLast(i)
    }

    var ans = 0
    ans += arr[maxi.first] + arr[mini.first]

    // remaining windows process
    for (i in k ..< size) {

        // next window

        // removal
        while (!maxi.isEmpty() && i - maxi.first >= k) {
            maxi.removeFirst()
        }
        while (!mini.isEmpty() && i - mini.first >= k) {
            mini.removeFirst()
        }

        // addition
        while (!maxi.isEmpty() && arr[maxi.last] <= arr[i]) {
            maxi.removeLast()
        }
        while (!mini.isEmpty() && arr[mini.last] >= arr[i]) {
            mini.removeLast()
        }
        maxi.addLast(i)
        mini.addLast(i)

        ans += arr[maxi.first] + arr[mini.first]
    }

    return ans
}



