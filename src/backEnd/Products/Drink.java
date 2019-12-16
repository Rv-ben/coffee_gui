package backEnd.Products;

import backEnd.enums.DrinkTypes;
import backEnd.enums.Sizes;

public abstract class Drink implements Product {
    
    String name;

    Sizes size;


    public Drink(){

    }

    public Drink(String name, Sizes size){
        this.name = name;
        this.size = size;
    }
    //default s 1 , m 1.50, L 2
    public double getCost(){
       return DrinkPrices.getCost((DrinkTypes.valueOf(size.toString())));
       
    }
    

}