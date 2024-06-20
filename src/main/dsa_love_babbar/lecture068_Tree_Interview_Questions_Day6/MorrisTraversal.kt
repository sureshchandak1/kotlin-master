package lecture068_Tree_Interview_Questions_Day6

import lecture062_Tree_Introduction.TreeNode

fun main(args: Array<String>) {
    /* Constructed binary tree is
       1
     /   \
    2      3
  /   \
 4     5
*/
    val tree = BinaryTree()
    tree.root = TreeNode(1)
    tree.root!!.left = TreeNode(2)
    tree.root!!.right = TreeNode(3)
    tree.root!!.left!!.left = TreeNode(4)
    tree.root!!.left!!.right = TreeNode(5)

    tree.morrisTraversal(tree.root)
}

internal class BinaryTree {



    var root: TreeNode? = null

    /* Function to traverse a
       binary tree without recursion
       and without stack */
    fun morrisTraversal(root: TreeNode?) {

        var current: TreeNode?
        var pre: TreeNode?

        if (root == null) return

        current = root
        while (current != null) {

            if (current.left == null) {
                print(current.data.toString() + " ")
                current = current.right
            } else {
                /* Find the inorder
                    predecessor of current
                 */
                pre = current.left
                while (pre!!.right != null && pre.right != current) {
                    pre = pre.right
                }

                /* Make current as right
                   child of its
                 * inorder predecessor */
                if (pre.right == null) {
                    pre.right = current
                    current = current.left
                } else {
                    pre.right = null
                    print(current.data.toString() + " ")
                    current = current.right
                } /* End of if condition pre->right == NULL
                   */
            } /* End of if condition current->left == NULL*/
        } /* End of while */
    }
}

