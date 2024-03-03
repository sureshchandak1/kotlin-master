package lecture046_Linked_List_Day3

import lecture045_Linked_List_Day2.Node

fun main() {

}

private fun isCircular(head: Node?): Boolean {

    if (head == null) {
        return true
    }

    if (head.next == null) {
        return false
    }

    var curr: Node? = head.next

    while (curr != null && curr != head) {
        curr = curr.next
    }

    return curr === head
}