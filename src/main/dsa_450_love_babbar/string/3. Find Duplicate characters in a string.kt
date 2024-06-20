package string

/**
 *   https://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
 */
fun main() {
    printDuplicateChar("geeksforgeeks")
    println()
    printDuplicateChar("leetcode")
}

private fun printDuplicateChar(str: String) {

    val size = str.length
    val countMap: MutableMap<Char, Int> = HashMap()

    for (i in 0 ..< size) {
        if (isValidChar(str[i])) {
            countMap.merge(str[i], 1) { a1: Int, a2: Int ->
                a1 + a2
            }
        }
    }

    for (entry in countMap.entries) {
        if (entry.value > 1) {
            println("${entry.key} = ${entry.value}")
        }
    }
}

private fun isValidChar(ch: Char) : Boolean {
    return (ch in 'A' .. 'Z') || (ch in 'a' .. 'z') || (ch in '0' .. '9')
}




