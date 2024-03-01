fun main() {

}

private fun findMiddleNode(head: ListNode?): ListNode? {

    if (head?.next == null) { // head == null || head.next == null
        return head
    }

    // only 2 node in linked list
    if (head.next?.next == null) {
        return head.next
    }

    var slow = head
    var fast = head.next

    while (fast != null) {
        fast = fast.next
        if (fast != null) {
            fast = fast.next
        }

        slow = slow?.next
    }

    return slow

}
