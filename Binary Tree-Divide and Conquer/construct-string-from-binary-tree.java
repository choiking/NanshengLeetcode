/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
case 1: both left and right exists.   1
                                     / \
                                    2   3
                                   [1,2,3]  no needs to put "()";
                                   
case 2: only left exists              1
                                     / 
                                    2   
                                   [1,2]  no needs to put "()";

case 3: only right exists              1
                                        \ 
                                         2   
                                   [1,null,2]  we need to put "()" in the null;
                                   
case 4: none of them exists            1
                                 
                                   [1,2]  no needs to put "()";                                   

*/
class Solution {
    String res = "";
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        res += Integer.toString(t.val);
        if (t.right != null && t.left == null) {
            res += "()";
            res += "(";
            tree2str(t.right);
            res += ")";
        }
        else if (t.right == null && t.left != null) {
            res += "(";
            tree2str(t.left);
            res += ")";
        }
        else if (t.right != null && t.left != null) {
            res += "(";
            tree2str(t.left);
            res += ")";
            res += "(";
            tree2str(t.right);
            res += ")";
        }
           return res;
    }
}



public String tree2str(TreeNode t) {
        if (t == null) return "";
        
        String result = t.val + "";
        
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }


