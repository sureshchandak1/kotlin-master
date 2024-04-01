package sliding_window

import printArray
import java.util.Deque
import java.util.LinkedList
import java.util.Queue


/*
*   https://www.interviewbit.com/problems/sliding-window-maximum/
* */
fun main() {
    printArray(slidingMaximum(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3))

    var arr1 = intArrayOf(648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368)
    printArray(slidingMaximum(arr1, 9))
}

private fun slidingMaximum(arr: IntArray, k: Int): ArrayList<Int> {
    val ans = ArrayList<Int>()

    val size = arr.size
    val q: Deque<Int> = LinkedList()

    var i = 0 // start
    var j = 0 // end

    while (j < size) {

        while (q.size > 0 && q.peekLast() < arr[j]) {
            q.removeLast()
        }

        q.addLast(arr[j])

        if (j - i + 1 < k) {
            j++
        } else if (j - i + 1 == k) {
            ans.add(q.peekFirst())

            if (arr[i] == q.peekFirst()) {
                q.removeFirst()
            }

            i++
            j++
        }
    }

    return ans
}