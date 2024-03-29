package lecture074_Heap_and_Priority_Queue

import printArray


fun main() {
    var arr: ArrayList<Int> = arrayListOf(10, 7, 8, 11)
    heapSort(arr, arr.size)
    printArray(arr)

    arr = arrayListOf(5, -2, 3, -1, 8)
    heapSort(arr, arr.size)
    printArray(arr)

}

private fun heapSort(arr: ArrayList<Int>, n: Int): ArrayList<Int> {

    // heap creation
    for (i in n / 2 downTo 0) {
        heapify(arr, n - 1, i)
    }

    sort(arr, n - 1)

    return arr
}

private fun heapify(arr: ArrayList<Int>, n: Int, i: Int) {

    var largest = i
    val left = 2 * i + 1
    val right = 2 * i + 2

    if (left <= n && arr[largest] < arr[left]) {
        largest = left
    }
    if (right <= n && arr[largest] < arr[right]) {
        largest = right
    }

    if (largest != i) {
        val temp = arr[largest]
        arr[largest] = arr[i]
        arr[i] = temp

        heapify(arr, n, largest)
    }
}

private fun sort(arr: ArrayList<Int>, n: Int) {
    var size = n

    while (size > 0) {
        val temp = arr[size]
        arr[size] = arr[0]
        arr[0] = temp

        size--

        heapify(arr, size, 0)
    }
}