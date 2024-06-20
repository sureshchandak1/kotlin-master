package lecture064_Tree_Interview_Questions_Day2

import lecture062_Tree_Introduction.TreeNode

/*
*  https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
* */
fun main() {

}

private fun traverseBoundary(root: TreeNode?): List<Int> {

    val ans: MutableList<Int> = ArrayList()

    if (root == null) {
        return ans
    }

    ans.add(root.data)

    // Tree left node store in ans
    traverseLeft(root.left, ans)

    // Tree leaf node store in ans
    // left leaf node
    traverseLeaf(root.left, ans)
    // right leaf node
    traverseLeaf(root.right, ans)

    // Tree right node store in ans
    traverseRight(root.right, ans)

    return ans
}

private fun traverseLeft(root: TreeNode?, ans: MutableList<Int>) {

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

private fun traverseLeaf(root: TreeNode?, ans: MutableList<Int>) {

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

private fun traverseRight(root: TreeNode?, ans: MutableList<Int>) {

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

