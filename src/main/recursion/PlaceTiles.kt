// Place Tiles of size 1xm in a floor of size nxm
fun main() {
    println("Total counts = ${placeTiles(3, 3)}")
    println("Total counts = ${placeTiles(4, 3)}")
    println("Total counts = ${placeTiles(4, 2)}")
}

private fun placeTiles(n: Int, m: Int) : Int {

    if (n == m) {
        return 2
    }
    if (n < m) {
        return 1
    }

    // Vertically
    val verPlacements = placeTiles(n - m, m)

    // Horizontally
    val horPlacements = placeTiles(n - 1, m)

    return verPlacements + horPlacements
}

