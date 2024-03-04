package lecture051_Linked_List_Day8

import lecture045_Linked_List_Day2.Node

fun main() {

}

private fun addTwoLists(first: Node?, second: Node?): Node? {

    // Step - 1 : reverse input LL
    var first: Node? = first
    var second: Node? = second

    first = reverse(first)
    second = reverse(second)


    // Step 2 : add two LL
    var ans: Node? = add(first, second)

    // Step 3
    ans = reverse(ans)

    return ans
}

private fun add(first: Node?, second: Node?): Node? {

    var first: Node? = first
    var second: Node? = second

    var carry = 0

    val ansSum = AnsSum()

    while (first != null || second != null || carry != 0) {
        var val1 = 0
        if (first != null) {
            val1 = first.data
        }

        var val2 = 0
        if (second != null) {
            val2 = second.data
        }

        val sum = carry + val1 + val2

        val digit = sum % 10

        insertAtTail(ansSum, digit)

        carry = sum / 10

        if (first != null) {
            first = first.next
        }

        if (second != null) {
            second = second.next
        }
    }

    return ansSum.head
}

private fun insertAtTail(ans: AnsSum, value: Int) {

    val newNode: Node = Node(value)

    if (ans.head == null) {
        ans.head = newNode
        ans.tail = newNode
    } else {
        ans.tail?.next = newNode
        ans.tail = newNode
    }
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

private class AnsSum {
    var head: Node? = null
    var tail: Node? = null
}