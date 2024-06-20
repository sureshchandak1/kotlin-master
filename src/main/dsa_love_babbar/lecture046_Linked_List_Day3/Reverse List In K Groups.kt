package lecture046_Linked_List_Day3

import lecture045_Linked_List_Day2.Node

fun main() {

}

private fun kReverse(head: Node?, k: Int): Node? {

    // Base case
    if (head == null) {
        return null
    }

    val len = getLength(head)
    if (k > len) {
        return head
    }

    var prev: Node? = null
    var curr: Node? = head
    var next: Node? = null

    var count = 0

    while (curr != null && count < k) {
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next

        count++
    }

    if (next != null) {
        head.next = kReverse(next, k)
    }

    return prev
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