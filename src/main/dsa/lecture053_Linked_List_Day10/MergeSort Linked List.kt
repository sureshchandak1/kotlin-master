package lecture053_Linked_List_Day10

fun main() {

}

private fun mergeSort(head: Node<Int>?): Node<Int>? {

    // Base case
    if (head?.next == null) {
        return head
    }

    // break linked list into 2 parts, after finding mid
    val mid = getMid(head)

    var left = head
    var right = mid!!.next
    mid.next = null

    // recursive call to sort both parts
    left = mergeSort(left)
    right = mergeSort(right)

    // merge both left and right parts
    val result = mergeNodes(left, right)

    return result
}

private fun getMid(head: Node<Int>): Node<Int>? {
    var slow: Node<Int>? = head
    var fast = head.next

    while (fast?.next != null) {
        fast = fast.next!!.next
        slow = slow!!.next
    }

    return slow
}

private fun mergeNodes(left: Node<Int>?, right: Node<Int>?): Node<Int>? {

    if (left == null) {
        return right
    }

    if (right == null) {
        return right
    }

    return if (left.data <= right.data) {
        merge(left, right)
    } else {
        merge(right, left)
    }
}

private fun merge(first: Node<Int>, second: Node<Int>): Node<Int> {

    if (first.next == null) {
        first.next = second
        return first
    }

    var curr1 = first
    var next1 = curr1.next

    var curr2: Node<Int>? = second
    var next2 = curr2!!.next

    while (next1 != null && curr2 != null) {

        if ((curr2.data >= curr1.data) && (curr2.data <= next1.data)) {
            curr1.next = curr2
            next2 = curr2.next
            curr2.next = next1

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

class Node<T>(var data: T) {
    var next: Node<T>? = null
}