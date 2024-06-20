package lecture053_Linked_List_Day10

import lecture045_Linked_List_Day2.Node

fun main() {

}

private fun flattenLinkedList(head: Node?): Node? {

    var head = head

    // Base case
    if (head?.next == null) {
        return head
    }

    head.next = flattenLinkedList(head.next)

    head = merge(head, head.next!!)

    return head
}

private fun merge(a: Node?, b: Node?): Node? {

    // if first linked list is empty then second
    // is the answer
    if (a == null) return b


    // if second linked list is empty then first
    // is the result
    if (b == null) return a


    // compare the data members of the two linked lists
    // and put the larger one in the result
    val result: Node

    if (a.data < b.data) {
        result = a
        result.child = merge(a.child, b)
    } else {
        result = b
        result.child = merge(a, b.child)
    }

    result.next = null
    return result
}