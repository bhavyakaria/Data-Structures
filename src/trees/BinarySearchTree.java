/*
 * h -> Height of the Tree
 * n -> Total nodes in the tree
 * Algorithm 		Average      Worst case
 *  Space 		O(n)            O(n)
 *  Search 		O(log n) 	O(n)
 *  Insert 		O(log n) 	O(n)
 *  Delete 		O(log n) 	O(n)
 * We can construct a BST with only Preorder or Postorder or Level Order traversal. 
 * Note that we can always get inorder traversal by sorting the only given traversal.
 */
package trees;

/**
 *
 * @author Parzival
 */
public class BinarySearchTree {
    
    static Node root;
    
    // Initializing the root as null in the default constructor
    public void BinarySearchTree() {
        this.root = null;
    }
    
    // Inserting function
    public static void insert(int value) {
        Node newNode = new Node(value);
        
        if(root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        
        while(true) {
            parent = current;
            
            if(value < current.data) {
                current = current.left;
                if(current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if(current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }  
    }
    
    public static boolean search(int value) {
        if(root == null) {
            return false;
        }
        Node current = root;
        
        while(current != null) {
            if(current.data == value) {
                return true;
            } else if (current.data > value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }
    
    // Inorder Traversal of the Tree 
    // Also you get the sorted output i.e. from min to max  
    public void inOrderTraversal(Node root){
        if(root!=null){
            inOrderTraversal(root.left);
            System.out.print(" " + root.data);
            inOrderTraversal(root.right);
        }
    }
    
    // Delete has Three cases
    // Case 1: If node to be deleted has no children
    // Case 2: If node to be deleted has 1 children
    // Case 3: If node to be deleted has 2 children
    
    public boolean delete(int value) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        
        while(current.data != value) {
            parent = current;
            
            if(value < current.data) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            
            if(current == null) {
                return false;
            }
        }
        
        // if we reached here means we have found the node to be deleted
        // Also we know is it the left child or the right child
        
        // Case 1: No Children
        if(current.left == null && current.right == null) {
            if(current == root){
                root = null;
            }
            if(isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2: node to be deleted has 1 child
        else if (current.right == null) {
            if(current == root) {
                root = current.left;
            } else if(isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if(current.left == null) {
            if(current == root) {
                root = current.right;
            } else if(isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        //  Case 3: Node to be deleted has 2 children
        else if(current.left != null && current.right != null) {
            // Now we have to find a succesor node from right sub tree
            Node successor = getSuccessor(current); 
            
            if( current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    } 
    
    private Node getSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.right;
        
        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        
        // Check if current has right child
        // If yes then add that right child to left of successorParent
        if(current.right != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        
        return successor;
    }
    
    public static void main(String[] args) {
        
        BinarySearchTree bt = new BinarySearchTree();
        
        bt.insert(6);
        bt.insert(4);
        bt.insert(5);
        bt.insert(8);
        bt.insert(3);
        
        bt.inOrderTraversal(root);
        System.out.println("");
        bt.delete(5);
        bt.inOrderTraversal(root);
        System.out.println("");
        boolean x = bt.search(8);
        System.out.println(x);
    }
    
}
