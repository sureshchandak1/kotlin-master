/*
*  Sample Input
*     17 28 30
*     99 16 8
*  Sample Output
*     2 1
* */
fun main() {
    val result = compareTriplets(arrayOf(17, 28, 30), arrayOf(99, 16, 8))
    println(result.joinToString(" "))
}

private fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    var aliceScore = 0
    var bobScore = 0
    for ((index, value) in a.withIndex()) {
        if (value > b[index]) {
            ++aliceScore
        } else if (value < b[index]) {
            ++bobScore
        }
    }
    return arrayOf<Int>(aliceScore, bobScore)
}


