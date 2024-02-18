package _32

fun main() {
    val counts = arrayOf("Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
    println(sayDigits(412, counts))
}

private fun sayDigits(n: Int, counts: Array<String>) {

    // Base Case
    if (n == 0) return

    // Processing
    val digit = n % 10

    // Recursion
    sayDigits(n / 10, counts)

    print("${counts[digit]} ")

}