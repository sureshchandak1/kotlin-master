// Print all permutations of a string
// permutations = All possible combination of latter
fun main() {
    val str = "abc"
    printPermutations(str, "")

    println("---------------------------------------")

    println(permute(intArrayOf(1, 2, 3)).toString()) // Not working
}

private fun printPermutations(str: String, permutations: String) {

    if (str.isEmpty()) {
        println(permutations)
        return
    }

    for (index in str.indices) {
        val currentChar = str[index]
        val newString = str.substring(0, index) + str.substring(index + 1)
        printPermutations(newString, permutations + currentChar)
    }
}

private fun permute(nums: IntArray): List<List<Int>> {
    val result: MutableList<List<Int>> = ArrayList()
    findPermutation(nums, ArrayList(), result)
    return result
}

private fun findPermutation(nums: IntArray, permuteList: ArrayList<Int>, result: MutableList<List<Int>>) {

    if (nums.isEmpty()) {
        result.add(permuteList)
        return
    }

    nums.forEachIndexed { index, element ->
        val newArray: ArrayList<Int> = nums.toCollection(ArrayList())
        newArray.removeAt(index)
        permuteList.add(element)
        findPermutation(newArray.toIntArray(), permuteList, result)
    }

}