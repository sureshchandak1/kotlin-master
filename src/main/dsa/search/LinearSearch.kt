package search

fun main() {

    val arr = arrayOf(5, 7, -2, 10, 22, -2, 0, 5, 22, 1)

    println(search(arr, 1))
    println(search(arr, 30))
}

private fun search(arr: Array<Int>, element: Int) : Boolean {

    for (item in arr) {
        if (item == element) return true
    }

    return false

}

