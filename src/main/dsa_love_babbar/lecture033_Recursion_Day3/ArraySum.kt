package lecture033_Recursion_Day3

fun main() {
    val arr1 = intArrayOf(3, 2, 5, 1, 6)
    println(sum(arr1, 0, arr1.size))
}

private fun sum(arr: IntArray, index: Int, size: Int): Int {

    if (index == size) {
        return 0
    }

    val remainingPart = sum(arr, index + 1, size)
    val sum = arr[index] + remainingPart

    return sum

}