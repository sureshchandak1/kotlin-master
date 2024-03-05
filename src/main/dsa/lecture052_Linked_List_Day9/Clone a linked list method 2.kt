package lecture052_Linked_List_Day9


// Clone a linked list with next and random pointer

fun main() {

}

internal class Clone2 {

    private var cloneHead: Node? = null
    private var cloneTail: Node? = null

    //Function to clone a linked list with next and random pointer.
    fun copyList(head: Node?): Node? {

        // Step 1: Create clone list
        var temp = head

        while (temp != null) {
            insertAtTail(temp)

            temp = temp.next
        }


        // Step 2: clone nodes add in between original list
        var originalNode = head
        var cloneNode = cloneHead
        var next: Node? = null

        while (originalNode != null && cloneNode != null) {
            next = originalNode.next
            originalNode.next = cloneNode
            originalNode = next

            next = cloneNode.next
            cloneNode.next = originalNode
            cloneNode = next
        }


        // Step 3: random pointer copy
        originalNode = head

        while (originalNode != null) {
            if (originalNode.next != null) {
                if (originalNode.arb != null) {
                    originalNode.next!!.arb = originalNode.arb!!.next
                } else {
                    originalNode.next!!.arb = originalNode.arb
                }
            }

            originalNode = originalNode.next!!.next
        }


        // Step 4: revert changes done in step 2
        originalNode = head
        cloneNode = cloneHead

        while (originalNode != null && cloneNode != null) {
            originalNode.next = cloneNode.next
            originalNode = originalNode.next

            if (originalNode != null) {
                cloneNode.next = originalNode.next
            }
            cloneNode = cloneNode.next
        }


        // Step 5: return ans
        return cloneHead
    }

    private fun insertAtTail(originalNode: Node) {
        val newNode = Node(originalNode.data)

        if (cloneHead == null) {
            cloneHead = newNode
            cloneTail = newNode
        } else {
            cloneTail!!.next = newNode
            cloneTail = newNode
        }
    }

}