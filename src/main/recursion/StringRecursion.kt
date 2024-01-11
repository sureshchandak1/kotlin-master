fun main() {
    var str = "abcd"
    println("$str -> ${reverse(str, (str.length - 1))} -> ${reverseUsingForLoop(str)}")

    str = ""
    println("$str -> ${reverse(str, (str.length - 1))} -> ${reverseUsingForLoop(str)}")

    findCharFirstLastIndex("abaacdaefaah", 'a')
    findCharFirstLastIndex("abaacdaefaah", 'a', -1, -1, 0)

    moveCharToEnd("axbcxxd", "", 'x', 0, 0)

    removeDuplicate("abbccda", ArrayList(), 0)

    println(checkPalindrome("121"))

}

private fun reverse(str: String, index: Int): String {

    if (index <= 0) {
        return str
    }

    val lastChar = str[index]

    return lastChar + reverse(str.substring(0, index) + str.substring(index + 1), index - 1)
}

private fun reverseUsingForLoop(str: String): String {

    val stringBuilder = StringBuilder()
    val charArray: CharArray = str.toCharArray()

    for (index in (charArray.size - 1) downTo 0 step 1) {
        stringBuilder.append(charArray[index])
    }

    return stringBuilder.toString()
}

private fun findCharFirstLastIndex(str: String, ch: Char, index: Int = 0) {

    if (str.length == index) {
        println("[ first = ${FindChar.fPosition} , last = ${FindChar.lPosition} ]")
        return
    }

    if (ch == str[index]) {
        if (FindChar.fPosition == -1) {
            FindChar.fPosition = index
        } else {
            FindChar.lPosition = index
        }
    }

    findCharFirstLastIndex(str, ch, index + 1)

}

private fun findCharFirstLastIndex(str: String, ch: Char, first: Int = -1, last: Int = -1, index: Int = 0) {

    var fPosition = first
    var lPosition = last

    if (str.length == index) {
        println("[ first = $fPosition , last = $lPosition ]")
        return
    }

    if (ch == str[index]) {
        if (fPosition == -1) {
            fPosition = index
        } else {
            lPosition = index
        }
    }

    findCharFirstLastIndex(str, ch, fPosition, lPosition, index + 1)

}

private fun moveCharToEnd(str: String, newStr: String, ch: Char, chCount: Int, index: Int) {

    var newString = newStr
    var count = chCount

    if (str.length == index) {
        for (i in 1..count) {
            newString += ch
        }
        println(newString)
        return
    }

    val currentChar = str[index]
    if (currentChar == ch) {
        ++count
    } else {
        newString += currentChar
    }

    moveCharToEnd(str, newString, ch, count, index + 1)
}

private fun removeDuplicate(str: String, chList: MutableList<Char>, index: Int) {

    if (str.length == index) {
        var newStr = ""
        chList.forEach {
            newStr += it
        }
        println(newStr)
        return
    }

    val currentChar = str[index]
    if (!chList.contains(currentChar)) {
        chList.add(currentChar)
    }

    removeDuplicate(str, chList, index + 1)
}

private fun checkPalindrome(value: String) : Boolean {

    val valueLength = value.length

    for (index in 0 ..< valueLength / 2) {
        if (value[index] != value[valueLength - index - 1]) {
            return false
        }
    }

    // val reverseValue = reverse(value, value.length - 1)
    // return value == reverseValue

    return true
}

private class FindChar {

    companion object {
        var fPosition = -1
        var lPosition = -1
    }

}