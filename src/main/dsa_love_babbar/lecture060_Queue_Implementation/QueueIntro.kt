package lecture060_Queue_Implementation

import java.util.Queue

fun main() {
    val queue = ArrayDeque<Int>()

    queue.addLast(10)
    queue.addLast(20)
    queue.addLast(30)

    println(queue.toString())

    println("First = ${queue.first()}")

    println("Remove first = ${queue.removeFirst()}")

    println(queue.toString())

}