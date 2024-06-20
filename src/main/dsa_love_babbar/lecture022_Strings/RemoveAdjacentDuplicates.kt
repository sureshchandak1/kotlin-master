package lecture022_Strings

fun main() {
    println(removeDuplicates1("abbaca"))
    println(removeDuplicates1("azxxzy"))
    println(removeDuplicates1("aaaaaaaaa"))
}

private fun removeDuplicates(s: String): String {

    var str = s
    var index = 0
    while (index < str.length) {

        var i = index + 1
        var isRemove = false
        while (i < str.length && str[index] == str[i]) {
            i++
            isRemove = true
        }

        if (isRemove) {
            str = str.removeRange(index, i)
            index = 0
        } else {
            index++
        }
    }

    return str

}

private fun removeDuplicates1(s: String): String {

    var str = s
    var index = 0
    while (index < str.length) {

        val i = index + 1
        if (i < str.length && str[index] == str[i]) {
            str = str.removeRange(index, i + 1)
            index = 0
        } else {
            index++
        }

    }

    return str

}