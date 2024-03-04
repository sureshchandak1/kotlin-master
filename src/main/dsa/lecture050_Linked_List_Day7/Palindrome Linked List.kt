package lecture050_Linked_List_Day7

import lecture045_Linked_List_Day2.Node

fun main() {

}

private fun isPalindrome(head: Node?): Boolean {

    if (head == null && head?.next == null) {
        return true
    }


    // Step - 1 : Find middle
    val middle: Node? = getMid(head)


    // Step - 2 : Reverse list after middle
    var temp: Node? = middle?.next
    middle?.next = reverse(temp)


    // Step - 3 : Compare both sides
    var head1: Node? = head
    var head2: Node? = middle?.next

    while (head2 != null) {
        if (head1?.data != head2.data) {
            return false
        }

        head1 = head1.next
        head2 = head2.next
    }


    // Step - 4 : Repeat step 2
    temp = middle?.next
    middle?.next = reverse(temp)

    return true
}

private fun getMid(head: Node?): Node? {

    var slow: Node? = head
    var fast: Node? = head?.next

    while (fast != null && fast.next != null) {
        fast = fast.next!!.next
        slow = slow?.next
    }

    return slow
}

private fun reverse(head: Node?): Node? {

    var prev: Node? = null
    var curr: Node? = head
    var next: Node? = null

    while (curr != null) {
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}