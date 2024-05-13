package binaryTrees

import kotlin.math.max

fun main() {
    val root: TreeNode? = TreeBuilder.buildTree()

    println("Diameter = ${diameter(root).first}")
}

// Optimal Approach
private fun diameter(root: TreeNode?): Pair<Int, Int> { // Pair -> first = diameter, second = height

    // base case
    if (root == null) {
        return Pair(0, 0)
    }

    val left = diameter(root.left)
    val right = diameter(root.right)

    val leftDiameter = left.first
    val rightDiameter = right.first
    val height = left.second + right.second

    val dia = max(leftDiameter.toDouble(), max(rightDiameter.toDouble(), height.toDouble())).toInt()
    val h = max(left.second, right.second) + 1
    val ans = Pair(dia, h)

    return ans
}

// Brute Force Approach
private fun binaryTreeDiameter(node: TreeNode?): Int {

    // Base case
    if (node == null) {
        return 0
    }

    val left = binaryTreeDiameter(node.left)

    val right = binaryTreeDiameter(node.right)

    val height = height(node.left) + height(node.right)

    val ans = max(left.toDouble(), max(right.toDouble(), height.toDouble())).toInt()

    return ans
}

private fun height(node: TreeNode?): Int {
    // Base case
    if (node == null) {
        return 0
    }

    val left = height(node.left)

    val right = height(node.right)

    return (max(left.toDouble(), right.toDouble()) + 1).toInt()
}



