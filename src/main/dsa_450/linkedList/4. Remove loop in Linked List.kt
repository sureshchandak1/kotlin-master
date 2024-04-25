package linkedList

/**
 *   https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
 *   Time Complexity: O(N)
 *   Space Complexity: O(1)
 */
fun main() {
    val linkedList = SingleLinkedList()

    linkedList.insertAtTail(1)
    linkedList.insertAtTail(3)
    linkedList.insertAtTail(4)
    linkedList.insertAtTail(5)
    linkedList.insertAtTail(6)
    linkedList.insertAtTail(7)
    linkedList.insertAtTail(8)
    linkedList.insertAtTail(9)

    // create loop in linked list and connect last node to x position node
    linkedList.makeLoop(4) // 1-based index

    println("Loop start node = ${getLoopStartingNode(linkedList.head)?.data}")

    removeLoop(linkedList.head)

    linkedList.print(linkedList.head)
}

private fun removeLoop(head: ListNode<Int>?) {

    if (head == null || head.next == null) {
        return
    }

    val loopStartNode: ListNode<Int>? = getLoopStartingNode(head)

    if (loopStartNode != null) {
        var loopEndNode: ListNode<Int>? = loopStartNode

        while (loopEndNode != null && loopEndNode.next !== loopStartNode) {
            //System.out.println(loopEndNode.data);
            loopEndNode = loopEndNode.next
        }

        loopEndNode?.next = null
    }
}

private fun getLoopStartingNode(head: ListNode<Int>?): ListNode<Int>? {

    if (head == null) {
        return null
    }

    var intersection: ListNode<Int>? = floydDetectLoop(head)

    if (intersection != null) {
        var slow: ListNode<Int>? = head

        while (slow != intersection) {
            slow = slow?.next
            intersection = intersection?.next
        }

        return slow
    }

    return null
}

private fun floydDetectLoop(head: ListNode<Int>?): ListNode<Int>? {

    if (head == null) {
        return null
    }

    var slow: ListNode<Int>? = head // move 1 step
    var fast: ListNode<Int>? = head // move 2 step

    while (slow != null && fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next?.next

        if (slow == fast) {
            return slow
        }
    }

    return null
}






