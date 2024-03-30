package lecture075_Heap_Interview_Questions_Day1

import lecture062_Tree_Introduction.TreeNode


/*
*   https://www.geeksforgeeks.org/problems/bst-to-max-heap/1
* */
fun main() {

}

private fun convertToMaxHeapUtil(root: TreeNode?) {

    val inorder: MutableList<Int> = ArrayList()

    inorder(root, inorder)

//    index = 0
//    fillPreorder(root, inorder) // convert to min heap

    index = 0
    fillPostorder(root, inorder) // convert to max heap
}

// L N R
private fun inorder(root: TreeNode?, ans: MutableList<Int>) {

    // Base case
    if (root == null) {
        return
    }

    inorder(root.left, ans) // L

    ans.add(root.data) // N

    inorder(root.right, ans) // R
}

private var index = 0

// N L R - Preorder (For min heap)
private fun fillPreorder(root: TreeNode?, inorder: List<Int>) {

    // Base case
    if (root == null) {
        return
    }

    root.data = inorder[index++] // N

    fillPreorder(root.left, inorder) // L

    fillPreorder(root.right, inorder) // R
}

// L R N - Postorder (For max heap)
private fun fillPostorder(root: TreeNode?, inorder: List<Int>) {

    // Base case
    if (root == null) {
        return
    }

    fillPostorder(root.left, inorder) // L

    fillPostorder(root.right, inorder) // R

    root.data = inorder[index++] // N
}





