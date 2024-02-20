package _33

fun main(args: Array<String>) {
    val even = intArrayOf(2, 4, 6, 8, 12, 18)
    val odd = intArrayOf(3, 8, 11, 14, 16)

    val evenIndex = search(even, 6, 12)
    println("Even Index = $evenIndex")

    val oddIndex = search(odd, 5, 14)
    println("Odd Index = $oddIndex")

    println("Index = ${search(even, 0, even.size - 1, 12)}")
    println("Index = ${search(odd, 0, odd.size - 1, 14)}")
}

private fun search(arr: IntArray, size: Int, key: Int): Int {

    var start = 0
    var end = size - 1

    // var mid = (start + end) / 2
    var mid = start + (end - start) / 2

    while (start <= end) {

        if (key == arr[mid]) {
            return mid
        }

        if (key > arr[mid]) {
            start = mid + 1
        } else {
            end = mid - 1
        }

        mid = start + (end - start) / 2

    }

    return -1

}

private fun search(arr: IntArray, start: Int, end: Int, target: Int): Int {

    if (start > end) return -1

    val mid = start + (end - start) / 2

    if (arr[mid] == target) {
        return mid
    } else {
        if (arr[mid] < target) {
            val remainingSearch = search(arr, mid + 1, end, target)
            return remainingSearch
        } else {
            val remainingSearch = search(arr, start, mid - 1, target)
            return remainingSearch
        }
    }

}