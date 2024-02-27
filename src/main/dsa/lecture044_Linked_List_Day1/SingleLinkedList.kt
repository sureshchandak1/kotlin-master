package lecture044_Linked_List_Day1

class SingleLinkedList {

    private var head: Node? = null // head of list (Starting node)
    private var tail: Node? = null // end of list (Ending node)

    companion object {

        private class Node(var data: Int) {
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

                if (position == 1) {
                    insertAtHead(linkedList, data)
                    return linkedList
                }

                var count = 1
                var currentNode = linkedList.head
                while (count < position - 1) {
                    count++
                    currentNode = currentNode?.next
                }

                if (currentNode != null) {
                    if (currentNode.next == null) {
                        insertAtTail(linkedList, data)
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

        fun deleteAtPosition(linkedList: SingleLinkedList, position: Int): SingleLinkedList {

            if (position == 1) {
                linkedList.head = linkedList.head?.next
                return linkedList
            }

            var previousNode = linkedList.head
            var currentNode = linkedList.head
            var count = 1
            while (count < position) {
                previousNode = currentNode
                currentNode = currentNode?.next
                count++
            }

            if (previousNode != null) {
                if (currentNode?.next != null) {
                    previousNode.next = currentNode.next
                } else {
                    previousNode.next = null
                    linkedList.tail = previousNode
                }
            }

            // force Java garbage collection
            System.gc()
            //Runtime.getRuntime().gc()

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

        fun printHead(linkedList: SingleLinkedList) {
            println("Head = ${linkedList.head?.data}")
        }

        fun printTail(linkedList: SingleLinkedList) {
            println("Tail = ${linkedList.tail?.data}")
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
    SingleLinkedList.printLinkedList(singleLinkedList)
    singleLinkedList = SingleLinkedList.insertAtPosition(singleLinkedList, 70, 1)

    singleLinkedList = SingleLinkedList.insertAtTail(singleLinkedList, 80)

    SingleLinkedList.printLinkedList(singleLinkedList)
    println("Delete at position")
    singleLinkedList = SingleLinkedList.deleteAtPosition(singleLinkedList, 4) // middle position
    SingleLinkedList.printLinkedList(singleLinkedList)
    singleLinkedList = SingleLinkedList.deleteAtPosition(singleLinkedList, 1) // start position
    SingleLinkedList.printLinkedList(singleLinkedList)
    singleLinkedList = SingleLinkedList.deleteAtPosition(singleLinkedList, 8) // last position


    SingleLinkedList.printLinkedList(singleLinkedList)
    println("Size = ${SingleLinkedList.size(singleLinkedList)}")
    SingleLinkedList.printHead(singleLinkedList)
    SingleLinkedList.printTail(singleLinkedList)


}