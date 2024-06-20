package lecture074_Heap_and_Priority_Queue

fun main() {
    val arr = intArrayOf(-1, 54, 53, 55, 52, 50)
    val n = 5
    // heap creation
    for (i in n/2 downTo 1) { // 1 - based indexing
        heapify(arr, n, i)
    }

    for (i in 1 .. n) {
        print("${arr[i]}  ")
    }
    println()

    // heap sort
    heapSort(arr, n)

    for (i in 1 .. n) {
        print("${arr[i]}  ")
    }
    println()
}

private fun heapSort(arr: IntArray, n: Int) {

    var size = n

    while (size > 1) {
        // step 1: swap
        arr[size] = arr[1].also { arr[1] = arr[size] }
        size--

        // step 2
        heapify(arr, size, 1)
    }
}

private fun heapify(arr: IntArray, n: Int, i: Int) {

    var largest = i
    val left = 2 * i
    val right = 2 * i + 1

    if (left <= n && arr[largest] < arr[left]) {
        largest = left
    }
    if (right <= n && arr[largest] < arr[right]) {
        largest = right
    }

    if (largest != i) {
        arr[largest] = arr[i].also { arr[i] = arr[largest] } // swap

        heapify(arr, n, largest)
    }
}