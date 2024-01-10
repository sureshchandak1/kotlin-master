fun main() {
    val str = "23"
    printCombination(str, 0, "")
}

private val keypad = arrayOf(".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz")

private fun printCombination(str: String, index: Int, combination: String) {

    if (str.length == index) {
        println(combination)
        return
    }

    val currentChar = str[index]
    val mapping = keypad[currentChar - '0']

    mapping.toCharArray().forEach { ch ->
        printCombination(str, index + 1, combination + ch)
    }
}