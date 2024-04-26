package linkedList

/**
 *    https://leetcode.com/problems/linked-list-cycle-ii/description/
 *    Time Complexity: O(N)
 *    Space Complexity: O(1)
 */
fun main() {
    val linkedList = SingleLinkedList()

    linkedList.insertAtTail(3)
    linkedList.insertAtTail(10)
    linkedList.insertAtTail(16)
    linkedList.insertAtTail(15)
    linkedList.insertAtTail(11)
    linkedList.insertAtTail(6)
    linkedList.insertAtTail(8)

    // create loop in linked list and connect last node to x position node
    linkedList.makeLoop(7) // 1-based index

    println("Loop start node = ${detectCycle(linkedList.head)?.data}")
}

private fun detectCycle(head: ListNode<Int>?): ListNode<Int>? {

    if (head == null || head.next == null) {
        return null
    }

    var intersection: ListNode<Int>? = floydDetectLoop(head)
    if (intersection != null) {
        println("Intersection node : ${intersection.data}")

        var slow = head

        print("Slow = ")
        while (slow != intersection) {
            print("${slow?.data}, ")
            slow = slow?.next
            intersection = intersection?.next
        }
        println()

        return slow
    }

    return null
}

private fun floydDetectLoop(head: ListNode<Int>?) : ListNode<Int>? {

    var slow = head // move 1 step
    var fast = head // move 2 step

    while (slow != null && fast != null) {
        slow = slow.next

        fast = fast.next
        if (fast != null) {
            fast = fast.next
        }

        if (slow == fast) {
            return slow
        }
    }

    return null
}




