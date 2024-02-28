fun main() {
    var arr = intArrayOf(2, 3, 9, 2, 2)
    println(findMajority(arr, arr.size))
    arr = intArrayOf(8, 5, 1, 9)
    println(findMajority(arr, arr.size))
    arr = intArrayOf(8, 8, 8, 8, 8, 9, 1)
    println(findMajority(arr, arr.size))
    arr = intArrayOf(2, 2, 3, 3)
    println(findMajority(arr, arr.size))
}

private fun findMajority(arr: IntArray, n: Int): Int {

    val countMap: MutableMap<Int, Int> = HashMap()

    for (i in 0..<n) {
        countMap.merge(arr[i], 1) { a: Int?, b: Int? ->
            Integer.sum(a!!, b!!)
        }
    }

    val floor = n / 2

    for ((key, value) in countMap) {
        if (value > floor) {
            return key
        }
    }

    return -1
}