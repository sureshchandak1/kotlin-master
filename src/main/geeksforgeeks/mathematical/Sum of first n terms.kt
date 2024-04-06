package mathematical

/*
*   https://www.geeksforgeeks.org/problems/sum-of-first-n-terms5843/1
* */
fun main() {
    println(sumOfSeries(5))
    println(sumOfSeries(100))
    println(sumOfSeries(23452))
}

private fun sumOfSeries(n: Long): Long {
    return (n * n * (n + 1) * (n + 1)) / 4


    //return (long) Math.pow(n * (n + 1) / 2, 2);
}


