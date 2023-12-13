fun main(args: Array<String>) {
    println(getTotalX(arrayOf(2,6), arrayOf(24,36)))
    println(getTotalX(arrayOf(2,4), arrayOf(16,32, 96)))
}

private fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    var total = 0
    for (x in 1..100) {
        var status = true

        for (element in b) {
            if (element % x != 0) {
                status = false
                break
            }
        }

        if (status) {
            for (element in a) {
                if (x % element != 0) {
                    status = false
                    break
                }
            }
        }

        if (status) {
            total++
        }
    }
    return total
}


