package linkedList

/**
 *   https://leetcode.com/problems/reverse-linked-list/
 *   Time Complexity: O(N)
 *   Space Complexity: O(1)
 */
fun main() {
    val linkedList = SingleLinkedList()

    linkedList.insertAtTail(1)
    linkedList.insertAtTail(2)
    linkedList.insertAtTail(3)
    linkedList.insertAtTail(4)
    linkedList.insertAtTail(5)

    linkedList.print(linkedList.head)
    var reverseHead = reverseLinkedList(linkedList.head)
    linkedList.print(reverseHead)
    reverseHead = reverseList(reverseHead)
    linkedList.print(reverseHead)
}

private fun reverseList(head: ListNode<Int>?): ListNode<Int>? {

    if (head == null || head.next == null) {
        return head
    }

    var prev: ListNode<Int>? = null
    var curr: ListNode<Int>? = head
    var next: ListNode<Int>? = null

    while (curr != null) {
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}

private fun reverseLinkedList(head: ListNode<Int>?): ListNode<Int>? {

    // Base case
    if (head == null || head.next == null) {
        return head
    }

    val newHead = reverseLinkedList(head.next)

    val front = head.next

    front?.next = head

    head.next = null

    return newHead
}






