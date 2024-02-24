package lecture037_Recursion_Day7

import java.lang.StringBuilder


fun main() {
    println(subsequences("abc"))
    println(subsequences("bbb"))
}

private fun subsequences(str: String): ArrayList<String> {
    val ans = ArrayList<String>()
    val output = ""
    subsequences(str, output, 0, ans)
    return ans
}

private fun subsequences(str: String, output: String, index: Int, ans: ArrayList<String>) {

    // Base case
    if (index >= str.length) {
        if (output.isNotEmpty()) {
            ans.add(StringBuilder(output).toString())
        }
        return
    }

    // exclude
    subsequences(str, output, index + 1, ans)

    // include
    val currentChar = str[index]

    subsequences(str, output + currentChar, index + 1, ans)
}