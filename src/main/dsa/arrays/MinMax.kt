package arrays

fun main() {

    val size = readln().toInt()

    val arr = Array(100) { 0 }
    //val arr = IntArray(100)

    for (index in 0..<size) {
        arr[index] = readln().toInt()
    }

    val result = minMax(arr, size)
    if (result.isNotEmpty()) {
        println("min = ${result[0]} max = ${result[1]}")
    }
}

private fun minMax(arr: Array<Int>, size: Int): Array<Int> {

    return if (arr.isNotEmpty()) {
        var min = arr[0]
        var max = arr[0]

        for (index in 0 ..< size) {
            val element = arr[index]
            if (element > max) {
                max = element
            } else if (element < min) {
                min = element
            }
        }

        arrayOf(min, max)
    } else {
        arrayOf()
    }

}