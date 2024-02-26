package lecture044_Linked_List_Day1

class SingleLinkedList {

    var head: Node? = null // head of list (Starting node)
    var tail: Node? = null // end of list (Ending node)

    companion object {

        class Node(var data: Int) {
            var next: Node? = null
        }

        fun insertAtHead(linkedList: SingleLinkedList, data: Int): SingleLinkedList {
            val newHead = Node(data)
            if (linkedList.head == null) {
                linkedList.head = newHead
                linkedList.tail = newHead
            } else {
                newHead.next = linkedList.head
                linkedList.head = newHead
            }

            return linkedList
        }

        fun insertAtTail(linkedList: SingleLinkedList, data: Int): SingleLinkedList {
            val newHead = Node(data)
            if (linkedList.head == null) {
                linkedList.head = newHead
                linkedList.tail = newHead
            } else {
                /*
                var lastNode = linkedList.head
                while (lastNode?.next != null) {
                    lastNode = lastNode.next
                }

                lastNode?.next = newHead
                */

                linkedList.tail?.next = newHead
                linkedList.tail = newHead
            }

            return linkedList
        }

        fun insertAtPosition(linkedList: SingleLinkedList, data: Int, position: Int): SingleLinkedList {
            val newNode = Node(data)
            if (linkedList.head == null) {
                linkedList.head = newNode
                linkedList.tail = newNode
            } else {
                var count = 1
                var currentNode = linkedList.head
                while (count < position) {
                    count++
                    if (count < position) {
                        currentNode = currentNode?.next
                    }
                }

                if (currentNode != null) {
                    if (currentNode.next == null) {
                        currentNode.next = newNode
                        linkedList.tail = newNode
                    } else {
                        val nextNode = currentNode.next

                        currentNode.next = newNode
                        newNode.next = nextNode
                    }
                }

            }

            return linkedList
        }

        fun insert(linkedList: SingleLinkedList, data: Int): SingleLinkedList {
            val newHead = Node(data)

            if (linkedList.head == null) {
                linkedList.head = newHead
                linkedList.tail = newHead
            } else {
                var lastNode = linkedList.head
                while (lastNode?.next != null) {
                    lastNode = lastNode.next
                }

                lastNode?.next = newHead
                linkedList.tail = newHead
            }

            return linkedList
        }

        fun size(linkedList: SingleLinkedList): Int {
            var size = 0

            var currentNode = linkedList.head
            while (currentNode != null) {
                size++
                currentNode = currentNode.next
            }

            return size
        }

        fun printLinkedList(linkedList: SingleLinkedList) {
            var currentNode = linkedList.head

            while (currentNode != null) {
                print("${currentNode.data}  ")

                currentNode = currentNode.next
            }
            println()
        }

    }


}

fun main() {

    var singleLinkedList = SingleLinkedList()

    singleLinkedList = SingleLinkedList.insertAtHead(singleLinkedList, 10)
    singleLinkedList = SingleLinkedList.insertAtHead(singleLinkedList, 15)
    singleLinkedList = SingleLinkedList.insertAtHead(singleLinkedList, 20)

    singleLinkedList = SingleLinkedList.insertAtTail(singleLinkedList, 20)
    singleLinkedList = SingleLinkedList.insertAtTail(singleLinkedList, 30)
    singleLinkedList = SingleLinkedList.insert(singleLinkedList, 40)

    SingleLinkedList.printLinkedList(singleLinkedList)
    singleLinkedList = SingleLinkedList.insertAtPosition(singleLinkedList, 50, 4)
    SingleLinkedList.printLinkedList(singleLinkedList)
    singleLinkedList = SingleLinkedList.insertAtPosition(singleLinkedList, 60, 8)

    singleLinkedList = SingleLinkedList.insertAtTail(singleLinkedList, 70)

    SingleLinkedList.printLinkedList(singleLinkedList)
    println("Size = ${SingleLinkedList.size(singleLinkedList)}")


}