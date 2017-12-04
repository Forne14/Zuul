import java.util.ArrayList;
import java.util.Stack;

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
    
}