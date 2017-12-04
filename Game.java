
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    
    
    
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
         Room 
            //Home
                yourRoom, 
                hallway, 
                toilet, 
                mumsRoom, 
                kitchen,
                fridge,
                livingRoom,
             //Outside
                jackHererRoad,
                ammiWay,
             //Shop
                entrance,
                checkout,
                aisle1,
                aisle2,
                aisle3,
                aisle4,
                backRoom;
             
        // create the rooms
        
        //Home
        yourRoom = new Room("in your bedroom. have a nap?");
        hallway = new Room("in the hallway");
        toilet = new Room("sittin' on da toilet dropping a few carepackages");
        mumsRoom = new Room("in mums room");
        kitchen = new Room("in the kitchen");
        fridge = new Room("looking for something in an empty fridge");
        livingRoom = new Room("in the living room");
        
        //Outside
        jackHererRoad = new Room("outside on JackHerer Road next to your home");
        ammiWay = new Room("on Ammi Way next to the shop");
        
        //Shop
        entrance = new Room("just entering the shop");
        checkout = new Room(" at the checkouts");
        aisle1 = new Room("in Aisle 1: Confectionary");
        aisle2 = new Room("in Asile 2: Drinks");
        aisle3 = new Room("in Aisle 3: Sauces");
        aisle4 = new Room("in Aisle 4: startch and other carbs");
        backRoom = new Room("trespassing!");
        
        // initialise room exits
        yourRoom.setExit("hallway",hallway);
        
        hallway.setExit("1",yourRoom);
        hallway.setExit("2",livingRoom); 
        hallway.setExit("3",mumsRoom); 
        hallway.setExit("4",toilet); 
        hallway.setExit("5",kitchen); 
        hallway.setExit("6",jackHererRoad); 
        
        toilet.setExit("hallway",hallway); 
        
        mumsRoom.setExit("hallway",hallway); 
        
        kitchen.setExit("hallway",hallway);
        kitchen.setExit("fridge",fridge);
        
        fridge.setExit("kitchen",kitchen);
        
        livingRoom.setExit("hallway",hallway);
        //Outside
        jackHererRoad.setExit("east",ammiWay);
        jackHererRoad.setExit("home",hallway);
        
        ammiWay.setExit("west",jackHererRoad);
        ammiWay.setExit("east",entrance);
        //Shop
        entrance.setExit("west",ammiWay);
        entrance.setExit("1",aisle1);
        entrance.setExit("2",aisle2);
        entrance.setExit("3",aisle3);
        entrance.setExit("4",aisle4);
        
        aisle1.setExit("entrance",entrance);
        aisle1.setExit("2",aisle2);
        aisle1.setExit("checkout",checkout);
        
        aisle2.setExit("entrance",entrance);
        aisle2.setExit("1",aisle1);
        aisle2.setExit("3",aisle3);
        aisle2.setExit("checkout",checkout);
        
        aisle3.setExit("entrance",entrance);
        aisle3.setExit("2",aisle2);
        aisle3.setExit("4",aisle4);
        aisle3.setExit("checkout",checkout);
        
        aisle4.setExit("entrance",entrance);
        aisle4.setExit("3",aisle3);
        aisle4.setExit("Backroom",backRoom);
        aisle4.setExit("checkout",checkout);
        
        backRoom.setExit("4",aisle4);
        
        checkout.setExit("exit",entrance);
        checkout.setExit("1",aisle1);
        checkout.setExit("2",aisle2);
        checkout.setExit("3",aisle3);
        checkout.setExit("4",aisle4);
        
        //create items String name, String description, int weight, double price, boolean usable
        Items benz = new Items("benz", "a special herb. good for baking with",5,10.0,true);
        Items keys = new Items("keys", "your house keys",10,0.0,true);
        Items wallet = new Items("wallet", "your wallet",10,0,false);
        Items rice = new Items("rice", "plain bag of basmati rice",40,1.10,false);
        Items sprite = new Items("Sprite", "a 1l bottle of the sprite beverage",50,0.99,false);
        Items chewingGum = new Items("chewing gum", "a small pack of generic chewing gum. no flavor",8,1.0,false);
        Items specialBox = new Items("SPECIAL BOX", "a box of the finest [REDACTED]",1000,25000,true);
        Items ketchup = new Items("Ketchup", "a bottle of ketchup",15,0.60,false);
        Items sweet = new Items("Sweet", "a pack of haribos",5,1,false);
        
        //add items to rooms
        
        //home
        yourRoom.setItem("Keys", keys);
        toilet.setItem("Wallet", wallet);
        
        //shop
        aisle1.setItem("Rice",rice);
        aisle2.setItem("Ketchup", ketchup);
        aisle3.setItem("Sprite", sprite);
        aisle4.setItem("Chewing gum", chewingGum);
        aisle4.setItem("Sweets", sweet);
        
        

        currentRoom = yourRoom;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Living in the ends!");
        System.out.println("Living in the ends is a new, incredibly engaging RPG game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
       /*
        else if (commandWord.equals("back")) {
           goRoom("");
       }
       else if (commandWord.equals("pick up")) {
           goRoom("");
       }
       else if (commandWord.equals("purchase")) {
           goRoom("");
       }
       */
        
      // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
