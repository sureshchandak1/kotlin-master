// Longest Common Prefix

fun main() {
    var strs: Array<String> = arrayOf("flower","flow","flight")
    println(strs.commonPrefix())

    strs = arrayOf("a")
    println(strs.commonPrefix())

    strs = arrayOf("reflower","flow","flight")
    println(strs.commonPrefix())
}

fun Array<String>.commonPrefix(prefix: String = "", index: Int = 0) : String {

    if (size == 1) {
        return this[0]
    }

    if (index + 1 == size) {
        return this[index].commonPrefixWith(prefix)
    }

    val commonPrefix = if (prefix.isEmpty()) {
        this[index].commonPrefixWith(this[index + 1])
    } else {
        this[index + 1].commonPrefixWith(prefix)
    }

    return if (commonPrefix.isEmpty()) {
        ""
    } else {
        commonPrefix(commonPrefix, index + 1)
    }

}



