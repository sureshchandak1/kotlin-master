fun main() {

}

private fun findMiddle(head: Node?): Node? {
    return findMiddleNode2(head)
}

private fun findMiddleNode1(head: Node): Node? {
    val length = getLength(head)

    val mid = (length / 2) + 1

    var curr: Node? = head
    var count = 1
    while (count < mid) {
        count++
        curr = curr!!.next
    }

    return curr
}

private fun findMiddleNode2(head: Node?): Node? {
    if (head?.next == null) {
        return head
    }

    // only 2 node in linked list
    if (head.next!!.next == null) {
        return head.next
    }

    var slow = head
    var fast = head.next

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
        }

        slow = slow!!.next
    }

    return slow
}

private fun getLength(head: Node): Int {
    var len = 0
    var curr: Node? = head
    while (curr != null) {
        len++
        curr = curr.next
    }

    return len
}