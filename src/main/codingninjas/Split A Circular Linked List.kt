fun main() {

}

private fun splitCircularList(head: LinkedListNode<Int>?) {

    if (head == null) {
        return
    }

    var slow = head
    var fast = head

    while (fast!!.next != head && fast.next!!.next != head) {
        slow = slow!!.next // slow move 1 step
        fast = fast.next!!.next // fast move 2 step
    }

    // If there are an even number of elements, move 'fast' to the very end of the list
    if (fast.next != head) {
        fast = fast.next
    }

    val secondHead = slow!!.next

    fast!!.next = secondHead
    slow.next = head
}

private fun getLength(head: LinkedListNode<Int>?): Int {
    if (head == null) {
        return 0
    }

    var len = 1
    var curr = head.next

    while (curr != head) {
        len++
        curr = curr!!.next
    }

    return len
}