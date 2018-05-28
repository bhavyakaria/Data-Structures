/*
 * Time Complexity:
 * Insert and Delete : O(1) -> if pointer to position present or else O(n)
 * Search and Space  : O(n)
 */
package linked_list;

/**
 *
 * @author Parzival
 */
public class SingleLinkedList {
    static Node head;
    
    SingleLinkedList() {
        head = null;
    }
    
    static class Node {
        int data;
        Node next;
        
        Node(int value) {
            this.data = value;
            next = null;
        }
    }
    
    // Add the node in the end
    public static void append(int value) {
        Node newNode = new Node(value);
        
        if(head == null) {
            head = newNode;
            return;
        }
        Node current = head; 
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    // Add the node in the beginning
    public static void prepend(int value) {
        Node newNode = new Node(value);
        
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        
    }
    
    // Delete with value
    public static boolean deleteWithValue(int value) {
        
        if(head == null) {
            return false;
        }
        Node current = head;
        while(current.next != null) {
            if(current.next.data == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false; 
    }
    
    // Print the Linked List
    public static void display() {
        Node current = head;
        while(current.next != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.print(current.data);
    }
    
    public static void main(String[] args) {
        SingleLinkedList sl = new SingleLinkedList();
        
        sl.append(10);
        sl.append(20);
        sl.append(50);
        sl.append(30);
        sl.append(40);
        sl.deleteWithValue(50);
        sl.display();
    }
    
}
