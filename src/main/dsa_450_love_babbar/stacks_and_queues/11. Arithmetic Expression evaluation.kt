package stacks_and_queues

import java.util.*

/**
 *   https://www.naukri.com/code360/problems/arithmetic-expression-evaluation_1170517
 *   https://www.geeksforgeeks.org/expression-evaluation/
 *   Time Complexity: O(n)
 *   Space Complexity: O(n)
 */
fun main() {
    println(evaluate("10 + 2 * 6"))
    println(evaluate("100 * 2 + 12"))
    println(evaluate("100 * ( 2 + 12 )"))
    println(evaluate("100 * ( 2 + 12 ) / 14"))
}

private fun evaluate(str: String): Int {

    val size = str.length
    val values: Stack<Int> = Stack() // Stack for numbers
    val ops: Stack<Char> = Stack() // Stack for Operators

    var index = 0
    while (index < size) {

        if (str[index] == ' ') { // ignore whitespace
            index++
            continue
        }

        if (str[index] in '0'..'9') {

            val stringBuffer = StringBuffer()

            // There may be more than one digits in number
            while (index < size && str[index] >= '0' && str[index] <= '9') {
                stringBuffer.append(str[index++])
            }

            values.push(stringBuffer.toString().toInt())

            // for loop also increases, decrease the value of index by 1
            index--

        } else if (str[index] == '(') {
            ops.push(str[index])
        } else if (str[index] == ')') {

            while (ops.peek() != '(') {
                val value = applyOp(ops.pop(), values.pop(), values.pop())
                values.push(value)
            }

            ops.pop()

        } else if (str[index] == '+' || str[index] == '-' || str[index] == '*' || str[index] == '/') {

            while (!ops.empty() && hasPrecedence(str[index], ops.peek())) {
                val value = applyOp(ops.pop(), values.pop(), values.pop())
                values.push(value)
            }

            // Push current token to 'ops'.
            ops.push(str[index])
        }

        index++
    }

    while (!ops.empty()) {
        val value = applyOp(ops.pop(), values.pop(), values.pop())
        values.push(value)
    }

    return values.pop()
}

// Returns true if 'op2' has higher or same precedence as 'op1', otherwise returns false.
private fun hasPrecedence(op1: Char, op2: Char): Boolean {

    if (op2 == '(' || op2 == ')') {
        return false
    }

    if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
        return false
    }

    return true

}

// A utility method to apply an operator 'op' on operands 'a' and 'b'. Return the result.
private fun applyOp(op: Char, b: Int, a: Int): Int {
    when (op) {
        '+' -> return a + b
        '-' -> return a - b
        '*' -> return a * b
        '/' -> {
            if (b == 0) throw UnsupportedOperationException(
                "Cannot divide by zero"
            )
            return a / b
        }
    }
    return 0
}





