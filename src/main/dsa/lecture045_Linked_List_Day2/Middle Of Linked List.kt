package lecture045_Linked_List_Day2

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

// Optimized solution
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

class Node {
    var data: Int
    var next: Node?
    var child: Node?

    constructor() {
        this.data = 0
        this.next = null
        this.child = null
    }

    constructor(data: Int) {
        this.data = data
        this.next = null
        this.child = null
    }

    constructor(data: Int, next: Node?, child: Node?) {
        this.data = data
        this.next = next
        this.child = child
    }
}
