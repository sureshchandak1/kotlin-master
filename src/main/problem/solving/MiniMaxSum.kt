fun main() {
    val arr = arrayOf(1, 2, 3, 4, 5)
    //val sum = arr.sum()
    //println("Total = $sum")
    //println(arr.min())
    //println(arr.max())

    miniMaxSum1(arr)
    miniMaxSum2(arr)
}

private fun miniMaxSum1(arr: Array<Int>): Unit {
    var min: Long = arr[0].toLong()
    var max: Long = 0
    var total: Long = 0
    for (x in 0 until arr.size) {
        val item = arr[x].toLong()
        total += item
        if (item < min) {
            min = item
        }
        if (item > max) {
            max = item
        }
    }
    println("${total - max} ${total - min}")
}

private fun miniMaxSum2(arr: Array<Int>): Unit {
    val sum = arr.sum()
    println("${ sum - arr.max() } ${ sum - arr.min() }")
}


