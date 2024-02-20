fun main() {
    val arr = intArrayOf(0, 10, 5, 2)
    val result = peakIndexInMountainArray(arr)
    println(result)
}

fun peakIndexInMountainArray(arr: IntArray): Int {
    var start = 0
    var end = arr.size - 1
    var mid = start + (end - start) / 2

    while (start < end) {

        if (arr[mid] < arr[mid + 1]) {
            start = mid + 1
        } else {
            end = mid
        }

        mid = start + (end - start) / 2
    }

    return start
}