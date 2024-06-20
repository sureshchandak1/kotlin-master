package lecture064_Tree_Interview_Questions_Day2

import lecture062_Tree_Introduction.BinaryTreeNode

/*
*   https://www.geeksforgeeks.org/problems/right-view-of-binary-tree/1
* */
fun main() {

}

private fun printRightView(root: BinaryTreeNode<Int>?): ArrayList<Int> {
    val ans = ArrayList<Int>()

    rightView(root, 0, ans)

    return ans
}

private fun rightView(root: BinaryTreeNode<Int>?, level: Int, ans: ArrayList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    if (level == ans.size) {
        ans.add(root.data)
    }

    rightView(root.right, level + 1, ans)

    rightView(root.left, level + 1, ans)
}