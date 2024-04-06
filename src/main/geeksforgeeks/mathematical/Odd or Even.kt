package mathematical

/*
*    https://www.geeksforgeeks.org/problems/odd-or-even3618/1
* */
fun main() {
    println(oddEven(0))
    println(oddEven(1))
    println(oddEven(113))
    println(oddEven(34131))
}

private fun oddEven(n: Int): String {
    /*
            if (n % 2 == 0) {
                return "even";
            }
            else {
                return "odd";
            }
     */

    return if ((n and 1) != 1) {
        "even"
    } else {
        "odd"
    }
}


