package sliding_window

import printArray
import java.util.*

/*
*   https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
* */
fun main() {
    printArray(printFirstNegativeInteger(longArrayOf(-8, 2, 3, -6, 10), 5, 2))
    printArray(printFirstNegativeInteger(longArrayOf(12, -1, -7, 8, -15, 30, 16, 28), 8, 3))
}

private fun printFirstNegativeInteger(arr: LongArray, n: Int, k: Int): LongArray {

    val ans = LongArray(n - k + 1)

    if (n == 0) {
        return ans
    }

    var i = 0 // Start
    var j = 0 // End

    val q: Queue<Long> = LinkedList()

    while (j < n) {

        if (arr[j] < 0) {
            q.add(arr[j])
        }

        if (j - i + 1 < k) {
            j++
        } else if (j - i + 1 == k) {
            if (q.isEmpty()) {
                ans[i] = 0
            } else {
                ans[i] = q.peek()

                if (arr[i] == q.peek()) {
                    q.remove()
                }
            }

            i++
            j++
        }
    }

    return ans
}


