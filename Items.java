 import java.text.NumberFormat;
/**
 * This class is part of the "Living in the ends" application. 
 * "Living in the ends" is a very simple, text based adventure game
 * 
 * this item class represents an item of this game. an item can be a food product, a wallet or even keys.
 * items have a name a description a weight a price and flags which are used when taking and purchasing
 * @author Yassine Lutumba
 * @version 2017/12/08
 */
public class Items
{
    private int weight;
    private String description;
    private String name;
    private double price;
    private boolean takeable;
    private boolean buyable;
    
     

    /**
     * Constructor for objects of class Items
     */
    public Items(String name, String description, int weight, double price, boolean takeable, boolean buyable)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.takeable = takeable;
        this.buyable = buyable;
        
    }
    
    
    /***
     * method to return the item name
     * 
     * @return String
     */
    public String getName(){
        return name;
    }
    /***
     * method to return the item description
     * 
     * @return String
     */
    public String getDescription(){
        return description;
    }
    /***
     * method to return the item weight
     * 
     * @return int
     */
    public int getWeight(){
        return weight; 
    }
    /***
     * method to return the item price as a string with a £
     * 
     * @return String
     */
    public String getPrice(){
        NumberFormat moneyformat = NumberFormat.getCurrencyInstance();
        String itemPrice = moneyformat.format(price);
        return itemPrice;
    }
    /***
     * method to return the item price as a double type
     * 
     * @return double
     */
    public double getPriceAsDub()
    {
        return price;
    }
    /***
     * method returns true if the item is takeable
     * return boolean
     */
    public boolean isTakeable(){
        return takeable;
    }
    /***
     * method returns true if the item is buyable
     * return boolean
     */
    public boolean isBuyable(){
        return buyable;
    }
    
    
    
    
}
