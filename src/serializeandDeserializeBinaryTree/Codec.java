package serializeandDeserializeBinaryTree;

import triangle.Solution;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    /*
    * 对二叉树进行序列化，反序列化
    * 其中序列化就是将二叉树转化成一个字符串，这里考虑使用数组存储的方式
    * 反序列化就是将字符串解析成二叉树
    * 再数组中，一个节点的左子节点为 2*index + 1
    * 右子节点为 2*index + 2
    * 父节点为
    * (index-1)/2
    *
    *
    * */
    // Encodes a tree to a single string.
    private String[] element;
    private int index;
    private StringBuilder tmpRes;
    public String serialize(TreeNode root) {
        /*
        * 使用先序遍历将二叉树转化为字符串
        * */
        tmpRes = new StringBuilder("");
        preOrder(root);
        tmpRes.deleteCharAt(tmpRes.length()-1);
        return tmpRes.toString();
    }

    private void preOrder(TreeNode root){
        if (root==null){
            tmpRes.append('#'+",");
            return;
        }
        tmpRes.append(root.val+",");
        preOrder(root.left);
        preOrder(root.right);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        element = data.split(",");
        return cteateTreeByPreOrder();
    }
    private TreeNode cteateTreeByPreOrder(){
        if (index>=element.length) return null;
        if (element[index].equals("#")) {
            ++index;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(element[index++]));
        root.left = cteateTreeByPreOrder();
        root.right = cteateTreeByPreOrder();
        return root;
    }
    public static void main(String[] args) {
        String test = "1,2,3,4,5,6,#,";
    }
}
