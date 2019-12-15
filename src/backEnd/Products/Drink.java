package backEnd.Products;

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
        switch(this.size){
            case small: return 1.00;
            case medium: return 1.50;
            case large: return 2.00;
        }
        return 0;
    }
    

}