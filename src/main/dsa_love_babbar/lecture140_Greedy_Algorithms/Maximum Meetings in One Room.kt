package lecture140_Greedy_Algorithms

import printArray
import kotlin.collections.ArrayList

/**
 *    https://www.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1
 *    Time Complexity: O(n * (log n))
 *    Space Complexity: O(n)
 */
fun main() {
    printArray(maxMeetings(6, intArrayOf(1, 3, 0, 5, 8, 5), intArrayOf(2, 4, 6, 7, 9, 9)))
    printArray(maxMeetings(10,
            intArrayOf(12, 6, 16, 12, 6, 9, 16, 6, 17, 5),
            intArrayOf(17, 13, 16, 18, 17, 10, 18, 12, 18, 11)
    ))
}

private fun maxMeetings(n: Int, start: IntArray, end: IntArray): MutableList<Int> {

    val meetings: MutableList<Pair> = ArrayList()

    for (i in 0..<n) {
        meetings.add(Pair(start[i], end[i], i))
    }

    meetings.sortBy { it.end }

    val result = ArrayList<Int>()
    result.add(meetings[0].pos + 1)
    var ansEnd = meetings[0].end

    for (i in 1..<n) {
        if (meetings[i].start > ansEnd) {
            result.add(meetings[i].pos + 1)
            ansEnd = meetings[i].end
        }
    }

    result.sort()

    return result
}


