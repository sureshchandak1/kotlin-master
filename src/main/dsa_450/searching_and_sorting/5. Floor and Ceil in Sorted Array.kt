package searching_and_sorting

/**
 *    Time complexity: O(log n) + O(log n)
 *    Space complexity: O(1)
 */
fun main() {
    var arr = intArrayOf(3, 4, 7, 8, 8, 10)
    println("Floor = ${findFloor(arr, 5)}")
    println("Ceil = ${findCeil(arr, 5)}")

    arr = intArrayOf(3, 4, 4, 7, 8, 10)
    // x = 8 is present in the array, it will be both floor and ceiling
    println("Floor = ${findFloor(arr, 8)}")
    println("Ceil = ${findCeil(arr, 8)}")
}

private fun getFloorAndCeil(arr: IntArray, x: Int): IntArray {
    val f = findFloor(arr, x)
    val c = findCeil(arr, x)
    return intArrayOf(f, c)
}

// nearest smaller than or equal to 'x'
private fun findFloor(arr: IntArray, x: Int): Int {

    var start = 0
    var end = arr.size - 1
    var ans = 0

    while (start <= end) {

        val mid = start + (end - start) / 2

        if (arr[mid] <= x) {
            ans = arr[mid]
            start = mid + 1
        } else {
            end = mid - 1
        }
    }

    return ans
}

// nearest greater than or equal to 'x'
private fun findCeil(arr: IntArray, x: Int): Int {

    var start = 0
    var end = arr.size - 1
    var ans = 0

    while (start <= end) {

        val mid = start + (end - start) / 2

        if (arr[mid] >= x) {
            ans = arr[mid]
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    return ans
}









