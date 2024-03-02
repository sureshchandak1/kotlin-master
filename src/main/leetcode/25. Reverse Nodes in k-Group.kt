fun main() {

}

private fun reverseKGroup(head: ListNode?, k: Int): ListNode? {

    // Base case
    if (head == null) {
        return null
    }

    val len = getLength(head)
    if (k > len) {
        return head
    }

    var prev: ListNode? = null
    var curr: ListNode? = head
    var next: ListNode? = null

    var count = 0
    while (curr != null && count < k) {
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next

        count++
    }

    head.next = reverseKGroup(next, k)

    return prev
}

private fun getLength(head: ListNode?): Int {

    var curr = head
    var count = 0

    while (curr != null) {
        count++
        curr = curr.next
    }

    return count

}