fun main() {
    val arr = arrayOf(3, 2, 1, 3)
    println(birthdayCakeCandles1(arr))
    println(birthdayCakeCandles2(arr))
}

private fun birthdayCakeCandles1(candles: Array<Int>): Int {
    val max = candles.max().toLong()
    var total = 0
    for (value in candles) {
        if (value.toLong() == max) {
            total++
        }
    }

    return total
}

private fun birthdayCakeCandles2(candles: Array<Int>): Int {
    var max = candles[0].toLong()
    for (candle in candles) {
        if (candle > max) {
            max = candle.toLong()
        }
    }

    var total = 0
    for (value in candles) {
        if (value.toLong() == max) {
            total++
        }
    }

    return total
}



