 import java.text.NumberFormat;
/**
 * Write a description of class Items here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
    
    
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public int getWeight(){
        return weight; 
    }
    
    public String getPrice(){
        NumberFormat moneyformat = NumberFormat.getCurrencyInstance();
        String itemPrice = moneyformat.format(price);
        return itemPrice;
    }
    
    public double getPriceAsDub()
    {
        return price;
    }
    
    public boolean isTakeable(){
        return takeable;
    }
    
    public boolean isBuyable(){
        return buyable;
    }
    
    
    
    
}
