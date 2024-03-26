package lecture070_BST_Interview_Questions_Day1

import lecture062_Tree_Introduction.TreeNode

/*
*   https://www.codingninjas.com/studio/problems/_893049
* */

fun main() {

}

private fun predecessorSuccessor(root: TreeNode?, key: Int): List<Int> {

    // Find key
    var temp: TreeNode? = root
    var pred = -1
    var succ = -1

    while (temp != null && temp.data != key) {
        if (temp.data > key) {
            succ = temp.data
            temp = temp.left
        } else {
            pred = temp.data
            temp = temp.right
        }
    }

    if (temp != null) {
        // pred ans succ

        // pred
        var leftTree: TreeNode? = temp.left
        while (leftTree != null) {
            pred = leftTree.data
            leftTree = leftTree.right
        }

        // succ
        var rightTree: TreeNode? = temp.right
        while (rightTree != null) {
            succ = rightTree.data
            rightTree = rightTree.left
        }
    }

    val ans: MutableList<Int> = ArrayList()
    ans.add(pred)
    ans.add(succ)

    return ans
}