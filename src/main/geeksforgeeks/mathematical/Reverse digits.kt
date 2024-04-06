package mathematical

/*
*    https://www.geeksforgeeks.org/problems/reverse-digit0316/1
* */
fun main() {
    println(reverseDigit(200))
    println(reverseDigit(2432))
}

private fun reverseDigit(n: Long): Long {

    var n = n
    var ans: Long = 0

    while (n > 0) {
        val rem = n % 10
        ans = ans * 10 + rem
        n = n / 10
    }

    return ans
}