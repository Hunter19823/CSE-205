package projects.week1;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryItems = new ArrayList<String>();

    public void addGroceryItem(String item){
        this.groceryItems.add(item);
    }
    public ArrayList<String> getGroceryItems(){
        return this.groceryItems;
    }
    public void modifyGroceryItemByName(String name, String replacement)
    {
        int position = findItem(name);
        if(position>=0)
        modifyGroceryItemByName(position,replacement);
    }
    private void modifyGroceryItemByName(int index, String replacement)
    {
        this.groceryItems.set(index,replacement);
        System.out.println(String.format("Grociery item %d has been modified.",index+1));
    }

    public void removeGroceryItem(String item)
    {
        int position = findItem(item);
        if(position>=0)
        removeGroceryItem(position);
    }

    private void removeGroceryItem(int index)
    {
        this.groceryItems.remove(index);
        System.out.println(String.format("Grocery item %d has been removed.",index+1));
    }

    private int findItem(String searchItem){
        return this.groceryItems.indexOf(searchItem);
    }

    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        return (position >= 0);
    }

    public void printGroceryList(){
        System.out.println(String.format("You have %d items in your grocery list.",groceryItems.size()));
        for(int i=0;i<groceryItems.size();i++){
            System.out.println(String.format("%d. %s",i,groceryItems.get(i)));
        }
    }
}
