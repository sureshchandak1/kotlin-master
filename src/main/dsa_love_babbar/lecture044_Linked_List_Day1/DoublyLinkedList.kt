package lecture044_Linked_List_Day1



class DoublyLinkedList {

    private var head: Node? = null // head of list (Starting node)
    private var tail: Node? = null // end of list (Ending node)

    companion object {

        private class Node(var data: Int) {
            var prev: Node? = null
            var next: Node? = null
        }

        fun insertAtHead(linkedList: DoublyLinkedList, data: Int): DoublyLinkedList {
            val newNode = Node(data)
            if (linkedList.head == null) {
                linkedList.head = newNode
                linkedList.tail = newNode
            } else {
                newNode.next = linkedList.head
                linkedList.head?.prev = newNode
                linkedList.head = newNode
            }

            return linkedList
        }

        fun insertAtTail(linkedList: DoublyLinkedList, data: Int): DoublyLinkedList {
            val newNode = Node(data)
            if (linkedList.head == null) {
                linkedList.head = newNode
                linkedList.tail = newNode
            } else {
                linkedList.tail?.next = newNode
                newNode.prev = linkedList.tail
                linkedList.tail = newNode
            }

            return linkedList
        }

        fun insertAtPosition(linkedList: DoublyLinkedList, data: Int, position: Int): DoublyLinkedList {

            if (position == 1) {
                insertAtHead(linkedList, data)
            } else {
                var currentNode = linkedList.head
                var count = 1
                while (count < position - 1) {
                    currentNode = currentNode?.next
                    count++
                }

                if (currentNode != null) {
                    if (currentNode.next == null) {
                        insertAtTail(linkedList, data)
                    } else {
                        val newNode = Node(data)
                        newNode.next = currentNode.next
                        currentNode.next?.prev = newNode
                        newNode.prev = currentNode
                        currentNode.next = newNode
                    }
                }
            }

            return linkedList
        }

        fun deleteAtPosition(linkedList: DoublyLinkedList, position: Int): DoublyLinkedList {

            if (position == 1) {
                linkedList.head = linkedList.head?.next
                linkedList.head?.prev = null
            } else {
                var prevNode: Node? = null
                var currentNode = linkedList.head
                var count = 1
                while (count < position) {
                    prevNode = currentNode
                    currentNode = currentNode?.next
                    count++
                }

                if (prevNode != null) {
                    if (currentNode?.next == null) {
                        prevNode.next = null
                        linkedList.tail = prevNode
                    } else {
                        prevNode.next = currentNode.next
                        currentNode.next?.prev = prevNode
                    }
                }
            }

            return linkedList
        }

        fun size(linkedList: DoublyLinkedList): Int {
            var currentNode = linkedList.head
            var count = 1
            while (currentNode?.next != null) {
                count++
                currentNode = currentNode.next
            }

            return count
        }

        fun printLinkedList(linkedList: DoublyLinkedList) {
            var currentNode = linkedList.head
            while (currentNode != null) {
                print("${currentNode.data}  ")
                currentNode = currentNode.next
            }
            println()
        }

        fun printHead(linkedList: DoublyLinkedList) {
            println("Head = ${linkedList.head?.data}")
        }

        fun printTail(linkedList: DoublyLinkedList) {
            println("Tail = ${linkedList.tail?.data}")
        }
    }
}

fun main() {
    var linkedList = DoublyLinkedList()

    println("Insert at head (Start)")
    linkedList = DoublyLinkedList.insertAtHead(linkedList, 10)
    linkedList = DoublyLinkedList.insertAtHead(linkedList, 20)
    linkedList = DoublyLinkedList.insertAtHead(linkedList, 30)

    DoublyLinkedList.printLinkedList(linkedList)

    println("Insert at tail (End)")
    linkedList = DoublyLinkedList.insertAtTail(linkedList, 40)
    linkedList = DoublyLinkedList.insertAtTail(linkedList, 50)
    DoublyLinkedList.printLinkedList(linkedList)

    println("Insert at position")
    linkedList = DoublyLinkedList.insertAtPosition(linkedList, 100, 2)
    DoublyLinkedList.printLinkedList(linkedList)
    linkedList = DoublyLinkedList.insertAtPosition(linkedList, 60, 7)
    DoublyLinkedList.printLinkedList(linkedList)
    linkedList = DoublyLinkedList.insertAtPosition(linkedList, 40, 4)
    linkedList = DoublyLinkedList.insertAtPosition(linkedList, 40, 1)
    DoublyLinkedList.printLinkedList(linkedList)

    println("Delete at position")
    linkedList = DoublyLinkedList.deleteAtPosition(linkedList, 3)
    DoublyLinkedList.printLinkedList(linkedList)
    linkedList = DoublyLinkedList.deleteAtPosition(linkedList, 1)
    DoublyLinkedList.printLinkedList(linkedList)
    linkedList = DoublyLinkedList.deleteAtPosition(linkedList, 7)

    DoublyLinkedList.printLinkedList(linkedList)
    println("Size = ${DoublyLinkedList.size(linkedList)}")
    DoublyLinkedList.printHead(linkedList)
    DoublyLinkedList.printTail(linkedList)
}
