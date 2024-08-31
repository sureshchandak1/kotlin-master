package lecture140_Greedy_Algorithms

import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 *    Time Complexity: O(n * (log n))
 *    Space Complexity: O(n)
 */
fun main() {
    println(maxMeetings(6, intArrayOf(1, 3, 0, 5, 8, 5), intArrayOf(2, 4, 6, 7, 9, 9)))
    println(maxMeetings(3, intArrayOf(10, 12, 20), intArrayOf(20, 25, 30)))
}

private fun maxMeetings(n: Int, start: IntArray, end: IntArray): Int {
    val meetings: MutableList<Pair> = ArrayList()

    for (i in 0..<n) {
        meetings.add(Pair(start[i], end[i]))
    }

    Collections.sort(meetings, MyComparator())

    var count = 1
    var ansEnd = meetings[0].end

    for (i in 1..<n) {
        if (meetings[i].start > ansEnd) {
            count++
            ansEnd = meetings[i].end
        }
    }

    return count
}

private class MyComparator : Comparator<Pair> {
    override fun compare(p1: Pair, p2: Pair): Int {
        return p1.end.compareTo(p2.end)
    }
}

internal class Pair(start: Int, end: Int, pos: Int = 0) {
    var start: Int = 0
    var end: Int = 0
    var pos: Int = 0

    init {
        this.start = start
        this.end = end
        this.pos = pos
    }
}


