/**
 * Program: Unit5Assignment
 * Name: Jose Jesus II Abejo
 * Date: November 2nd, 2020
 * Description: this is supposed to simulate a shop with different orders
 */
package unit6assignment;

import java.util.Scanner;
import java.util.ArrayList;

public class Unit6Assignment {

    public static Scanner scanN = new Scanner(System.in);
    public static Scanner scanS = new Scanner(System.in);
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException
    {
        //declaring variables
        ArrayList<Order> orders = new ArrayList<>();
        
        int choice;
        boolean done = false;
        
        //user menu interface
        do 
        {
            System.out.println("Welcome to the shoppe de despacito!, what would "
                    + "you like to do?\n1) View Orders\n2) Add Order\n3) Delete "
                    + "Order\n4) Calculate total profit\n5) Exit");
            
            if (scanN.hasNextInt()) 
            {
                choice = scanN.nextInt();

                clearScreen(); 
                
                switch(choice)
                {
                    //View Orders
                    case 1:
                        viewOrders(orders);
                        break;
                    //Add Orders
                    case 2:
                        orders.add(addOrders());
                        break;
                    //Delete Order
                    case 3:
                        deleteOrder(orders);
                        break;
                    //calculate total profit
                    case 4:
                        clearScreen();
                        System.out.println("Total profit of all your orders "
                                + "are $" + calcTotal(orders));
                        Thread.sleep(1000);//waits for one seconds
                        break;
                    //user exit
                    case 5:
                        done = true;
                        System.out.println("Good bye!");
                        break;
                    //if user did not choose any available number
                    default:
                        System.out.println("plaese input a valid number");
                        break;
                }
            }
            //if user chooses anything but an int
            else
            {
                scanN.nextLine();
                clearScreen();
                System.out.println("Please input a number");
                Thread.sleep(1500);//waits for one and a half seconds
            }
        } while (!done);
    }//end of main
    
    /**
     * viewOrders
     * This method will look through the ArrayList objects and let user choose 
     * to look at at any of their state
     * @param orders - a list of all the orders created
     * @throws java.lang.InterruptedException
     */
    public static void viewOrders(ArrayList<Order> orders)
            throws InterruptedException
    {
        //declaring local variables
        int choice;
        boolean done = false;
        
        //checks if the list is not empty
        if (!orders.isEmpty()) 
        {
            //error trap
            do 
            {
                //prints out everything from the arrayList
                for (int i = 0; i < orders.size(); i++) 
                {
                    System.out.println(i + ". " + orders.get(i).getName());
                }

                System.out.println("Which order would you like to look at?");

                //makes sure that the scanner has a int
                if (scanN.hasNextInt()) 
                {
                    choice = scanN.nextInt();
                    //prints info of chosen costomer
                    if (choice < orders.size()) 
                    {
                        clearScreen();
                        System.out.println(orders.get(choice).toString());
                        Thread.sleep(1500);//waits for 1 and a half seconds
                        done = true;
                    }
                    //number that is over the list range
                    else
                    {
                        clearScreen();
                        System.out.println("please type a valid number");
                        Thread.sleep(1500);//waits for one and a half seconds
                    }    
                }
                //if user inputs anything but a int
                else
                {
                    clearScreen();
                    scanN.nextLine();
                    System.out.println("Please type in a number");
                    Thread.sleep(1500);//waits for one and a half seconds
                }
            } while (!done);
        }
        //if the list does not have any objects
        else
        {
            clearScreen();
            System.out.println("There is no order set. please create one :^)");
            Thread.sleep(1500);//waits for one and a half seconds
        }
    }//end of viewOrders 
    
    /**
     * addOrders
     * This method will alow the user to add an order(getData)
     * @return returns a new order object
     * @throws java.lang.InterruptedException
     */
    public static Order addOrders() throws InterruptedException
    {
        //declaring local variables
        String name, drink;
        int size;
        boolean done = false;
       
        //user input, their name 
        System.out.println("What is the name of this customer?");
        name = scanS.nextLine();
        
        //user input, their drink
        do 
        {
            clearScreen();
            System.out.println("What kind of juice would they like to order?"
                    + "[Apple/Orange/Pickle]");
            
            drink = scanS.nextLine().toLowerCase();
            
            if (drink.equals("apple") || drink.equals("orange") 
                    || drink.equals("pickle") ) 
                done = true;
            else
            {
                clearScreen();
                System.out.println("Please choose an avaliable drink");
                Thread.sleep(1500); //waits for 1 second
            }
            

        } while (!done);
        
        //user input, their size
        while (true)
        {
            clearScreen();
            System.out.println("How many Litres would they like?");
            if (scanN.hasNextInt()) 
            {
                size = scanN.nextInt();
                //sets new order object
                return new Order(name, drink, size);
            }
            //if user inputs anything but a number
            else
            {
                scanN.nextLine();
                System.out.println("Please input numbers");
                Thread.sleep(1500);//waits for 1 and a half seconds
            }    
        }
        
    }//end of addOrders
    
    /**
     * deleteOrder
     * this will let the user delete any order from the array list
     * @param orders - a list of all the orders created
     * @throws java.lang.InterruptedException
     */
    public static void deleteOrder(ArrayList<Order> orders) 
            throws InterruptedException
    {
        //declaring local variables
        int choice;
        boolean done = false;
        //checks if the list is not empty
        if (!orders.isEmpty()) 
        {
            //error trap
            do 
            {
                //prints out everything from the arrayList
                for (int i = 0; i < orders.size(); i++) 
                {
                    System.out.println(i + ". " + orders.get(i).getName());
                }
                
                System.out.println("Which order would you like to delete?");

                //makes sure that the scanner has a int
                if (scanN.hasNextInt()) 
                {
                    choice = scanN.nextInt();
                    //prints info of chosen costomer
                    if (choice < orders.size()) 
                    {
                        clearScreen();
                        System.out.println("Good bye " 
                                + orders.get(choice).getName() + "'s order");
                        orders.remove(choice);
                        Thread.sleep(1500); //waits for one and a half seconds
                        done = true;
                    }
                    //number that is over the list range
                    else
                    {
                        clearScreen();
                        System.out.println("please type a valid number");
                        Thread.sleep(1500);//waits for one and a half seconds
                    }
                }
                //if user inputs anything but a int
                else
                {
                    scanN.nextLine();
                    clearScreen();
                    System.out.println("Please type in a number");
                    Thread.sleep(1500); //waits for one and a half seconds
                } 
            } while (!done);
        }
        //if there are no objects in the list
        else
        {
            clearScreen();
            System.out.println("There is no order set. please create one :^)");
            Thread.sleep(1500); //waits for one and a half seconds
        }
    }//end of deleteOrder
    
    /**
     * calcTotal
     * This method will calculate the total profit made 
     * @param orders - a list of all the orders created
     * @return 
     */
    public static int calcTotal(ArrayList<Order> orders)
    {
        //declaring local variables
        int cost = 0;
        for (int i = 0; i < orders.size(); i++) 
            cost += orders.get(i).calcPrice();
        return cost;
    }//end of CalcTotal
    
    /**
     * clearScreen
     * 
     * Clears the screen of the terminal line, makes it easier to see what the user
     * should be looking at/focusing on
     */
    public static void clearScreen()
    {
        //prints empty lines 351 times
        for (int i = 0; i < 35; i++) 
        {
            System.out.println("");    
        }  
    }//End of clearScreen    
}//end of class