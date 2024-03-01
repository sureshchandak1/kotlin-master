fun main() {
    var arr = arrayListOf(5, 4, 3, 2, 1)
    printArray(arr)
    printArray(kthSmallLarge(arr, arr.size, 1))
    arr = arrayListOf(2)
    printArray(arr)
    printArray(kthSmallLarge(arr, arr.size, 1))
}

private fun kthSmallLarge(arr: ArrayList<Int>, n: Int, k: Int): ArrayList<Int> {

    quickSort(arr, 0, n - 1)
    printArray(arr)

    val ans = ArrayList<Int>()

    ans.add(arr[k - 1])
    ans.add(arr[n - k])

    return ans
}

private fun quickSort(arr: ArrayList<Int>, start: Int, end: Int) {
    if (start > end) {
        return
    }

    val p = partition(arr, start, end)

    // left part sorting
    quickSort(arr, start, p - 1)

    // right part sorting
    quickSort(arr, p + 1, end)
}

private fun partition(arr: ArrayList<Int>, start: Int, end: Int): Int {
    val pivot = arr[start]

    var count = 0
    for (i in start + 1..end) {
        if (arr[i] <= pivot) {
            count++
        }
    }

    // place pivot at right position
    val pivotIndex = start + count
    var temp = arr[pivotIndex]
    arr[pivotIndex] = arr[start]
    arr[start] = temp

    // handal pivot left and right part
    var i = start
    var j = end

    while (i < pivotIndex && j > pivotIndex) {
        while (arr[i] <= pivot) {
            i++
        }

        while (arr[j] > pivot) {
            j--
        }

        if (i < pivotIndex && j > pivotIndex) {
            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }

        i++
        j--
    }

    return pivotIndex
}
