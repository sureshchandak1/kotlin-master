package lecture039_Recursion_Day9

import java.util.*


fun main() {
    println(uniquePrem("abc"))
    println(uniquePrem("aa"))
}

private fun uniquePrem(str: String): ArrayList<String> {
    val ans: MutableSet<String> = HashSet()

    if (isAllSameChar(str)) {
        ans.add(str)
    } else {
        permutations(StringBuilder(str), ans, 0)
    }

    val result = ArrayList(ans)
    Collections.sort(result)

    return result
}

private fun permutations(str: StringBuilder, ans: MutableSet<String>, index: Int) {

    // Base case
    if (index >= str.length) {
        ans.add(str.toString())
        return
    }

    var tempCh = ' '
    for (j in index..<str.length) {
        tempCh = str[index]
        str.setCharAt(index, str[j])
        str.setCharAt(j, tempCh)

        permutations(str, ans, index + 1)

        // backtrack (swap value in same string so back to original string after work done)
        tempCh = str[index]
        str.setCharAt(index, str[j])
        str.setCharAt(j, tempCh)
    }
}

private fun isAllSameChar(str: String): Boolean {
    val size = str.length
    for (i in 1..<size) {
        if (str[i] != str[0]) {
            return false
        }
    }

    return true
}