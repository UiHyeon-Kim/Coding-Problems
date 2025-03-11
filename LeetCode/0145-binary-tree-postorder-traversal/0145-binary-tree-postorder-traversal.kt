/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        root?.postorder(result)

        return result
    }

    fun TreeNode.postorder (list: MutableList<Int>) {
        left?.postorder(list)
        right?.postorder(list)
        list += `val`
    }
}