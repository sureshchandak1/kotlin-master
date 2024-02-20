fun main() {
    println(checkParentheses("()", 0, false))
    println(checkParentheses("()[]{}", 0, false))
    println(checkParentheses("(]", 0, false))
    println(checkParentheses("{[]}", 0, false))
    println(checkParentheses("{(]}", 0, false))
    println(checkParentheses("{[]}"))
}

private val map: MutableMap<Char, Char> = mutableMapOf(
    Pair('(', ')'),
    Pair('{', '}'),
    Pair('[', ']')
)

private fun checkParentheses(str: String, index: Int = 0, result: Boolean = false) : Boolean {

    if (index >= str.length) {
        return result
    }

    val currentChar = str[index]
    val nextChar = str[index + 1]

    val ans = nextChar == map[currentChar]

    return checkParentheses(str, index + 2, ans)
}

private fun checkParentheses(str: String) : Boolean {

    str.toCharArray().forEach { element ->
        val closePar = map[element]
        closePar?.let {
            if (!str.contains(closePar.toString())) {
                return false
            }
        }
    }

    return true
}

