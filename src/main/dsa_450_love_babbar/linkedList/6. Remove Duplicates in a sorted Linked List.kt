package linkedList

/**
 *   https://www.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
 *   https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *   Time Complexity: O(N)
 *   Space Complexity: O(1)
 */
fun main() {
    var linkedList = SingleLinkedList()

    linkedList.insertAtTail(2)
    linkedList.insertAtTail(2)
    linkedList.insertAtTail(4)
    linkedList.insertAtTail(5)

    linkedList.print(linkedList.head)
    removeDuplicates1(linkedList.head)
    linkedList.print(linkedList.head)
    println("--------------------------------")

    linkedList = SingleLinkedList()

    linkedList.insertAtTail(2)
    linkedList.insertAtTail(2)
    linkedList.insertAtTail(2)
    linkedList.insertAtTail(2)

    linkedList.print(linkedList.head)
    removeDuplicates2(linkedList.head)
    linkedList.print(linkedList.head)
}

private fun removeDuplicates1(head: ListNode<Int>?): ListNode<Int>? {

    if (head == null || head.next == null) {
        return head
    }

    var curr: ListNode<Int>? = head

    while (curr != null) {

        var next: ListNode<Int>? = curr.next
        while (next != null && curr.data == next.data) {
            next = next.next
        }

        curr.next = next
        curr = next
    }

    return head
}

private fun removeDuplicates2(head: ListNode<Int>?): ListNode<Int>? {

    if (head == null) {
        return null
    }

    var prev: ListNode<Int>? = head
    var curr: ListNode<Int>? = head.next

    while (curr != null) {
        if (prev!!.data == curr.data) {
            val temp: ListNode<Int>? = curr.next
            prev.next = temp
            curr = temp
        } else {
            prev = curr
            curr = curr.next
        }
    }

    return head
}





