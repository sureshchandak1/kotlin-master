package lecture045_Linked_List_Day2

fun main() {

}

private class LinkedListNode<T>(var data: T) {
    var next: LinkedListNode<T>? = null
}

/*
*  Time complexity - O(n)
*  Space complexity - O(1)
* */

private fun reverseLinkedList(head: LinkedListNode<Int>?): LinkedListNode<Int>? {

    if (head?.next == null) { // (head == null || head.next == null) same (head?.next == null)
        return head
    }

    var prev: LinkedListNode<Int>? = null
    var curr: LinkedListNode<Int>? = head

    var forward: LinkedListNode<Int>? = null
    while (curr != null) {
        forward = curr.next
        curr.next = prev
        prev = curr
        curr = forward
    }

    return prev
}