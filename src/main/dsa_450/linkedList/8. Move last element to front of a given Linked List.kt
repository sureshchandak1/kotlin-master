package linkedList

/**
 *    https://www.geeksforgeeks.org/move-last-element-to-front-of-a-given-linked-list/
 *    Time Complexity: O(N)
 *    Space Complexity: O(1)
 */
fun main() {
    val linkedList = SingleLinkedList()

    linkedList.insertAtTail(1)
    linkedList.insertAtTail(2)
    linkedList.insertAtTail(3)
    linkedList.insertAtTail(4)
    linkedList.insertAtTail(5)

    linkedList.print(linkedList.head)

    linkedList.head = moveFront(linkedList.head)

    linkedList.print(linkedList.head)
}

private fun moveFront(head: ListNode<Int>?) : ListNode<Int>? {

    if (head == null || head.next == null) {
        return head
    }

    var secLast: ListNode<Int>? = null
    var last: ListNode<Int>? = head

    while (last != null && last.next != null) {
        secLast = last
        last = last.next
    }

    secLast?.next = null

    last?.next = head

    return last
}




