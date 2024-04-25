package linkedList

/**
 *   https://leetcode.com/problems/linked-list-cycle/description/
 *   https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
 */
fun main() {

    var linkedList = SingleLinkedList()
    linkedList.head = ListNode(3)
    val loopNode = ListNode(2)
    linkedList.head?.next = loopNode
    linkedList.head?.next?.next = ListNode(0)
    linkedList.head?.next?.next?.next = ListNode(-4)
    linkedList.head?.next?.next?.next?.next = loopNode

    println(detectCycle(linkedList.head))

    linkedList = SingleLinkedList()
    linkedList.head = ListNode(1)

    println(detectCycle(linkedList.head))
}

/**
 *     Tortoise and Hare Algorithm
 *     Floyd’s Cycle-Finding Algorithm
 *     Time Complexity: O(N), where N is the number of nodes in the linked list
 *     Space Complexity: O(1)
 */
private fun detectCycle(head: ListNode<Int>?): Boolean {

    if (head == null || head.next == null) {
        return false
    }

    var slow = head // move 1 step
    var fast = head // move 2 step

    while (slow != null && fast != null) {
        slow = slow.next

        fast = fast.next
        if (fast != null) {
            fast = fast.next
        }

        if (slow == fast) {
            return true
        }
    }

    return false
}

/**
 *      Brute Force Approach
 *      Time Complexity: O(N * 2 * log(N) )
 *      Space Complexity: O(N)
 */
private fun isCyclePresent(head: ListNode<Int>?) : Boolean {

    val visited: MutableMap<ListNode<Int>, Boolean> = HashMap()

    var curr = head
    while (curr != null) {
        if (visited.containsKey(curr)) {
            return true
        }
        visited[curr] = true
        curr = curr.next
    }

    return false
}




