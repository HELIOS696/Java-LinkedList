/*
 * This class will handle the modifications of the list
 * This includes: adding a node to the tail and a specific location and
 * removing a node at the tail and a specific location.
 * Each modification method will take the current list as well as the data
 * that the user has provided.
 */
/**
 * Lab2_LinkedLists
 * @version 2.000
 * @author Tyron Corpuz
 * 1/29/2021
 */

import java.util.*;

public class SinglyLinkedListClass_Corpuz {
    static Node.listNode head;
    
    //This method will take the given list and data
    //and insert a node to the tail of the list.
    //If the list is empty, new node will be the head
    public static SinglyLinkedListClass_Corpuz
            insertAtTail(SinglyLinkedListClass_Corpuz list, String data)//supposed to be head
    {
        //Set a new node with the given data and set the
        //next to null
        Node.listNode new_node = new Node.listNode(data);
        new_node.next = null;
        
        //check if the list is empty, if so set the new node
        //to the head
        //else set the new node to the tail of the list
        if(list.head == null)
            list.head = new_node;
        else
        {
            Node.listNode last = list.head;
            while(last.next != null)
            {
                last = last.next;
            }
            last.next = new_node;
        }
        
        //return the list to the main method
        return list;
    }
    
    //This method will take the given list and remove the last node of the list
    //If empty, an error message will print out
    public static SinglyLinkedListClass_Corpuz
            removeAtTail(SinglyLinkedListClass_Corpuz list)
    {
        //check if the list is empty, if so print error message
        //else iterate through the list and remove the last element
        if(list.head == null)
            System.err.println("This list is empty! There is nothing to remove!");
        else
        {
            int count = 0;
            
            //create a new pointer called current
            Node.listNode current = list.head;
            
            //while loop to iterate over the list 
            //until it reaches the second last node
            while(count < listSize(list)-2)
            {
                current = current.next;
                count++;
            }
            
            //set the second last node to null which removes
            //the last node of the list
            current.next = null;
        }
        return list;
    }
    
    //This method will take the given list, data and position and insert a node to the specific position
    //If empty, the new node will be the head of the list 
    public static SinglyLinkedListClass_Corpuz
            insertAtPosition(SinglyLinkedListClass_Corpuz list, String data, int position)
    {
        //create a new node and set its next to null
        Node.listNode new_node = new Node.listNode(data);
        new_node.next = null;
        
        if(list.head == null)
            list.head = new_node;
        else
        {
            //create a new pointer to the head of the list
            Node.listNode previous = list.head;
            int count = 0;

            //while loop to iterate over the list
            while(count < position-1)
            {
                previous = previous.next;
                count++;
            }
            
            //once reached at location i, create a current pointer to the previous' next
            Node.listNode current = previous.next;
            //set the new node's next to current
            new_node.next = current;
            //sett previous' next to new node
            previous.next = new_node;
        }
        return list;
    }
    
            
    //This method will take the given list and remove an element at a specific
    //location i
    public static SinglyLinkedListClass_Corpuz
            removeAtPosition(SinglyLinkedListClass_Corpuz list, int position)
    {
        //check if the list is empty, if so set the new node
        //to the head
        //else set the new node to the tail of the list
        if(position == 0)
        {
            //set a current pointer to the node after head
            Node.listNode current = list.head.next;
            //set the head to the current node
            list.head = current;
            
            return list;
        }
        else
        {
            int count = 0;
            //create new pointer to head of the list
            Node.listNode previous = list.head;
            //while loop to iterate over the list
            while(count < position-1)
            {
                previous = previous.next;
                count++;
            }
            //once reached to location i
            //create new pointer to previous' next
            Node.listNode current = previous.next;
            //set the previous next to current's next
            previous.next = current.next;
            //set current's next to null
            current.next = null;
        }
        return list;
    }

    //This method will take the given list and print it to console
    public static void printList(SinglyLinkedListClass_Corpuz list)
    {
        //create the current pointer and print the current node
        //iterate over the list repeating this process untill null
        Node.listNode currNode = list.head;
        System.out.print("\nCorpuz's Linked List: ");
        
        while(currNode != null)
        {
            System.out.print(currNode.data + " ");
            
            currNode = currNode.next;
        }
        System.out.print("\n\n");
    }
    
    //This method will take the given list and return its size
    public static int listSize(SinglyLinkedListClass_Corpuz list)
    {
        //if the list is empty, return 0
        if(list.head == null)
            return 0;

        int count = 0;
        //create a new pointer to the head of the list 
        Node.listNode current = list.head;
        //while loop to iterate over the list 
        while(current != null)
        {
            current = current.next;
            //increment count each interation
            count++;
        }
        return count;
    }
    
    //This method prints out the menu for the user
    public static int DisplayUserMenu()
    {
        //create a new object scanner
        Scanner sc = new Scanner(System.in);
        
        //Prints out the user menu
        System.out.println("\nPlease select one of the following:");
        System.out.println("1 - Print List\n"
                + "2 - Add to tail of list\n"
                + "3 - Add to location i\n"
                + "4 - Remove from tail of list\n"
                + "5 - Remove at location i\n"
                + "6 - Cancel and exit the program");
        
        //read in the userinput and return it to the main function
        int userInput = sc.nextInt();
        return userInput;
    }
}