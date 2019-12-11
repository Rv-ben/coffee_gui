package backEnd.enums;

import java.util.ArrayList;

/**
 * Struct class holding size and type of drink
 * @author Ruben Bramasco
 * @version 1.0.0
 * @since 11-30-2019
 */
public class Details{
    public Sizes size;
    public DrinkTypes type;
    public DrinkTypes spec;
    public boolean heated;
    public double sweetness;
    public PastryTypes pType;
    public PastryTypes special;
    public int qty;
    public ArrayList<ToppingTypes> toppings = new ArrayList<ToppingTypes>();
}