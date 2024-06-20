package heap

// Heap is a complete binary tree that comes with a Heap Order Property (Max heap or Min heap)
// Max heap : every node value is greater then it's child value
// Min heap : every node value is smaller then it's child value
fun main() {
    val heap = Heap()

    heap.insert(50)
    heap.insert(55)
    heap.insert(53)
    heap.insert(52)
    heap.insert(54)
    heap.print()

    heap.delete()
    heap.print()
}

/**
 *  -> array 1-based index
 *  left child: 2 * index
 *  right child: 2 * index + 1
 *  parent: index / 2
 *
 *  -> array 0-based index
 *  left child: 2 * index + 1
 *  right child: 2 * index + 2
 */
private class Heap {

    val arr = IntArray(100)
    var size = 0

    init {
        arr[0] = -1 // use array start from 1 index
    }

    // T.C = O(log n)
    fun insert(value: Int) {
        // Step 1: insert at last position
        size += 1
        var index = size
        arr[index] = value

        // Step 2: move to right position
        while (index > 1) { // for 1-based index
            val parent = index / 2

            if (arr[parent] < arr[index]) {
                swap(arr, parent, index)
                index = parent
            } else {
                return
            }
        }
    }

    // delete root node
    // T.C = O(log n)
    fun delete() {
        if (size == 0) {
            println("Nothing to delete")
            return
        }

        // Step 1: swap root node with last node (insert last node to first(root) index)
        arr[1] = arr[size]

        // Step 2:  remove last node
        size--

        // Step 3: Propagate root node to it's correct position
        var index = 1
        while (index < size) {
            val leftIndex = 2 * index
            val rightIndex = 2 * index + 1

            if (leftIndex < size && arr[index] < arr[leftIndex]) {
                swap(arr, index, leftIndex)
                index = leftIndex
            } else if (rightIndex < size && arr[index] < arr[rightIndex]) {
                swap(arr, index, rightIndex)
                index = rightIndex
            } else {
                return
            }
        }
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    fun print() {
        // start from 1 because insert value inside array from 1
        for (i in 1 .. size) {
            print("${arr[i]}  ")
        }
        println()
    }
}