// Find the number of ways in which you can invite n people to your party, single or in pairs

fun main() {
    println("Total ways = ${callGuests(4)}")
}

private fun callGuests(n: Int) : Int {

    if (n <= 1) {
        return 1
    }

    // single
    val ways1 = callGuests(n - 1)

    // pair
    val ways2 = (n - 1) * callGuests(n - 2)

    return ways1 + ways2
}