import java.util.ArrayList;
/**
 * Write a description of class Characters here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Characters
{
    String name;
    boolean hasDialogue;
    private ArrayList<Items> itemList; 
    Dialogue speech;
    
   
    public Characters(String name, Boolean hasDialogue)
    {
        this.name = name;
        this.hasDialogue = hasDialogue;
        itemList = new ArrayList<>();
        speech = new Dialogue();
    }
    
    public String getName()
    {
        return name;
    }
    
    public boolean getHasDialogue() 
    {
        return hasDialogue;
    }
    
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
