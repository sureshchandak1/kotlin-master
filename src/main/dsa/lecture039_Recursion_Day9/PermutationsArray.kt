package lecture039_Recursion_Day9


fun main() {
    println(permutations(mutableListOf(1, 2, 3), 3))
    println(permutations(mutableListOf(1, 2), 2))
    println(permutations(mutableListOf(1), 1))
}

private fun permutations(arr: MutableList<Int>, size: Int): ArrayList<ArrayList<Int>> {

    val ans = ArrayList<ArrayList<Int>>()

    permutations(arr, size, 0, ans)

    return ans
}

private fun permutations(
    arr: MutableList<Int>, size: Int, index: Int,
    ans: ArrayList<ArrayList<Int>>
) {
    // Base case
    if (index >= size) {
        ans.add(ArrayList(arr))
        return
    }

    var temp = 0
    for (j in index..< size) {
        temp = arr[index]
        arr[index] = arr[j]
        arr[j] = temp

        permutations(arr, size, index + 1, ans)

        // Backtrack to previous arr
        temp = arr[index]
        arr[index] = arr[j]
        arr[j] = temp
    }
}