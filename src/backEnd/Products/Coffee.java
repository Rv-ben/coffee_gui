package backEnd.Products;

import backEnd.enums.DrinkTypes;
import backend.Products.DrinkPrices;
import backEnd.enums.Sizes;

public class Coffee extends Drink {

	DrinkTypes spec;
	
    public Coffee(Sizes size,DrinkTypes spec){
        super("Coffee", size);
        this.spec = spec;
    }
  
    
   //
   //
   //
        @Override
    public double getCost(){
    	double cost = super.getCost();
    	return cost + DrinkPrices.getCost(this.spec);
    }

        @Override
    public String getDescription(){
        return spec.name() + "\n";
    }
}

//test