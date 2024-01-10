

fun main() {
    subsequences("abc", 0, "")

    println("-------------------------------------------")

    val set = HashSet<String>()
    subsequences("aaa", 0, "", set)
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

private fun subsequences(str: String, index: Int, newString: String, set: MutableSet<String>) {

    if (str.length == index) {
        if (!set.contains(newString)) {
            set.add(newString)
            println(newString)
        }
        return
    }

    val currentChar = str[index]

    subsequences(str, index + 1, newString + currentChar, set) // to be add

    subsequences(str, index + 1, newString, set) // to be not add

}

