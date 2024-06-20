package lecture061_Queue_Interview_Questions

/*
*   https://www.geeksforgeeks.org/problems/circular-tour-1587115620/1
* */
fun main() {
    println(tour(intArrayOf(4, 6, 7, 4), intArrayOf(6, 5, 3, 5)))
}

//Function to find starting point where the truck can start to get through
//the complete circle without exhausting its petrol in between.
private fun tour(petrol: IntArray, distance: IntArray): Int {
    val size = petrol.size

    var deficit = 0
    var balance = 0
    var start = 0

    for (i in 0..< size) {

        balance = balance + petrol[i] - distance[i]

        if (balance < 0) {
            deficit += balance
            start = i + 1
            balance = 0
        }
    }

    if (balance + deficit >= 0) {
        return start
    }

    return -1
}