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

    fun insertAtHead(data: Int) {
        val newNode = ListNode(data)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head = newNode
        }
    }

    fun insertAtPosition(data: Int, position: Int) {
        val newNode = ListNode(data)
        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            if (position == 1) {
                insertAtHead(data)
                return
            }

            var curr = head
            var count = 1 // start from head

            while (count < position - 1) {
                count++
                curr = curr?.next
            }

            curr?.let {
                if (curr.next == null) {
                    insertAtTail(data)
                } else {
                    newNode.next = curr.next
                    curr.next = newNode
                }
            }
        }

    }

    fun getSize(head: ListNode<Int>?): Int {
        if (head == null) {
            return 0
        }

        var size = 0
        var curr = head

        while (curr != null) {
            size++
            curr = curr.next
        }

        return size
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