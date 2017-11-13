/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
//every time we meet '(' , create left child node, then if we meet '(' again from the same parent node, we create right child node.
//If every time we meet ')', just return to parent node.

//If every time we meet ')', just return to parent node.
    int pos = 0;
    public TreeNode str2tree(String s) {
        if (s.equals(" ")) return null;
        if (pos == s.length()) return null;
        StringBuilder rootVal = new StringBuilder();
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (c != '(' && c != ')') {
                rootVal.append(c);
                pos++;
            }
            else break;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(rootVal.toString()));
        //there will 2 case, we met '(' or ')'
       //every time we meet '(' , create left child node,
        if (pos < s.length() && s.charAt(pos) == '(') {
            pos++;
            root.left = str2tree(s);
            pos++;
            //if we meet '(' again from the same parent node, we create right child node.
            if (pos < s.length() && s.charAt(pos) == '(') {
                pos++;
                root.right = str2tree(s);
                pos++;
            }
        }
        //If every time we meet ')', just return to parent node.
        return root;
    }    
}