import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Items> itemList;     // stores items of this room
    private ArrayList<Characters> characterList; //stores characters of this room
    private static ArrayList<Room> teleportRooms;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        itemList = new ArrayList<>();
        characterList = new ArrayList<>();
        teleportRooms = new ArrayList<>();
    } 
    
    public Items findItemName(String item)
    {
        for(int i = 0; i < itemList.size(); i++)
        {
            if(itemList.get(i).getName().equals(item))
            {
                return itemList.get(i);
            }
        }
        return null;
    }
    
    public Characters findCharacter(String npc)
    {
        for(int i = 0; i < characterList.size(); i++)
        {
            if(characterList.get(i).getName().equals(npc))
            {
                return characterList.get(i);  
            }
        }
        return null;
    }
    
    public static Room makeRandomRoom()
    {
        Random randomRoom = new Random();
        Room random = teleportRooms.get(randomRoom.nextInt(teleportRooms.size()));
        return random;
    }
    
    public void setRandomRoom(Room room)
    {
        teleportRooms.add(room);
    }
    
    public void setItem(Items items){
        itemList.add(items);
    }
    
    public void removeItem(String name)
    {
        itemList.remove(name);
        System.out.println("item has been removed");
    }
    
    public void setCharacters(Characters npc){
        characterList.add(npc);
    }
     
    public void removeCharacters(Characters npc)
    {
        characterList.remove(npc);
        System.out.println("item has been removed");
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + ".\n" + getItemString() + ".\n" + getCharacterString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    public String getExitString() 
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit + ", ";
        }
        return returnString;
    }
    
    public String getItemString()
    {
        String returnString = "Items:";
        for(Items i : itemList){
            returnString += " " + i.getName() + ", " ;
        }
        return returnString;
    }
    
    public String getCharacterString()
    {
        String returnString = "Characters:";
         for(Characters i : characterList){
            returnString += " " + i.getName() + ", ";
        }
        return returnString;
    }
    
    

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

