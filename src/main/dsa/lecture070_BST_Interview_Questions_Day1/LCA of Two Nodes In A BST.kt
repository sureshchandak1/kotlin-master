package lecture070_BST_Interview_Questions_Day1

import lecture062_Tree_Introduction.TreeNode

/*
*   https://www.codingninjas.com/studio/problems/lca-in-a-bst_981280
* */
fun main() {

}

private fun lcaInaBST(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
    return lca2(root, p, q)
}

private fun lca1(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {

    // Base case
    if (root == null) {
        return null
    }

    if (root.data < p.data && root.data < q.data) {
        return lca1(root.right, p, q)
    }

    if (root.data > p.data && root.data > q.data) {
        return lca1(root.left, p, q)
    }

    return root
}

private fun lca2(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {

    var root: TreeNode? = root
    while (root != null) {
        root = if (root.data < p.data && root.data < q.data) {
            root.right
        } else if (root.data > p.data && root.data > q.data) {
            root.left
        } else {
            return root
        }
    }

    return null
}