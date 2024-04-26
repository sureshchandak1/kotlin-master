package linkedList

/**
 *   https://www.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
 *   Time Complexity: O(N)
 *   Space Complexity: O(N)
 */
fun main() {
    val linkedList = SingleLinkedList()

    linkedList.insertAtTail(5)
    linkedList.insertAtTail(4)
    linkedList.insertAtTail(2)
    linkedList.insertAtTail(2)
    linkedList.insertAtTail(3)
    linkedList.insertAtTail(4)
    linkedList.insertAtTail(3)
    linkedList.insertAtTail(7)

    linkedList.print(linkedList.head)

    removeDuplicates(linkedList.head)

    linkedList.print(linkedList.head)
}

private fun removeDuplicates(head: ListNode<Int>?): ListNode<Int>? {

    if (head == null || head.next == null) {
        return head
    }

    val visited: MutableMap<Int, Boolean> = HashMap()

    var prev: ListNode<Int>? = null
    var curr: ListNode<Int>? = head

    while (curr != null) {
        if (visited.containsKey(curr.data)) {
            prev?.next = curr.next
        } else {
            visited[curr.data] = true

            prev = curr
        }

        curr = curr.next
    }

    return head
}





