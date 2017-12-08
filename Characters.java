import java.util.ArrayList;
/**
 * This class is part of the "Living in the ends" application. 
 * "Living in the ends" is a very simple, text based adventure game.  
 * 
 * this class represents a character in the game. characters have item lists and can give you items and money.
 * a character also has dialogue with which they can give responses to the palyer
 *

 * @author  Yassine Lutumba 
 * @version @version 2017.12.08
 */
public class Characters
{
    String name;
    boolean hasDialogue;
    private ArrayList<Items> itemList; 
    Dialogue speech;
    
    /***
     * this constructer builds a character and creates the arraylist object
     */
    public Characters(String name, Boolean hasDialogue)
    {
        this.name = name;
        this.hasDialogue = hasDialogue;
        itemList = new ArrayList<>();
        speech = new Dialogue();
    }
    /***
     * returns the characters name
     */
    public String getName()
    {
        return name;
    }
    /**
     * returns true if the character has dialogue
     */
    public boolean getHasDialogue() 
    {
        return hasDialogue;
    }
    /**
     * generates the win condition dialogue for the character
     */
    public void generateWinDialogue()
    {
         speech.mumDialogueFinal();
    }
    /**
     * checks to see which character is being talked to and returns their response
     */
    public void generateResponse(String npc) 
    {
         switch(npc)
         {
             case "mum": speech.mumDialogueIntro();
             break;
             case "roadman": speech.roadmanDialogue();
             break;
             
            }
    }
}
