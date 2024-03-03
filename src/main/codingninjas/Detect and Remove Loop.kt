fun main() {

}

private fun removeLoop(head: Node?): Node? {
    removeLoop1(head)
    return head
}

private fun removeLoop1(head: Node?) {
    if (head == null) {
        return
    }

    val startOfLoop = getLoopStartingNode(head) ?: return

    var temp: Node? = startOfLoop

    while (temp?.next != startOfLoop) {
        temp = temp?.next
    }

    temp.next = null
}

private fun detectLoop(head: Node?): Boolean {
    if (head == null) {
        return false
    }

    val visited: MutableMap<Node, Boolean> = HashMap()

    var curr = head

    while (curr != null) {
        // detect loop is present

        if (visited[curr]!!) {
            return true
        }

        visited[curr] = true

        curr = curr.next
    }

    return false
}

private fun floydDetectLoop(head: Node?): Node? {
    if (head == null) {
        return null
    }

    var slow = head // move 1 step
    var fast = head // move 2 step

    while (fast != null && slow != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
        }

        slow = slow.next

        // detect loop is present
        if (fast == slow) {
            return slow
        }
    }

    return null
}

private fun getLoopStartingNode(head: Node?): Node? {
    if (head == null) {
        return null
    }

    var intersection: Node? = floydDetectLoop(head) ?: return null
    var slow = head

    while (slow != intersection) {
        slow = slow!!.next
        intersection = intersection!!.next
    }

    return slow
}