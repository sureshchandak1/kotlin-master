package lecture140_Greedy_Algorithms

/**
 *    https://www.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
 *    Time Complexity: O(n)
 *    Space Complexity: O(n)
 */
fun main() {
    println(reverseWords("i.like.this.program.very.much"))
    println(reverseWords("pqr.mno"))
}

private fun reverseWords(str: String): String {

    val ans = StringBuilder()

    var word = ""
    var i = str.length - 1
    while (i >= 0) {
        val ch = str[i]
        if (ch != '.') {
            word += ch
        } else {
            ans.append(reverse(word))
            ans.append(".")
            word = ""
        }

        i--
    }

    ans.append(reverse(word))

    return ans.toString()
}

private fun reverse(str: String): String {

    val builder = StringBuilder(str)

    var start = 0
    var end = str.length - 1
    var temp = ' '
    while (start < end) {
        temp = builder[start]
        builder.setCharAt(start, builder[end])
        builder.setCharAt(end, temp)

        start++
        end--
    }

    return builder.toString()
}






