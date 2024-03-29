import lecture062_Tree_Introduction.TreeNode

/*
*   https://leetcode.com/problems/same-tree/
* */

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

private:
    bool isSameTree(TreeNode* p, TreeNode* q) {

        // Base case
        if (p == NULL && q == NULL) {
            return true;
        }
        if (p == NULL && q != NULL) {
            return false;
        }
        if (p != NULL && q == NULL) {
            return false;
        }

        bool left = isSameTree(p->left, q->left);
        bool right = isSameTree(p->right, q->right);
        bool isSameData = p->val == q->val;

        return left && right && isSameData;
    }


