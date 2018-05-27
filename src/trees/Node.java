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
public class Node {
    int data;
    Node left, right;
    
    Node(int value) {
        this.data = value;
        left = null;
        right = null;
    }
    
}
