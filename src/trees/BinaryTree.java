/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Parzival
 */
public class BinaryTree {
    
    static Node root;
    
    public static void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }
    
    
    public static void main(String[] args) {
        
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(6);
        bt.root.left = new Node(5);
        bt.root.right = new Node(8);
        
        bt.traverseInOrder(root);
        
        
        
    }
    
}
