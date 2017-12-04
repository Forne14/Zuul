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
    private boolean usable;
    
     

    /**
     * Constructor for objects of class Items
     */
    public Items(String name, String description, int weight, double price, boolean usable)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.usable = usable;
    }
    
    
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getWeight(){
        return description;
    }
    
    public String getPrice(){
        NumberFormat moneyformat = NumberFormat.getCurrencyInstance();
        String itemPrice = moneyformat.format(price);
        return itemPrice;
    }
    
    
    
    
}
