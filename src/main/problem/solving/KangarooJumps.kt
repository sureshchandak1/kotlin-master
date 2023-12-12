fun main(args: Array<String>) {
    println(kangaroo(0, 3, 4, 2))
}

private fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {

    val distance = x2 - x1
    val jump = v1 - v2

    return if (v1 > v2 && distance % jump == 0) {
        "YES"
    } else {
        "NO"
    }
}