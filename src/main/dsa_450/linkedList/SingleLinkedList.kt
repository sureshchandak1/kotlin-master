package linkedList

internal class SingleLinkedList {

    var head: ListNode<Int>? = null
    var tail: ListNode<Int>? = null

    fun insertAtTail(data: Int) {
        val node = ListNode(data)
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            tail = node
        }
    }

    fun print(head: ListNode<Int>?) {
        print("[")
        var curr = head
        while (curr != null) {
            print(curr.data)
            if (curr.next != null) {
                print(", ")
            }
            curr = curr.next
        }
        print("]")
        println()
    }
}