package arrays

fun main() {
    val arr = intArrayOf(1, 2, 7, 8, 5, 6)
    swapAlternate(arr)

    for (element in arr) {
        println(element)
    }
}

private fun swapAlternate(arr: IntArray) {

    val end = arr.size - 1
    var start = 0

    var swapValue = 0
    while (start < end) {
        swapValue = arr[start]
        arr[start] = arr[start + 1]
        arr[start + 1] = swapValue

        start += 2
    }

}