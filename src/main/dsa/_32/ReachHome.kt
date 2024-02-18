package _32

import javax.swing.text.Position

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