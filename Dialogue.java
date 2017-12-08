
/**
 *  This class is part of the "Living in the ends" application. 
 * "Living in the ends" is a very simple, text based adventure game
 * 
 * this dialogue class contains methods which returns dialogue as a string
 *
 * @author Yassine Lutumba
 * @version 2017/12/08)
 */
public class Dialogue
{
    // instance variables - replace the example below with your own
    

    /**
     * this constructer is empty.
     */
    public Dialogue()
    {
        
    }
    /**
     * generates dialogue for the roadman
     */
    public  void roadmanDialogue() 
    {
        print("whats good my g, you want some food?" );
        print("yo take this, only costs £10");
    }
    /**
     * generates dialogue for the mum at the end of the game
     */
    public void mumDialogueFinal()
    {
        print("Thank you baby! i do appreciate you taking the time to do this for me");
    }
    /**
     * generates dialogue for the mum at the beginning of the game
     */
    public  void mumDialogueIntro() 
    {
        print("Mum: Hello baby, I need you to go to the store and buy some items");
        print("I've talked to bossman and he's reserved all the items you want. go to the store and buy them please");
        print("Heres some money");
    }
    /***
     * bad habit programming method
     */
    public  void print(String p)
    {
        System.out.println(p);
    }
}
