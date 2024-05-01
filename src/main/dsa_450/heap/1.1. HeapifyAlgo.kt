package heap

fun main() {
    // not consider 0 index
    val arr = intArrayOf(-1, 54, 53, 55, 52, 50)
    print(arr, arr.size - 1)

    buildHeap(arr, arr.size - 1)

    print(arr, arr.size - 1)
}

/**
 *  array 1-based index
 *  left child: 2 * index
 *  right child: 2 * index + 1
 *  parent: index / 2
 *  leaf node: (n/2 + 1) to n index all are leaf node, where n is size of array
 */
private fun buildHeap(arr: IntArray, size: Int) {

    val startIndex = size / 2 // ignore all leaf node they already heap node

    for (index in startIndex downTo 1) { // 1 - based indexing
        heapify(arr, size, index) // // T.C = O(n)
    }
}

// Heapify Algo
// T.C = O(log n)
private fun heapify(arr: IntArray, size: Int, index: Int) {

    var largest = index
    val leftIndex = 2 * index
    val rightIndex = 2 * index + 1

    if (leftIndex < size && arr[largest] < arr[leftIndex]) {
        largest = leftIndex
    } else if (rightIndex < size && arr[largest] < arr[rightIndex]) {
        largest = rightIndex
    }

    if (largest != index) {
        swap(arr, largest, index)

        heapify(arr, size, largest)
    }
}

private fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

private fun print(arr: IntArray, size: Int) {
    // start from 1 because insert value inside array from 1
    for (i in 1 .. size) {
        print("${arr[i]}  ")
    }
    println()
}