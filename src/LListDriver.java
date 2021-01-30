/*
 * This class will handle decision making of which option they have chosen.
 * The user will be able to modify the lists by either adding an element
 * at the end of the list or a desired location or deleting an element
 * at the end of the list or at a desired location
 */
/**
 * Lab2_LinkedLists
 * @version 2.000
 * @author Tyron Corpuz
 * 1/29/2021
 */

import java.util.*;

public class LListDriver {
    
    public static void main(String[] args)
    {
        SinglyLinkedListClass_Corpuz SLlistCorpuz = new SinglyLinkedListClass_Corpuz();
        Scanner sc = new Scanner(System.in);
        int userInput = 0;
        String userProd = "";
        
        System.out.println("Welcome To Singly Linked Lists!");
        
        //while the user does not want to exit the program
        while(userInput != 6)
        {
            //try-catch block for InputMismatchException
            try
            {
                //print the display menu and recieve the user's input
                userInput = SinglyLinkedListClass_Corpuz.DisplayUserMenu();
                
                //error checking if-else statement to keep the user's input in range within the menu
                if(userInput < 1 || userInput > 6)
                {
                    System.err.print("You have entered an invalid option!");
                }
                else
                {
                    //switch statement to decide which option to execute
                    switch(userInput)
                    {
                        //case 1 prints the list
                        case 1:
                            SinglyLinkedListClass_Corpuz.printList(SLlistCorpuz);
                            break;
                            
                        //case 2 adds a node to the end of the list    
                        case 2:
                            //print out prompt
                            System.out.println("\nPlease enter a brand that you would like to add:");
                            
                            //try-catch blow for ImputMismatchException
                            try
                            {
                                //read in the user's input
                                userProd = sc.next();
                                
                                //call the insertAtTail method and pass the list and user's input
                                SinglyLinkedListClass_Corpuz.insertAtTail(SLlistCorpuz, userProd);
                            }
                            catch(InputMismatchException ime)
                            {
                                System.err.print("You have entered an invalid option!");
                            }
                            break;
                            
                        //case 3 adds a node to locaiton i    
                        case 3:
                            //print out prompt
                            System.out.println("\nPlease enter the index that you would like to add an element to:\n"
                                    + "(from 0 to " + (SinglyLinkedListClass_Corpuz.listSize(SLlistCorpuz)-1) + "):");
                            
                            //try-catch block for InputMismatchException
                            try
                            {
                                //read in the user input
                                userInput = sc.nextInt();

                                //error-checking if else to check if index is in range of the list size
                                if(userInput < 0 || userInput > SinglyLinkedListClass_Corpuz.listSize(SLlistCorpuz)-1)
                                    System.err.print("You have entered an invalid answer!");
                                else
                                {
                                    //print out prompt to add to the list
                                    System.out.println("\nPlease enter a brand that you would like to add:");
                                    //try-catch block for InputMismatchException
                                    try
                                    {
                                        //read in the user's input
                                        userProd = sc.next();

                                        //call the insertAtPosition method
                                        SinglyLinkedListClass_Corpuz.insertAtPosition(SLlistCorpuz, userProd, userInput);
                                    }
                                    catch(InputMismatchException ime)
                                    {
                                        System.err.print("You have entered an invalid answer!");
                                    }
                                }
                            }
                            catch(InputMismatchException ime)
                            {
                                System.err.print("You have entered an invalid option!");
                            }
                            
                            break;
                        
                        //case 4 removes the node at the tail of the list 
                        case 4:
                            //call the removeAtTail method
                            SinglyLinkedListClass_Corpuz.removeAtTail(SLlistCorpuz);
                            //Print out the confirmation message that the tail hs been removed
                            break;
                        
                        //case 5 removes the node at location i    
                        case 5:
                            //if statement to check if the list is empty
                            if(SinglyLinkedListClass_Corpuz.head == null)
                            {
                                System.err.println("This list is empty! There is nothing to remove!");
                                break;
                            }
                            
                            //Print out the prompt
                            System.out.println("\nPlease enter the index that you would like to remove an element:\n"
                                    + "(from 0 to " + (SinglyLinkedListClass_Corpuz.listSize(SLlistCorpuz)-1) + "):");
                            
                            //try-catch block for InputMismatchException
                            try
                            {
                                //read in the user's input
                                userInput = sc.nextInt();
                                if(userInput < 0 || userInput > SinglyLinkedListClass_Corpuz.listSize(SLlistCorpuz)-1)
                                    System.err.print("You have entered an invalid answer!");
                                else
                                {
                                    //call the removeAtPosition method passing the list and user's input
                                    SinglyLinkedListClass_Corpuz.removeAtPosition(SLlistCorpuz, userInput);
                                }
                            }
                            catch(InputMismatchException ime)
                            {
                                System.err.print("You have entered an invalid option!");
                            }
                            break;
                    }
                }
            }
            catch(InputMismatchException ime)
            {
                System.err.println("You have entered an invalid answer!");
            }
        }
        System.out.print("\nProgram is now ending!");
    }
}
