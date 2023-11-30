fun main() {
    plusMinus(arrayOf(-4, 3, -9, 0, 4, 1))
}

private fun plusMinus(arr: Array<Int>): Unit {
    var positiveCount = 0
    var negativeCount = 0
    var zeroCount = 0
    for (value in arr) {
        if (value > 0) {
            ++positiveCount
        } else if (value < 0) {
            ++negativeCount
        } else if (value == 0) {
            ++zeroCount
        }
    }

    val size = arr.size.toDouble()
    val positiveRatio: Double = if (positiveCount > 0) {
        positiveCount / size
    } else {
        0.0
    }
    val negativeRatio: Double = if (negativeCount > 0) {
        negativeCount / size
    } else {
        0.0
    }
    val zeroRatio: Double = if (zeroCount > 0) {
        zeroCount / size
    } else {
        0.0
    }

    println("$positiveRatio\n$negativeRatio\n$zeroRatio")
}


