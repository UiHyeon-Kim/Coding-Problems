class TreeNode:
  def __init__(self, val=0, left=None, right=None):
    self.val = val
    self.left = left
    self.right = right
class Solution:
  def preorderTraversal(self, root):
    if not root:
      return []
    return [root.val] + self.preorderTraversal(root.left) + self.preorderTraversal(root.right)
