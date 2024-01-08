fun main() {
    val arr = arrayOf("Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten")

    val n = readln()
    sayDigits(n.toInt(), arr)
}

private fun sayDigits(value: Int, array: Array<String>) {

    var n = value

    // Base case
    if (n == 0) return

    // Processing
    val digit = n % 10
    n /= 10

    // Recursive call
    sayDigits(n, array)

    print(array[digit] + " ")
}