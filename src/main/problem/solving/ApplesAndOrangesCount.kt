
fun main(args: Array<String>) {
    countApplesAndOranges(7, 10, 4, 12, arrayOf(2, 3, -4), arrayOf(3, -2, -4))
}

fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {

    val startPointHome = s
    val endPointHome = t
    val appleLoc = a
    val orangeLoc = b
    var orangeOnHouse = 0
    var applesOnHouse = 0

    // Calculate of apples that fall on house
    for (element in apples) {
        val applePosition = appleLoc + element
        // applePosition >= startPointHome && applePosition <= endPointHome
        if (applePosition in startPointHome..endPointHome) {
            applesOnHouse++
        }
    }

    // Calculate of orange that fall on house
    for (element in oranges) {
        val orangePosition = orangeLoc + element
        // orangePosition >= startPointHome && orangePosition <= endPointHome
        if (orangePosition in startPointHome..endPointHome) {
            orangeOnHouse++
        }
    }

    println(applesOnHouse)
    println(orangeOnHouse)
}


