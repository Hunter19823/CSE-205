package projects.week1;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static GroceryList groceries = new GroceryList();

    public static void main(String[] args)
    {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceries.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
        scan.close();
    }

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\n0. Print choice options");
        System.out.println("\n1. Print grocery list");
        System.out.println("\n2. Add Item");
        System.out.println("\n3. Modify Item");
        System.out.println("\n4. Remove Item");
        System.out.println("\n5. Search for Item in list");
        System.out.println("\n6. Quit.");
    }
    public static void addItem(){
        System.out.print("Please enter the grocery item: ");
        groceries.addGroceryItem(scan.nextLine());
    }

    public static void modifyItem(){
        System.out.print("Current item name:  ");
        String inputItemName = scan.nextLine();
        System.out.print("Replacement item:  ");
        String replacementItemName = scan.nextLine();
        groceries.modifyGroceryItemByName(inputItemName,replacementItemName);
    }

    public static void removeItem(){
        System.out.print("Current item name:  ");
        String inputItemName = scan.nextLine();
        groceries.removeGroceryItem(inputItemName);
    }

    public static void searchForItem(){
        System.out.print("Item to search for:  ");
        String inputItemName = scan.nextLine();
        System.out.println("Item was "+(!groceries.onFile(inputItemName)? "not " : "")+"found.");
    }

}
