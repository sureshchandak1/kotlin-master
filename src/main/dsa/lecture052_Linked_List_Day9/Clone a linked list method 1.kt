package lecture052_Linked_List_Day9


// Clone a linked list with next and random pointer

fun main() {

}

internal class Clone1 {

    private var cloneHead: Node? = null
    private var cloneTail: Node? = null

    // key - original node,  value - new node
    private val mapping: MutableMap<Node, Node> = HashMap()

    fun copyList(head: Node?): Node? {

        var temp = head

        while (temp != null) {
            // Create new node for clone
            insertAtTail(temp)

            temp = temp.next
        }

        temp = head

        while (temp != null) {

            val newNode = mapping[temp]
            newNode!!.arb = mapping[temp.arb]

            temp = temp.next
        }

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

        mapping[originalNode] = newNode
    }
}

internal class Node(var data: Int) {

    var next: Node?
    var arb: Node? = null

    init {
        next = arb
    }
}