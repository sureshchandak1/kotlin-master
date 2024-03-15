package lecture063_Tree_Interview_Questions_Day1

import kotlin.math.max

/*
*   https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1
* */
fun main() {

}

private fun diameterOfBinaryTree(root: TreeNode<Int>?): Int {
    return diameterFast(root).diameter
}

private fun diameter(root: TreeNode<Int>?): Int {

    // Base case
    if (root == null) {
        return 0
    }

    val op1 = diameter(root.left)
    val op2 = diameter(root.right)
    val op3 = height(root.left) + height(root.right)

    val ans = max(op1.toDouble(), max(op2.toDouble(), op3.toDouble())).toInt()

    return ans
}

private fun diameterFast(root: TreeNode<Int>?): Pair {

    // Base case
    if (root == null) {
        val pair = Pair(0, 0)
        return pair
    }

    val left = diameterFast(root.left)
    val right = diameterFast(root.right)

    val op1 = left.diameter
    val op2 = right.diameter
    val op3 = left.height + right.height

    val ans = Pair(0, 0)
    ans.diameter = max(op1.toDouble(), max(op2.toDouble(), op3.toDouble())).toInt()
    ans.height = (max(left.height.toDouble(), right.height.toDouble()) + 1).toInt()

    return ans
}

private fun height(root: TreeNode<Int>?): Int {
    // Base case
    if (root == null) {
        return 0
    }

    val left = height(root.left)
    val right = height(root.right)

    val ans = (max(left.toDouble(), right.toDouble()) + 1).toInt()

    return ans
}

private class Pair(diameter: Int, height: Int) {

    var diameter: Int = 0
    var height: Int = 0

    init {
        this.diameter = diameter
        this.height = height
    }
}

class TreeNode<T>(var data: T) {

    var left: TreeNode<T>? = null
    var right: TreeNode<T>? = null

}