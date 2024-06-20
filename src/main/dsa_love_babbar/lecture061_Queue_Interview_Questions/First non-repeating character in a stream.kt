package lecture061_Queue_Interview_Questions

import java.util.*

/*
*  https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
* */

fun main() {
    println(firstNonRepeating("aabc"))
    println(firstNonRepeating("zz"))
}

private fun firstNonRepeating(A: String): String {

    val count: MutableMap<Char, Int> = HashMap()

    val q: Queue<Char> = LinkedList()

    val size = A.length

    var ans = ""

    for (i in 0..< size) {

        val ch = A[i]

        // increase count
        count.merge(ch, 1) { a: Int?, b: Int? -> Integer.sum(a!!, b!!) }

        // push into queue
        q.add(ch)

        while (!q.isEmpty()) {
            if (count.containsKey(q.peek()) && count[q.peek()]!! > 1) {
                // repeating character
                q.remove()
            } else {
                // non repeating character
                ans += q.peek()
                break
            }
        }

        if (q.isEmpty()) {
            ans += "#"
        }
    }

    return ans
}