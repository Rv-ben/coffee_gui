package backEnd.Products;

import backEnd.enums.DrinkTypes;
import backEnd.enums.Sizes;
import backEnd.Products.DrinkPrices;

public class Tea extends Drink {
	DrinkTypes spec;
	
	double sweetness;
	
    public Tea(Sizes size,DrinkTypes spec,double sweetness){
        super("Tea", size);
		this.spec = spec;
		this.sweetness = sweetness;
    }

    public double getCost(){
    	double cost = super.getCost();
    	
    		cost += DrinkPrices.getCost(spec);
    	
        return cost;
    }
    public String getDescription(){
    	
       return spec.name() + " Sweetness: "+ sweetness+ "\n";
    }
}