/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd.Decorators;

import backEnd.Products.Drink;
import backEnd.enums.ToppingTypes;

/**
 *
 * @author tansr
 */
public class CoconutJelly extends Topping {
    
    public CoconutJelly(Drink base){
        super(base);
    }

    @Override
    public String getDescription() {
        return base.getDescription() + "Added: Coconut Jelly\n";
    }

    @Override
    public double getCost() {
        return base.getCost() + ToppingPrices.getCost(ToppingTypes.coconutJelly);
    }
}
