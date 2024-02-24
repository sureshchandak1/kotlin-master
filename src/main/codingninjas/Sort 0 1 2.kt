fun main() {
    var arr = intArrayOf(0, 1, 2, 2, 1, 0)
    printArray(arr)
    sort012(arr)
    printArray(arr)

    arr = intArrayOf(0, 1, 2, 1, 2, 1, 2)
    printArray(arr)
    sort012(arr)
    printArray(arr)

    arr = intArrayOf(1, 1, 1, 0, 1, 2, 1, 0, 0, 1, 2, 1, 0, 1)
    printArray(arr)
    sort012(arr)
    printArray(arr)
}

private fun sort012(arr: IntArray) {

    val n = arr.size

    var low = 0
    var high = n - 1
    var mid = 0

    while (mid <= high) {

        if (arr[mid] == 0) {

            val temp = arr[low]
            arr[low] = arr[mid]
            arr[mid] = temp

            low++
            mid++

        } else if (arr[mid] == 1) {
            mid++
        } else {

            val temp = arr[mid]
            arr[mid] = arr[high]
            arr[high] = temp

            high--
        }
    }
}