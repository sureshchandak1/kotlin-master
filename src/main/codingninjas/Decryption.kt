fun main() {
    val str = "abcde"
    val operations = arrayListOf(
        arrayListOf(-1, 2),
        arrayListOf(1, 1),
        arrayListOf(-1, 2),
        arrayListOf(-1, 1)
    )

    println(decrypt(str, operations))
}
private fun decrypt(message: String?, operations: ArrayList<ArrayList<Int>>): String? {
    var ans = message

    for (operation in operations) {
        val isLeft = operation[0] == -1
        val times = operation[1]
        if (isLeft) {
            for (i in 0..< times) {
                ans = leftRotation(StringBuilder(ans))
                println(ans)
            }
        } else {
            for (i in 0..< times) {
                ans = rightRotation(StringBuilder(ans))
                println(ans)
            }
        }
    }

    return ans
}

private fun leftRotation(str: StringBuilder): String {

    var str = str
    val start = 0
    val end = str.length - 1

    str = reverse(str, start, end)
    str = reverse(str, start, end - 1)

    return str.toString()
}

private fun rightRotation(str: StringBuilder): String {

    var str = str
    val start = 0
    val end = str.length - 1

    str = reverse(str, start, end)
    str = reverse(str, start + 1, end)

    return str.toString()
}

private fun reverse(str: StringBuilder, start: Int, end: Int): StringBuilder {

    var start = start
    var end = end

    while (start < end) {
        val temp = str[start]
        str.setCharAt(start, str[end])
        str.setCharAt(end, temp)

        start++
        end--
    }

    return str
}