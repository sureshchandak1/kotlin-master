fun main() {
    val result = gradingStudents(arrayOf(73, 67, 38, 33))
    println(result.joinToString("\n"))
}

private fun gradingStudents(grades: Array<Int>): Array<Int> {
    val gradeList: MutableList<Int> = ArrayList()
    grades.forEach { item ->
        if (item >= 38 && (item % 5) > 2) {
            val total = item + (5 - (item % 5))
            gradeList.add(total)
        } else {
            gradeList.add(item)
        }
    }
    return gradeList.toTypedArray()
}



