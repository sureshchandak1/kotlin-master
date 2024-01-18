package arrays

fun main() {
    val arr = intArrayOf(2, 7, 5, 9)
    reverse1(arr)

    for (index in arr.indices) {
        println("${arr[index]}")
    }
}

private fun reverse1(arr: IntArray) {

    var start = 0
    var end = arr.size - 1

    var swipeValue = 0
    while (start <= end) {
        swipeValue = arr[start]
        arr[start] = arr[end]
        arr[end] = swipeValue

        ++start
        --end
    }

}

private fun reverse2(arr: IntArray) : IntArray {

    val size = arr.size
    val reverseArray = IntArray(size)

    for ((count, index) in ((size - 1) downTo 0).withIndex()) {
        reverseArray[count] = arr[index]
    }

    return reverseArray

}