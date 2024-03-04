fun main() {

}

private fun deleteDuplicates(head: ListNode?): ListNode? {

    if (head == null) {
        return head
    }

    var curr: ListNode? = head

    while (curr != null) {

        var next: ListNode? = curr.next
        while (next != null && curr.`val` == next.`val`) {
            next = next.next
        }

        curr.next = next
        curr = next
    }

    return head
}