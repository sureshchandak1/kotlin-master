package mathematical

/*
*   https://www.geeksforgeeks.org/problems/factorial5739/1
* */
fun main() {
    println(factorial(5))
    println(factorial(13))
    println(factorial(18))
}

private fun factorial(n: Int): Long {

    var ans: Long = 1

    for (i in n downTo 2) {
        ans = ans * i
    }

    return ans
}


