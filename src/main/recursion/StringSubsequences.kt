

fun main() {
    subsequences("abc", 0, "")
}

private fun subsequences(str: String, index: Int, newString: String) {

    if (str.length == index) {
        println(newString)
        return
    }

    val currentChar = str[index]

    subsequences(str, index + 1, newString + currentChar) // to be add

    subsequences(str, index + 1, newString) // to be not add

}

