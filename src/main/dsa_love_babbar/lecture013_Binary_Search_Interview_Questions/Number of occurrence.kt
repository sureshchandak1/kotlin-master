package lecture013_Binary_Search_Interview_Questions

fun main() {
    println(count(intArrayOf(1, 8, 12, 15, 17, 17, 18, 18, 18, 18, 19) , 11, 18))
}

private fun count(arr: IntArray, n: Int, x: Int): Int {
    val lastIndex = lastIndex(arr, n, x)
    val firstIndex = firstIndex(arr, n, x)

    println("Last index = $lastIndex")
    println("First index = $firstIndex")

    if (firstIndex == -1 || lastIndex == -1) {
        return 0
    }

    return (lastIndex - firstIndex) + 1
}

private fun firstIndex(arr: IntArray, n: Int, x: Int): Int {
    var start = 0
    var end = n - 1
    var mid = start + (end - start) / 2
    var firstIndex = -1

    while (start <= end) {
        if (arr[mid] == x) {
            firstIndex = mid
            end = mid - 1
        } else if (arr[mid] < x) {
            start = mid + 1
        } else if (arr[mid] > x) {
            end = mid - 1
        }

        mid = start + (end - start) / 2
    }

    return firstIndex
}

private fun lastIndex(arr: IntArray, n: Int, x: Int): Int {
    var start = 0
    var end = n - 1
    var mid = start + (end - start) / 2
    var lastIndex = -1

    while (start <= end) {
        if (arr[mid] == x) {
            lastIndex = mid
            start = mid + 1
        } else if (arr[mid] < x) {
            start = mid + 1
        } else if (arr[mid] > x) {
            end = mid - 1
        }

        mid = start + (end - start) / 2
    }

    return lastIndex
}
