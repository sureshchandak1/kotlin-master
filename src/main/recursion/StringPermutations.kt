// All possible combination of latter

fun main() {
    val str = "abc"
    printPermutations(str, "")
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