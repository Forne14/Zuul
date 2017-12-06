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

    public void addToRoomsVisited(Room room)
    {
       roomsVisited.push(room);
    }
    
    public Room removeFromRoomsVisited()
    {
        return roomsVisited.pop();
    }
    
    public boolean isStackEmpty()
    {
        return roomsVisited.empty();
    }
    
    public void addToInventory(Items item)
    {
        playerInventory.add(item);
    }
    
    public void addToWallet(double money)
    {
        wallet += money;
        NumberFormat moneyformat = NumberFormat.getCurrencyInstance();
        String moneyString = moneyformat.format(wallet);
        System.out.println(moneyString + " has been added to your wallet");
    }
    
    public void removeFromWallet(double money)
    {
        wallet -= money;
        NumberFormat moneyformat = NumberFormat.getCurrencyInstance();
        String moneyString = moneyformat.format(wallet);
        System.out.println(moneyString + " has been removed to your wallet");
    }
    
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
    
    public int getMaxInvWeight()
    {
        return maxInventoryWeight;
    }
    
    public double getWalletAmount()
    {
        return wallet;
    }
}
