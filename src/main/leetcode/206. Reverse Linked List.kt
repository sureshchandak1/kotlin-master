fun main() {

}

private fun reverseList(head: ListNode?): ListNode? {

    if (head?.next == null) { // head == null || head.next == null
        return head
    }

    var prev: ListNode? = null
    var curr = head

    var forward: ListNode? = null
    while(curr != null) {
        forward = curr.next
        curr.next = prev
        prev = curr
        curr = forward
    }

    return prev
}

class ListNode(var data: Int) {
    var next: ListNode? = null
}

