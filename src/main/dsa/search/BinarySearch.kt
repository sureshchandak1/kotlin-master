package search

import printArray

// element should be in monotonic function

fun main(args: Array<String>) {
    /*val even = intArrayOf(2, 4, 6, 8, 12, 18)
    val odd = intArrayOf(3, 8, 11, 14, 16)

    val evenIndex = search(even, 6, 12)
    println("Even Index = $evenIndex")

    val oddIndex = search(odd, 5, 14)
    println("Odd Index = $oddIndex")*/

    val arr1 = intArrayOf(0, 0, 1, 1, 2, 2, 2, 2)
    val result = firstAndLastPosition(arr1, 8, 2)

    printArray(result)
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

private fun firstAndLastPosition(arr: IntArray, size: Int, element: Int) : IntArray {

    val leftIndex = firstIndex(arr, size, element)
    val rightIndex = lastIndex(arr, size, element)

    return intArrayOf(leftIndex, rightIndex)

}

private fun firstIndex(arr: IntArray, size: Int, element: Int) : Int {

    var leftIndex = -1

    var start = 0
    var end = size - 1

    var mid = start + (end - start) / 2

    while (start <= end) {

        if (element == arr[mid]) {
            leftIndex = mid
            end = mid - 1
        } else if (element > arr[mid]) {
            start = mid + 1
        } else if (element < arr[mid]) {
            end = mid - 1
        }

        mid = start + (end - start) / 2

    }

    return leftIndex

}

private fun lastIndex(arr: IntArray, size: Int, element: Int) : Int {

    var rightIndex = -1

    var start = 0
    var end = size - 1

    var mid = start + (end - start) / 2

    while (start <= end) {

        if (element == arr[mid]) {
            rightIndex = mid
            start = mid + 1
        } else if (element > arr[mid]) {
            start = mid + 1
        } else if (element < arr[mid]) {
            end = mid - 1
        }

        mid = start + (end - start) / 2

    }

    return rightIndex

}

