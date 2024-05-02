package stacks_and_queues

fun main() {
    val s = Stack(2)

    s.push(10)
    s.push(20)
    s.push(30)

    s.print()
    s.pop()
    s.print()

    s.push(10)
    s.push(20)
    s.push(30)
    s.print()

    s.push(60)
}

private class Stack(private val size: Int) {

    val arr = IntArray(size)
    var top = -1

    fun push(data: Int) {
        if (size - top > 1) {
            top++
            arr[top] = data
        } else {
            println("Stack OverFlow")
        }
    }

    fun pop() {
        if (top >= 0) {
            top--
        } else {
            println("Stack Empty")
        }
    }

    fun peek(): Int {
        if (top >= 0) {
            return arr[top]
        } else {
            println("Stack Empty")
            return -1
        }
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

    fun size(): Int {
        return top + 1
    }

    fun print() {
        print("[")
        for (i in 0 .. top) {
            print(arr[i])
            if (i != top) {
                print(", ")
            }
        }
        print("]")
        println()
    }

}