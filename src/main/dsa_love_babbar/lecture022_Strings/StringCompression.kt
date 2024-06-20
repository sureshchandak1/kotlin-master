package lecture022_Strings

fun main() {
    val chars: CharArray = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')
    println(compress(chars))
}

private fun compress(chars: CharArray): Int {

    var index = 0
    var ansIndex = 0
    val size = chars.size

    while (index < size) {

        var j = index + 1
        while (j < size && chars[index] == chars[j]) {
            j++
        }

        chars[ansIndex++] = chars[index]

        val count = j - index

        if (count > 1) {
            val countStr: String = count.toString()
            for (ch in countStr) {
                chars[ansIndex++] = ch
            }
        }

        index = j
    }

    return ansIndex

}