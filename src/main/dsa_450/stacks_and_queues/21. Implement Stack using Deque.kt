package stacks_and_queues

fun main() {
    val s = DequeStack()
    s.push(10)
    s.push(20)
    s.push(30)
    s.print()
    println("Pop = ${s.pop()}")
    s.print()
    println("Peek = ${s.peek()}")
    s.print()
}

private class DequeStack {

    private val deque: ArrayDeque<Int> = ArrayDeque()

    fun push(data: Int) {
        deque.addLast(data)
    }

    fun pop(): Int {
        if (deque.isEmpty()) {
            return -1
        }
        return deque.removeLast()
    }

    fun peek(): Int {
        if (deque.isEmpty()) {
            return -1
        }
        return deque.last()
    }

    fun print() {
        println(deque.toString())
    }
}



