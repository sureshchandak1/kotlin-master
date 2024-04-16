/**
 *   https://leetcode.com/problems/add-two-numbers/
 */
fun main() {
    val l1 = ListNode(9)
    l1.next = ListNode(9)
    l1.next?.next = ListNode(9)
    l1.next?.next?.next = ListNode(9)

    val l2 = ListNode(9)
    l2.next = ListNode(9)
    l2.next?.next = ListNode(9)

    val result = addTwoNumbers(l1, l2)
    // print result
    var curr = result
    print("[")
    while (curr != null) {
        print(curr.data)
        if (curr.next != null) {
            print(", ")
        }
        curr = curr.next
    }
    print("]")
    println()
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var resultHead: ListNode? = null
    var resultTail: ListNode? = null

    var carry = 0
    var sum = 0
    var curr1 = l1
    var curr2 = l2

    while (curr1 != null || curr2 != null || carry != 0) {
        val data1 = curr1?.data ?: 0

        val data2 = curr2?.data ?: 0

        sum = data1 + data2 + carry
        carry = sum / 10

        val node = ListNode(sum % 10)
        if (resultHead == null) {
            resultHead = node
            resultTail = node
        } else {
            resultTail?.next = node
            resultTail = node
        }

        curr1 = curr1?.next
        curr2 = curr2?.next
    }

    return resultHead
}


