package lecture076_Heap_Interview_Questions_Day2

import java.util.*

/*
*   https://www.naukri.com/code360/problems/merge-k-sorted-lists_992772
* */
fun main() {

}

private fun mergeKLists(listArray: Array<LinkedListNode<Int?>?>): LinkedListNode<Int?>? {

    var ansHead: LinkedListNode<Int?>? = null
    var ansTail: LinkedListNode<Int?>? = null

    val minHeap: PriorityQueue<LinkedListNode<Int?>> = PriorityQueue(NodeComparator())

    val k = listArray.size

    if (k == 0) {
        return ansHead
    }

    for (i in 0..< k) {
        if (listArray[i] != null) {
            minHeap.add(listArray[i])
        }
    }

    while (minHeap.size > 0) {
        val temp = minHeap.remove()

        if (temp!!.next != null) {
            minHeap.add(temp.next)
        }

        if (ansHead == null) {
            ansHead = temp
            ansTail = temp
        } else {
            ansTail!!.next = temp
            ansTail = temp
        }
    }

    return ansHead
}

private class NodeComparator : Comparator<LinkedListNode<Int?>> {
    override fun compare(i1: LinkedListNode<Int?>, i2: LinkedListNode<Int?>): Int {
        if (i1.data < i2.data) return -1
        else if (i1.data > i2.data) return 1

        return 0
    }
}

class LinkedListNode<Integer>(var data: Int) {
    var next: LinkedListNode<Integer>? = null
}


