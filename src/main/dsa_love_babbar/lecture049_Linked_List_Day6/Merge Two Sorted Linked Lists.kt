package lecture049_Linked_List_Day6

import LinkedListNode



fun main() {

}

private fun sortTwoLists(first: LinkedListNode<Int>?, second: LinkedListNode<Int>?): LinkedListNode<Int>? {

    if (first == null) {
        return second
    }

    if (second == null) {
        return first
    }

    return if (first.data <= second.data) {
        merge(first, second)
    } else {
        merge(second, first)
    }
}

private fun merge(first: LinkedListNode<Int>, second: LinkedListNode<Int>?): LinkedListNode<Int> {

    // If first list have only one node, point its next to entire second list
    if (first.next == null) {
        first.next = second
        return first
    }

    var curr1 = first
    var next1 = curr1.next

    var curr2 = second
    var next2 = curr2!!.next

    while (next1 != null && curr2 != null) {

        if ((curr2.data >= curr1.data) &&
            (curr2.data <= next1.data)
        ) {
            // add node in between the node of first list
            curr1.next = curr2
            next2 = curr2.next
            curr2.next = next1

            // updating pointer
            curr1 = curr2
            curr2 = next2
        } else {
            curr1 = next1
            next1 = next1.next

            if (next1 == null) {
                curr1.next = curr2
                return first
            }

        }
    }

    return first
}

