fun main(args: Array<String>) {
    println(breakingRecords(arrayOf(10, 5, 20, 20, 4, 5, 2, 25, 1)).joinToString(" "))
    println(breakingRecords2(arrayOf(10, 5, 20, 20, 4, 5, 2, 25, 1)).joinToString(" "))
}

private fun breakingRecords(scores: Array<Int>): Array<Int> {
    val result = mutableListOf<Int>()

    var max = scores[0]
    var min = scores[0]
    var maxCount = 0
    var minCount = 0

    for (element in scores) {
        if (element > max) {
            max = element
            ++maxCount
        } else if (element < min) {
            min = element
            ++minCount
        }
    }

    result.add(maxCount)
    result.add(minCount)

    return result.toTypedArray()
}

private fun breakingRecords2(scores: Array<Int>): Array<Int> {

    var maxTotal = 0
    var minTotal = 0
    var max = 0
    var min = 0

    scores.forEachIndexed { index, it ->
        if (index != 0) {
            if (it > max) {
                max = it
                maxTotal++
            }
            else if (it < min) {
                min = it
                minTotal++
            }

        } else {
            max = it
            min = it
        }
    }

    return listOf(maxTotal, minTotal).toTypedArray()
}