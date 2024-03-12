package lecture061_Queue_Interview_Questions

import java.util.*
import kotlin.collections.ArrayDeque


fun main() {

}

private fun reverseQueue(q: Queue<Int>) {

    val s = Stack<Int>()

    while (!q.isEmpty()) {
        s.push(q.remove())
    }

    while (!s.empty()) {
        q.add(s.pop())
    }
}