package lecture064_Tree_Interview_Questions_Day2

import lecture063_Tree_Interview_Questions_Day1.TreeNode

/*
*  https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
* */
fun main() {

}

private fun printLeftView(root: TreeNode<Int>?) {
    leftView(root, 0, ArrayList())
}

private fun leftView(root: TreeNode<Int>?, level: Int, ans: MutableList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    if (level == ans.size) {
        ans.add(root.data)
    }

    leftView(root.left, level + 1, ans)

    leftView(root.right, level + 1, ans)
}

