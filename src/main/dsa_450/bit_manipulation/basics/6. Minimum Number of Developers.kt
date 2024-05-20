package bit_manipulation.basics

import printArray

/**
 *    https://leetcode.com/problems/smallest-sufficient-team/description/
 */
fun main() {
    val reqSkills = arrayOf("algorithms", "math", "java", "reactjs", "csharp", "aws")
    val people = listOf(
        listOf("algorithms", "math", "java"), listOf("algorithms", "math", "reactjs"),
        listOf("java", "csharp", "aws"), listOf("reactjs", "csharp"),
        listOf("csharp", "math"), listOf("aws", "java")
    )

    printArray(smallestSufficientTeam(reqSkills, people))
}

private var result = ArrayList<Int>()

private fun smallestSufficientTeam(reqSkills: Array<String>, people: List<List<String>>): IntArray {

    val skillMap: MutableMap<String, Int> = HashMap()
    for ((index, skill) in reqSkills.withIndex()) {
        skillMap[skill] = index
    }

    val skillMask = IntArray(people.size)
    for ((i, skills: List<String>) in people.withIndex()) {
        for (skill: String in skills) {
            val index: Int = skillMap[skill]!!
            val onMask = 1 shl index
            skillMask[i] = (skillMask[i] or onMask)
        }
    }

    solution(skillMask, reqSkills.size, 0, ArrayList(), 0)

    val finalResult = IntArray(result.size)
    for ((i, value) in result.withIndex()) {
        finalResult[i] = value
    }

    return finalResult
}

private fun solution(skillMasks: IntArray, nSkills: Int, currPeople: Int, ans: ArrayList<Int>, skillMask: Int) {

    // base case
    if (currPeople == skillMasks.size) {
        if (skillMask == ((1 shl nSkills) - 1)) {
            if (result.size == 0 || ans.size < result.size) {
                result = ArrayList(ans)
            }
        }
        return
    }

    solution(skillMasks, nSkills, currPeople + 1, ans, skillMask) // No

    ans.add(currPeople)

    solution(skillMasks, nSkills, currPeople + 1, ans, (skillMask or skillMasks[currPeople])) // Yes

    ans.removeAt(ans.size - 1)
}














