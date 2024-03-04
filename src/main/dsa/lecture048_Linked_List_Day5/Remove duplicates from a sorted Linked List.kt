package lecture048_Linked_List_Day5

import lecture045_Linked_List_Day2.Node

fun main() {

}

private fun uniqueSortedList(head: Node?): Node? {

    if (head == null) {
        return head
    }

    var curr: Node? = head

    while (curr != null) {

        var next: Node? = curr.next
        while (next != null && curr.data == next.data) {
            next = next.next
        }

        curr.next = next
        curr = next
    }

    return head
}