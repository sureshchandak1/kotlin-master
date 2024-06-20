package lecture038_Recursion_Day8

fun main() {
    println(letterCombinations("23"))
    println(letterCombinations("77"))
    println(letterCombinations(""))
}

private val keypad = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

private fun letterCombinations(digits: String): List<String> {
    val ans = ArrayList<String>()

    if (digits.isEmpty()) {
        return ans
    }

    createCombinations(digits, digits.length, 0, "", ans)

    return ans
}

private fun createCombinations(digits: String, size: Int, index: Int, combination: String, ans: ArrayList<String>) {

    // Base case
    if (index == size) {
        ans.add(combination)
        return;
    }

    val currentCh = digits[index]
    val mapping = keypad[currentCh - '0']

    for (ch in mapping) {
        createCombinations(digits, size, index + 1, combination + ch, ans)
    }

}