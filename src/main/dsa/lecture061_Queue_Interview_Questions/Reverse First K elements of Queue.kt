package lecture061_Queue_Interview_Questions

import java.util.*
import kotlin.collections.ArrayDeque


fun main() {
    var queue: Queue<Int> = LinkedList()
    queue.add(1)
    queue.add(2)
    queue.add(3)
    queue.add(4)
    queue.add(5)

    println(queue.toString())
    reverseElements(queue, 3)
    println(queue.toString())

    queue = LinkedList()
    queue.add(6)
    queue.add(2)
    queue.add(4)
    queue.add(1)

    println(queue.toString())
    reverseElements(queue, 2)
    println(queue.toString())
}

private fun reverseElements(q: Queue<Int>, k: Int): Queue<Int> {

    // Step 1: pop first k from Q and put into stack
    val s = Stack<Int>()

    for (i in 0..< k) {
        s.push(q.remove())
    }

    // Step 2: fetch from stack and push into q
    while (!s.empty()) {
        q.add(s.pop())
    }

    // Step 3: fetch from (n - k) element from Q and push back
    var t = (q.size - k) - 1

    while (t >= 0) {
        q.add(q.remove())
        t--
    }

    return q
}