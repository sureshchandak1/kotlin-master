package lecture033_Recursion_Day3

fun main() {

    val arr = arrayOf(5, 7, -2, 10, 22, -2, 0, 5, 22, 1)

    println(search(arr, 1))
    println(search(arr, 30))

    println(search(arr, 1, 0, arr.size))
    println(search(arr, 30, 0, arr.size))

}

private fun search(arr: Array<Int>, element: Int) : Boolean {

    for (item in arr) {
        if (item == element) return true
    }

    return false

}

private fun search(arr: Array<Int>, element: Int, index: Int, size: Int) : Boolean {

    if (index == size) return false

    if (arr[index] == element) {
        return true
    } else {
        val remainingSearch = search(arr, element, index + 1, size)

        return remainingSearch
    }

}