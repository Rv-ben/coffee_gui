/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd.Decorators;

import backEnd.Decorators.Topping;
import backEnd.Decorators.ToppingPrices;
import backEnd.Products.Drink;
import backEnd.enums.ToppingTypes;

/**
 *
 * @author tansr
 */
public class Milk extends Topping {
    	
   	
    public  Milk(Drink base ) {
        super(base);
    }

    public double getCost(){
    	return base.getCost() + ToppingPrices.getCost(ToppingTypes.milk);
    }

    public String getDescription(){
        return base.getDescription() +  "\nAdded : " + ToppingTypes.milk.toString() + "\n";
    }
}
