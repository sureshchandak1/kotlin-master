package lecture032_Recursion_Day2

fun main() {
    reachHome(1, 10)
}

private fun reachHome(startPosition: Int, destination: Int) {

    println("Position = $startPosition, Destination = $destination")

    // Base case
    if (startPosition == destination) {
        println("Reach Home")
        return
    }


    // Recursion
    reachHome(startPosition + 1, destination)
}