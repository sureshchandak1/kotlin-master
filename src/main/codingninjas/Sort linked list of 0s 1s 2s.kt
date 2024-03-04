import lecture045_Linked_List_Day2.Node

fun main() {

}

private fun sortList(head: Node?): Node? {

    if (head == null) {
        return head
    }

    var zeroHead: Node? = null
    var zeroTail: Node? = null

    var oneHead: Node? = null
    var oneTail: Node? = null

    var twoHead: Node? = null
    var twoTail: Node? = null

    var curr: Node? = head

    while (curr != null) {
        if (curr.data == 0) {
            if (zeroHead == null) {
                zeroHead = curr
                zeroTail = curr
            } else {
                zeroTail?.next = curr
                zeroTail = curr
            }
        } else if (curr.data == 1) {
            if (oneHead == null) {
                oneHead = curr
                oneTail = curr
            } else {
                oneTail?.next = curr
                oneTail = curr
            }
        } else if (curr.data == 2) {
            if (twoHead == null) {
                twoHead = curr
                twoTail = curr
            } else {
                twoTail?.next = curr
                twoTail = curr
            }
        }

        curr = curr.next
    }

    if (zeroTail != null) {
        zeroTail.next = oneHead
    }

    if (oneTail != null) {
        oneTail.next = twoHead
    }

    if (twoTail != null) {
        twoTail.next = null
    }

    return zeroHead
}