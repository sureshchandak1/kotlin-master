package mathematical

/*
*   https://www.geeksforgeeks.org/problems/replace-all-0s-with-5/1
* */
fun main() {
    println(convertFive(0))
    println(convertFive(1004))
    println(convertFive(121))
    println(convertFive(2308904))
}

private fun convertFive(num: Int): Int {

    var num = num
    if (num == 0) {
        return 5
    }

    var ans = 0

    while (num > 0) {
        var mod = num % 10

        if (mod == 0) {
            mod = 5
        }

        ans = ans * 10 + mod

        num = num / 10
    }

    return reverseNumber(ans)
}

private fun reverseNumber(num: Int): Int {

    var num = num
    var ans = 0

    while (num > 0) {
        val rem = num % 10
        ans = ans * 10 + rem
        num = num / 10
    }

    return ans
}


