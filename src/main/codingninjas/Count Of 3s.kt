/*
*
* */
fun main() {
    println(countOf3(33))
    println(countOf3(10))
    println(countOf3(24))
    println(countOf3(200))
}

private fun countOf3(x: Int): Long {
    var count = 0L
    var value: Long = 3

    while (value <= x) {
        count += count3(value)
        value++
    }

    return count
}

private fun count3(value: Long): Long {
    var value = value
    var count = 0L
    while (value != 0L) {
        if (value % 10 == 3L) {
            count++
        }
        value /= 10
    }

    return count
}