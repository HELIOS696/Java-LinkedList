/*
 * This class will contain the node creation of the list
 * It will take the data that the user has inputted and 
 * store it in a node with a pointer pointing at null
 */
/**
 * Lab2_LinkedLists
 * @version 1.000
 * @author Tyron Corpuz
 * 1/29/2021
 */
public class Node {
    
    static class listNode
    {
        String data;
        listNode next;
        
        //Create the constructor that takes in
        //the given data
        listNode(String d)
        {
            data = d;
            next = null;
        }
    }
    
}
