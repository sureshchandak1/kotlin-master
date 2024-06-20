package lecture033_Recursion_Day3

fun main() {
    val arr = intArrayOf(2, 4, 6, 8, 9, 12)
    println(isSorted(arr, arr.size, 0))
}

private fun isSorted(arr: IntArray, size: Int, index: Int): Boolean {

    if (size == 0 || size == 1) {
        return true
    }

    if (arr[index] > arr[index + 1]) {
        return false
    } else {
        val ans = isSorted(arr + 1, size - 1, index + 1)
        return ans
    }

}