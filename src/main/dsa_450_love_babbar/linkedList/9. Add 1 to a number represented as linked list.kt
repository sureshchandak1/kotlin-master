package linkedList

/**
 *    https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
 *    Time Complexity: O(N)
 *    Space Complexity: O(1)
 */
fun main() {
    var ll = SingleLinkedList()

    ll.insertAtTail(4)
    ll.insertAtTail(5)
    ll.insertAtTail(6)

    ll.head = addOne(ll.head)
    ll.print(ll.head)

    ll = SingleLinkedList()

    ll.insertAtTail(9)
    ll.insertAtTail(9)
    ll.insertAtTail(9)

    ll.head = addOne(ll.head)
    ll.print(ll.head)
}

private fun addOne(head: ListNode<Int>?): ListNode<Int>? {

    if (head == null) {
        return null
    }

    // reverse linked list
    val reverseHead: ListNode<Int>? = reverseLinkedList(head)

    var lastNode: ListNode<Int>? = null
    var curr: ListNode<Int>? = reverseHead

    var carry = 1
    // add 1 on curr node, if carry present then add to next node
    while (curr != null && carry != 0) {
        val sum: Int = curr.data + carry
        curr.data = sum % 10
        carry = sum / 10

        lastNode = curr
        curr = curr.next
    }

    // If carry present then add new node
    if (carry > 0) {
        lastNode?.next = ListNode(carry)
    }

    // reverse list
    val newHead: ListNode<Int>? = reverseLinkedList(reverseHead)

    return newHead
}

private fun reverseLinkedList(head: ListNode<Int>?): ListNode<Int>? {

    if (head == null || head.next == null) {
        return head
    }

    var prev: ListNode<Int>? = null
    var curr: ListNode<Int>? = head

    while (curr != null) {
        val next: ListNode<Int>? = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}




