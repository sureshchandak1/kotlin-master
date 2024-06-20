package linkedList

/**
 *   https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *   https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 */
fun main() {
    val linkedList = SingleLinkedList()

    linkedList.insertAtTail(1)
    linkedList.insertAtTail(2)
    linkedList.insertAtTail(2)
    linkedList.insertAtTail(4)
    linkedList.insertAtTail(5)
    linkedList.insertAtTail(6)
    linkedList.insertAtTail(7)
    linkedList.insertAtTail(8)

    linkedList.print(linkedList.head)
    val reverseNode = reverse(linkedList.head, 4)
    linkedList.print(reverseNode)
}

/**
 *   Time Complexity: O(N)
 *   Space Complexity: O(1)
 */
private fun reverse(node: ListNode<Int>?, k: Int): ListNode<Int>? {

    // Base case
    if (node == null) {
        return null
    }

    /*
    val len = getLength(node)
    if (k > len) {
        return node
    }
    */

    var prev: ListNode<Int>? = null
    var curr: ListNode<Int>? = node
    var next: ListNode<Int>? = null

    var count = 0

    while (curr != null && count < k) {
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next

        count++
    }

    node.next = reverse(next, k)

    return prev
}

private fun getLength(node: ListNode<Int>): Int {
    var len = 0

    var curr: ListNode<Int>? = node
    while (curr != null) {
        len++
        curr = curr.next
    }

    return len
}


