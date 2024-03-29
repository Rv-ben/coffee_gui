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
public class PoppingBoba extends Topping {
    
    
    public PoppingBoba(Drink base){
        super(base);
    }

    @Override
    public String getDescription() {
        return base.getDescription() + "Added: Popping Boba\n";
    }

    @Override
    public double getCost() {
        return base.getCost() + ToppingPrices.getCost(ToppingTypes.poppingBoba);
    }
}
