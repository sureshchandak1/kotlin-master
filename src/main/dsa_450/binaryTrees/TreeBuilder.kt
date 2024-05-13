package binaryTrees

object TreeBuilder {

    // Create binary tree
    internal fun buildTree(): TreeNode? {

        println("Enter the data: ")
        val data: Int = readln().toInt()

        val root = TreeNode(data)

        if (data == -1) {
            return null
        }

        println("Enter data for inserting in left of $data ")
        root.left = buildTree()

        println("Enter data for inserting in right of $data ")
        root.right = buildTree()

        return root

    }
}