package binaryTrees

import printArray

/**
 *    https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
 *    Time Complexity: O(N)
 *    Complexity Space: O(Height of the Tree)
 */
fun main() {
    val root = TreeBuilder.buildTree()

    println("Boundary Traversal")
    val result = boundary(root)
    printArray(result)
}

private fun boundary(node: TreeNode?): ArrayList<Int> {
    val ans = ArrayList<Int>()

    if (node == null) {
        return ans
    }

    ans.add(node.data)

    // store left nodes
    traverseLeft(node.left, ans)

    // store left leaf nodes
    traverseLeaf(node.left, ans)
    // store right leaf nodes
    traverseLeaf(node.right, ans)

    // store right nodes
    traverseRight(node.right, ans)

    return ans
}

private fun traverseLeft(root: TreeNode?, ans: ArrayList<Int>) {

    // Base case
    if (root == null) {
        return
    }
    if (root.left == null && root.right == null) {
        return
    }

    ans.add(root.data)

    if (root.left != null) {
        traverseLeft(root.left, ans)
    } else {
        traverseLeft(root.right, ans)
    }
}

private fun traverseRight(root: TreeNode?, ans: ArrayList<Int>) {

    // Base case
    if (root == null) {
        return
    }
    if (root.left == null && root.right == null) {
        return
    }

    if (root.right != null) {
        traverseRight(root.right, ans)
    } else {
        traverseRight(root.left, ans)
    }

    ans.add(root.data)
}

private fun traverseLeaf(root: TreeNode?, ans: ArrayList<Int>) {

    // Base case
    if (root == null) {
        return
    }
    if (root.left == null && root.right == null) {
        ans.add(root.data)
        return
    }

    traverseLeaf(root.left, ans)

    traverseLeaf(root.right, ans)
}
















