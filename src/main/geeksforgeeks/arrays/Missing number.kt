package arrays

/*
*   https://www.geeksforgeeks.org/problems/missing-number4257/1
*
*   NOTE: Don't use Sorting
* */
fun main() {
    println(missingNumber(4, intArrayOf(1, 4, 3)))
    println(missingNumber(5, intArrayOf(2, 5, 3, 1)))
}

private fun missingNumber(n: Int, arr: IntArray): Int {

    val nSum = n * (n + 1) / 2

    var arrSum = 0
    for (i in arr.indices) {
        arrSum += arr[i]
    }

    return nSum - arrSum
}



