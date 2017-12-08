import java.util.ArrayList;
import java.util.Stack;
import java.text.NumberFormat;

public class Player
{
    // instance variables - replace the example below with your own
    private int maxInventoryWeight;
    private double wallet;
    private Stack<Room> roomsVisited;
    private ArrayList<Items> playerInventory;
    
    

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        roomsVisited = new Stack<>();
        wallet = 0.0;
        maxInventoryWeight = 150;
        playerInventory = new ArrayList<>();
        
    }
    /***
     * method to return the size of the arraylist inventory
     * 
     * @return int
     */
    public int getInventorySize()
    {
        return playerInventory.size();
    }
    /***
     * this method adds the rooms passed into the parameters into the roomsVisited stack
     */
    public void addToRoomsVisited(Room room)
    {
       roomsVisited.push(room);
    }
    /***
     * this method removes the rooms passed into the parameters into the roomsVisited stack
     */
    public Room removeFromRoomsVisited()
    {
        return roomsVisited.pop();
    }
    /**
     * this method returns true if the roomsVisited stack is empty
     */
    public boolean isStackEmpty()
    {
        return roomsVisited.empty();
    }
    /***
     * this method adds the items passed into the parameters into the playerInventory arrayList 
     */
    public void addToInventory(Items item)
    {
        playerInventory.add(item);
    }
    /**
     * this method adds an amount of money given as type double into the wallet variable 
     * it also prints out a string
     */
    public void addToWallet(double money)
    {
        wallet += money;
        NumberFormat moneyformat = NumberFormat.getCurrencyInstance();
        String moneyString = moneyformat.format(wallet);
        System.out.println(moneyString + " has been added to your wallet");
    }
    /**
     * this method removes an amount of money given as type double from the wallet variable 
     * it also prints out a string
     */
    public void removeFromWallet(double money)
    {
        wallet -= money;
        NumberFormat moneyformat = NumberFormat.getCurrencyInstance();
        String moneyString = moneyformat.format(money);
        System.out.println(moneyString + " has been removed to your wallet");
    }
    /**
     * this method runs a loop on all items in the inventory and totals the collective weight of all items and returns it as an int
     * 
     * @return int
     */
    public int totalInventoryWeight() 
    {
        int inventoryWeight = 0;
        int weight;
        for(Items item : playerInventory)
        {
            weight = item.getWeight(); 
            inventoryWeight += weight;
        }
        return inventoryWeight;
    }
    /**
     * this method runs a loop on all items in the inventory and returns their name and description as a single string
     */
    public String showItemsInInventory()
    {
        String returnString = "Items:";
        for(Items i : playerInventory)
        {
            returnString += " " + i.getName() + " | " + i.getDescription() + "\n";
        }
        return returnString; 
    }
    /***
     * this method emptys the inventory
     */
    public void emptyInventory()
    {
        playerInventory.clear();
    }
    /***
     * this method returns the field variable as an int
     */
    public int getMaxInvWeight()
    {
        return maxInventoryWeight;
    }
    /***
     * this method returns the field variable as a double
     */
    public double getWalletAmount()
    {
        return wallet;
    }
    /***
     * this method returns the amount of money in the wallet as a formatted string
     */
    public String getWalletAmountAsString(){
        NumberFormat moneyformat = NumberFormat.getCurrencyInstance();
        String walletAmount = moneyformat.format(wallet);
        return walletAmount;
    }
}
