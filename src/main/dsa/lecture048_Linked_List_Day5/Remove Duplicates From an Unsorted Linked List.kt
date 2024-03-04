package lecture048_Linked_List_Day5

import LinkedListNode


fun main() {

}

private fun removeDuplicates(head: LinkedListNode<Int>?): LinkedListNode<Int>? {

    if (head == null) {
        return head
    }

    val visited: MutableMap<Int, Boolean> = HashMap()

    var prev: LinkedListNode<Int>? = null
    var curr = head

    while (curr != null) {

        if (visited.containsKey(curr.data) && visited[curr.data]!!) {
            prev?.next = curr.next
        } else {
            visited[curr.data] = true

            prev = curr
        }


        curr = curr.next
    }

    return head
}