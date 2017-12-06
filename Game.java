
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
    private Player player;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player();
        play();
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
        yourRoom = new Room("in your bedroom");
        hallway = new Room("in the hallway");
        toilet = new Room("in the bathroom");
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
        
        hallway.setExit("bedroom",yourRoom);
        hallway.setExit("front_room",livingRoom); 
        hallway.setExit("mums_room",mumsRoom); 
        hallway.setExit("toilet",toilet); 
        hallway.setExit("kitchen",kitchen); 
        hallway.setExit("outside",jackHererRoad); 
        
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
        entrance.setExit("aisle1",aisle1);
        entrance.setExit("aisle2",aisle2);
        entrance.setExit("aisle3",aisle3);
        entrance.setExit("aisle4",aisle4);
        
        aisle1.setExit("entrance",entrance);
        aisle1.setExit("aisle2",aisle2);
        aisle1.setExit("checkout",checkout);
        
        aisle2.setExit("entrance",entrance);
        aisle2.setExit("aisle1",aisle1);
        aisle2.setExit("aisle3",aisle3);
        aisle2.setExit("checkout",checkout);
        
        aisle3.setExit("entrance",entrance);
        aisle3.setExit("aisle2",aisle2);
        aisle3.setExit("aisle4",aisle4);
        aisle3.setExit("checkout",checkout);
        
        aisle4.setExit("entrance",entrance);
        aisle4.setExit("aisle3",aisle3);
        aisle4.setExit("backroom",backRoom);
        aisle4.setExit("checkout",checkout);
        
        backRoom.setExit("4",aisle4);
        
        checkout.setExit("exit",entrance);
        checkout.setExit("aisle1",aisle1);
        checkout.setExit("aisle2",aisle2);
        checkout.setExit("aisle3",aisle3);
        checkout.setExit("aisle4",aisle4);
        
        //create items String name, String description, int weight, double price, boolean usable
        Items benz = new Items("benz", "a special herb. good for baking with",5,10.0,false,false);
        Items keys = new Items("keys", "your house keys",10,0.0,true, false);
        Items wallet = new Items("wallet", "your wallet",10,0,true,false);
        Items rice = new Items("rice", "plain bag of basmati rice",40,1.10,false,true);
        Items sprite = new Items("sprite", "a 1l bottle of the sprite beverage",50,0.99,false,true);
        Items chewingGum = new Items("gum", "a small pack of generic chewing gum. no flavor",8,1.0,false,true);
        Items specialBox = new Items("SPECIAL BOX", "a box of the finest [REDACTED]",1000,25000,false,true);
        Items ketchup = new Items("ketchup", "a bottle of ketchup",15,0.60,false,true);
        Items sweet = new Items("sweet", "a pack of haribos",5,1,false,true);
        Items teleporter = new Items("teleporter","it looks like a portal gun",0,0,true,false);
        
        //add items to rooms
        
        //home
        yourRoom.setItem(keys);
        toilet.setItem(wallet);
        
        //shop
        aisle1.setItem(rice);
        aisle2.setItem(ketchup);
        aisle3.setItem(sprite);
        aisle4.setItem(chewingGum);
        aisle4.setItem(sweet);
        backRoom.setItem(teleporter);
        
        currentRoom = yourRoom;  // start game outside
        
        //creates characters and puts them into rooms
        Characters mum = new Characters("mum", true);
        Characters roadman = new Characters("roadman",true);
        Characters bossman = new Characters("bossman",true);
        
        livingRoom.setCharacters(mum);
        ammiWay.setCharacters(roadman);
        checkout.setCharacters(bossman);
        
        //adds specified rooms to the random room arrayList
        currentRoom.setRandomRoom(yourRoom); 
        currentRoom.setRandomRoom(hallway);
        currentRoom.setRandomRoom(toilet);
        currentRoom.setRandomRoom(mumsRoom);
        currentRoom.setRandomRoom(kitchen);
        currentRoom.setRandomRoom(livingRoom);
        currentRoom.setRandomRoom(kitchen);
        currentRoom.setRandomRoom(jackHererRoad);
        currentRoom.setRandomRoom(ammiWay);
        currentRoom.setRandomRoom(entrance);
        currentRoom.setRandomRoom(aisle1);
        currentRoom.setRandomRoom(aisle2);
        currentRoom.setRandomRoom(aisle3);
        currentRoom.setRandomRoom(aisle4);
        currentRoom.setRandomRoom(checkout);
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
       
       else if (commandWord.equals("back")) {
           back();
       }
       
       else if (commandWord.equals("take")) {
           take(command);
       }
       
       else if (commandWord.equals("purchase")) {
           purchase(command);
       }
       else if (commandWord.equals("talk")) {
           talk(command);
       }
       else if (commandWord.equals("show")){
           show(command);
        }
      
        
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
        System.out.println("around the area");
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

        String direction = command.getSecondWord().toLowerCase().trim();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else if(nextRoom.getShortDescription().equals("trespassing!"))
        {
            currentRoom = Room.makeRandomRoom();  
            System.out.println("Dont panic! you have been teleported to a random room!!!");
            System.out.println(currentRoom.getLongDescription());
        }
        else {
            player.addToRoomsVisited(currentRoom);
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
    
    private void back()
    {
        if (player.isStackEmpty())
            {
                System.out.println("you need to visit a room before you go back!!");
            }
            else
            {
                currentRoom = player.removeFromRoomsVisited();
                System.out.println(currentRoom.getLongDescription());
            }
    }
    
    private void take(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }

        String itemName = command.getSecondWord().toLowerCase().trim();
        Items items = currentRoom.findItemName(itemName);
        if (itemName == null)
        {
            System.out.println("This item doesnt exist, please try again");
        }
        else if(!items.isTakeable())
        {
            System.out.println("you do not have the authority to take this item. try purchasing it instead?");
        }
        else if(player.totalInventoryWeight() + items.getWeight() <= player.getMaxInvWeight())
        {
            player.addToInventory(items);
            System.out.println(items.getName() + " has been added to your inventory");
        }
        else
        
        {
            System.out.println("You dont seem to be able to carry this item, its too heavy");
        }
    }
    
    private void purchase(Command command)
    {
       if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("purchase what?");
            return;
        } 
       
        String itemName = command.getSecondWord().toLowerCase().trim();
        Items items = currentRoom.findItemName(itemName);
        if (itemName == null)
        {
            System.out.println("This item doesnt exist, please try again");
        }
        else if(!items.isBuyable())
        {
            System.out.println("This item is not for sale. Try taking it instead?");
        }
        else if(player.totalInventoryWeight() + items.getWeight() <= player.getMaxInvWeight() && player.getWalletAmount() >= items.getPriceAsDub())
        {
            player.addToInventory(items);
            System.out.println(items.getName() + " has been bought and added to your inventory");
            System.out.println("Bossman: Thank you, come again!");
        }
        else
        {
            System.out.println("you either have insufficient funds to make this purchase or its too heavy");
        }
    }
    
    private void talk(Command command)
    {
       if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("talk to whom?");
            return;
        } 
       
        String characterName = command.getSecondWord().toLowerCase().trim();
        Characters npc = currentRoom.findCharacter(characterName);
        if (characterName == null)
        {
            System.out.println("This character doesnt seem to be here, please try again");
        }
        else if(npc.getHasDialogue() == true)  
        {
            if(characterName.equals("mum"))
            {
                npc.generateResponse(characterName); 
                player.addToWallet(5.0);
            }
            else if(characterName.equals("roadman"))
            {
                npc.generateResponse(characterName); 
                
            }
            else{npc.generateResponse(characterName); }
        }
        else
        {
            System.out.println("This person doesnt seem to want to talk.");
            
        }
    }
    
    private void show(Command command)
    {
       if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("show what");
            return;
        } 
       
        String hudDisplay = command.getSecondWord().toLowerCase().trim();
        /*if (hudDisplay.equals("items"))
        {
            System.out.println(currentRoom.getItemString());
        }
        else if(hudDisplay.equals("exits"))  
        {
            System.out.println(currentRoom.getExitString());
        }
        else if(hudDisplay.equals("characters"))  
        {
            System.out.println(currentRoom.getCharacterString()); 
        }
        else
        {
            System.out.println("What you want to see doesnt exist. remember you can only use show for items exits and characters");
            
        }*/
        switch (hudDisplay){
            case "items" : 
                            System.out.println(currentRoom.getItemString());
                            break;
            case "exits" :
                            System.out.println(currentRoom.getExitString());
                            break;
            case "characters" :
                            System.out.println(currentRoom.getCharacterString()); 
                            break;
            default:        System.out.println("What you want to see doesnt exist. remember you can only use show for items exits and characters");
                            break;
        }
    }
    
}
